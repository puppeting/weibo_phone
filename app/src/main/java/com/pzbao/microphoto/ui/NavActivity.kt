package com.pzbao.microphoto.ui

import android.content.Context
import android.view.MotionEvent
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavGraph
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import com.alibaba.android.arouter.facade.annotation.Autowired
import com.alibaba.android.arouter.facade.annotation.Route
import com.hwangjr.rxbus.RxBus
import com.hwangjr.rxbus.annotation.Subscribe
import com.hwangjr.rxbus.annotation.Tag
import com.hwangjr.rxbus.thread.EventThread
import com.pzbao.microphoto.R
import com.pzbao.microphoto.base.BaseActivity
import com.pzbao.microphoto.base.MyBaseFragment
import com.pzbao.microphoto.config.Constants
import com.pzbao.microphoto.databinding.ActivityGraphNavBinding
import com.pzbao.microphoto.model.ApplyModel
import com.pzbao.microphoto.utils.SZWUtils
import com.pzbao.microphoto.utils.StatusBarUtil


@Route(path = "/com/NavActivity")
class NavActivity : BaseActivity() {
    @Autowired
    @JvmField
    var jsonObject = ""

    @Autowired
    @JvmField
    var seeOnly = false

    @Autowired
    @JvmField
    var businessType = ApplyModel.BUSINESS_TYPE_APPLY

    @Autowired
    @JvmField
    var title = "0"


    @Autowired
    @JvmField
    var creditId = ""
    @Autowired
    @JvmField
    var dhId = ""
    @Autowired
    @JvmField
    var ysxId = ""
    @Autowired
    @JvmField
    var keyId = ""

    override fun initToolbar() {
        StatusBarUtil.darkMode(this)
        StatusBarUtil.setPaddingSmart(this, dataBind.actionBarCustom.appBar)
        dataBind.actionBarCustom.toolbar?.title = title
    }

    lateinit var dataBind: ActivityGraphNavBinding
    override fun setInflateBinding() {
        dataBind = DataBindingUtil.setContentView<ActivityGraphNavBinding>(this, R.layout.activity_graph_nav)
            .apply {
                lifecycleOwner = this@NavActivity
            }
    }

    override fun onSupportNavigateUp(): Boolean {
        return Navigation.findNavController(this, R.id.nav_host_fragment)
            .navigateUp() || super.onSupportNavigateUp()
    }

    lateinit var viewModel: ApplyModel
    override fun init() {
        viewModel = ViewModelProvider(this).get(ApplyModel::class.java)
        ViewModelProvider(this).get(ApplyModel::class.java).apply {
            title = this@NavActivity.title
            creditId = this@NavActivity.creditId
            dhId = this@NavActivity.dhId
            ysxId = this@NavActivity.ysxId
            keyId = this@NavActivity.keyId
            jsonObject = this@NavActivity.jsonObject
            seeOnly = this@NavActivity.seeOnly
            businessType = this@NavActivity.businessType
            viewModel.title = this@NavActivity.title
            viewModel.creditId = this@NavActivity.creditId
            viewModel.dhId = this@NavActivity.dhId
            viewModel.ysxId = this@NavActivity.ysxId
            viewModel.keyId = this@NavActivity.keyId
            viewModel.jsonObject = this@NavActivity.jsonObject
            viewModel.seeOnly = this@NavActivity.seeOnly
            viewModel.businessType = this@NavActivity.businessType
        }
//        Watermark.instance?.show(this, "Fantasy BlogDemo")
        dataBind.actionBarCustom.toolbar.setNavigationOnClickListener {
            finish()
        }
        val navHostFragment: NavHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navGraph: NavGraph = navHostFragment.navController.navInflater.inflate(R.navigation.nav_graph_single)
        navGraph.setStartDestination(getActionByTitle(title))
        navHostFragment.navController.graph = navGraph
    }

    /**
    登录后刷新数据，
     */
    @Subscribe(thread = EventThread.MAIN_THREAD, tags = [Tag(Constants.BusAction.Bus_LoginSuccess)])
    fun loginSuccess(str: String) {
        ((supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment?)?.childFragmentManager?.primaryNavigationFragment as? MyBaseFragment)?.refreshData()
    }

    private fun getActionByTitle(title: String): Int = when (title) {
        "暂未开发" -> {
            R.id.EmptyFragment
        }


        else -> R.id.EmptyFragment
    }

    override fun dispatchTouchEvent(ev: MotionEvent): Boolean {
        if (ev.action == MotionEvent.ACTION_DOWN) {
            val v = currentFocus
            if (SZWUtils.isShouldHideKeyboard(v, ev)) {
                val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                imm.hideSoftInputFromWindow(v?.windowToken, InputMethodManager.HIDE_NOT_ALWAYS)
                dataBind.viewOverlay.isFocusable = true
                dataBind.viewOverlay.isFocusableInTouchMode = true
                dataBind.viewOverlay.requestFocus()
                (v as EditText).clearFocus()
            }
        }
        return super.dispatchTouchEvent(ev)
    }
    override fun onDestroy() {
        RxBus.get().post(Constants.BusAction.Bus_Refresh_List, Constants.BusAction.Bus_Refresh_List)
        super.onDestroy()
    }
}