package com.pzbao.microphoto.ui

import android.content.res.Configuration
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.hwangjr.rxbus.annotation.Subscribe
import com.hwangjr.rxbus.annotation.Tag
import com.hwangjr.rxbus.thread.EventThread


import com.pzbao.microphoto.base.MainNavigationFragment
import com.pzbao.microphoto.config.Constants

import com.pzbao.microphoto.databinding.FragmentMainBinding
import com.pzbao.microphoto.model.MainActivityModel
import com.pzbao.microphoto.utils.StatusBarUtil
import com.scwang.smart.refresh.layout.api.RefreshLayout
import com.scwang.smart.refresh.layout.listener.OnRefreshListener
import org.jetbrains.anko.support.v4.act

class MainFragment : MainNavigationFragment(), OnRefreshListener {
    lateinit var viewModel: MainActivityModel
    private var mLastClickTime: Long = 0
    private val TIME_INTERVAL = 500L
    var viewBind: FragmentMainBinding? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        viewModel = ViewModelProvider(act).get(MainActivityModel::class.java)
        if (viewBind == null) {
            viewBind = FragmentMainBinding.inflate(inflater, container, false).apply {
                data = viewModel
//                adapter = ItemMainAdapter(viewModel)
//                mRecyclerView.adapter = adapter
//                dbsxAdapter = ItemMainTextAdapter()
//                mRecyclerViewDbsx.adapter = dbsxAdapter
//                wdkhAdapter = ItemMainTextAdapter()
//                mRecyclerViewWdkh.adapter = wdkhAdapter
                lifecycleOwner = viewLifecycleOwner

            }
            oneInit()
        }
        viewBind?.lifecycleOwner = viewLifecycleOwner
        return viewBind?.root ?: View(context)
    }

    private fun oneInit() {
        StatusBarUtil.darkMode(act)
        StatusBarUtil.setPaddingSmart(act, viewBind?.actionBarCustom?.appBar)
//        viewBind?.mRefreshLayout?.setOnRefreshListener(this)
//        viewBind?.actionBarCustom?.toolbar?.logoResource = R.mipmap.ic_launcher
//        viewBind?.actionBarCustom?.toolbar?.menu?.add("欢迎您")?.apply {
//            setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS)
//            actionView = TextView(context).apply {
//                setPadding(15)
//                text = "欢迎您"
//            }
//
//        }
//        viewBind?.actionBarCustom?.toolbar?.menu?.add("用户中心")?.apply {
//            setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS)
//            actionView = TextView(context).apply {
//                setPadding(15)
//                text = "用户中心"
//                if (isAdded)
//                setCompoundDrawablesRelativeWithIntrinsicBounds(ContextCompat.getDrawable(context, R.drawable.ic_baseline_warning_24), null, null, null)
//                setOnClickListener {
//                    val popup = PopupMenu(act, this)
//                    // Inflating the Popup using xml file
//                    popup.menuInflater.inflate(R.menu.main_menu_toolbar_overflow, popup.menu)
//                    popup.show()
//                    popup.setOnMenuItemClickListener {
//                        when (it.itemId) {
////                            R.id.item_user -> {
////                                UserInfoPop(context).showPopupWindow()
////                            }
//                            R.id.item_account -> {
//                                if (accountPop == null) {
//                                    accountPop = AccountPop(act as MainActivity)
//                                    viewModel.accountPop = accountPop
//                                }
//                                accountPop?.showPopupWindow()
//                            }
//                            R.id.item_askForLeave -> {
//                            }
//                        }
//                        true
//                    }
//                }
//            }
//        }
//        viewBind?.actionBarCustom?.toolbar?.menu?.add("退出系统")?.apply {
////            setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS)
////            actionView = TextView(context).apply {
////                setPadding(15)
////                text = "退出系统"
////                if (isAdded)
////                setCompoundDrawablesRelativeWithIntrinsicBounds(ContextCompat.getDrawable(context, R.drawable.ic_baseline_exit_to_app_24), null, null, null)
////                setOnClickListener {
////                    DataCtrlClass.LoginNet.logout(act){
////                        if (it!=null) {
////                            ARouter.getInstance().build("/com/LoginPasswordActivity")
////                                .withTransition(R.anim.slide_in_bottom, android.R.anim.fade_out)
////                                .navigation(context)
////                        }
////                    }
////
////                }
////            }
//        }
////
////        dbsxAdapter.setOnItemClickListener { adapter, view, position ->
////            if (System.currentTimeMillis() - mLastClickTime > TIME_INTERVAL) {
//////                IRouter.goF(view, SZWUtils.getJsonObjectString(dbsxAdapter.data[position],"ANDROID"))
////                mLastClickTime = System.currentTimeMillis()
////            }
////        }
//
//
//        onRefresh(viewBind?.mRefreshLayout!!)
    }

    //    override fun initView() {
    ////        val mainData = SZWUtils.getJson(context, "mainData.json")
    ////        val list = Gson().fromJson<MutableList<MainMenuBean>>(mainData, object :
    ////            TypeToken<ArrayList<MainMenuBean>>() {}.type)
    ////        adapter.setNewInstance(list)
    //
    //    }
    /*
    * 横竖屏切换时 ，刷新子布局高度。
    * */
    override fun onConfigurationChanged(newConfig: Configuration) {
//        adapter.notifyDataSetChanged()
        super.onConfigurationChanged(newConfig)
    }

    /**
    登录后刷新数据，
     */
    @Subscribe(thread = EventThread.MAIN_THREAD, tags = [Tag(Constants.BusAction.Bus_LoginSuccess)])
    fun loginSuccess(str: String) {
        onRefresh(viewBind?.mRefreshLayout!!)
    }

    override fun refreshData(type: Int?) {

    }

    override fun onRefresh(refreshLayout: RefreshLayout) {
        //        val mainData = SZWUtils.getJson(context, "mainData.json")
        //        val list = Gson().fromJson<MutableList<MainMenuBean>>(mainData, object :
        //            TypeToken<ArrayList<MainMenuBean>>() {}.type)
        //        adapter.setNewInstance(list)
//        if (MyApplication.user != null) (viewBind?.actionBarCustom?.toolbar?.menu?.getItem(0)?.actionView as TextView).text = "欢迎：${(MyApplication.user as User).userInfo?.realname}"
//        DataCtrlClass.getMainMenuList(context) {
//            viewBind?.mRefreshLayout?.finishRefresh()
//            if (it != null) {
//                adapter.setNewInstance(it)
//            }
//        }
//        DataCtrlClass.MainNet.get_main_dbsx_list(context) {
//            viewBind?.mRefreshLayout?.finishRefresh()
//            if (it != null) {
//                dbsxAdapter.setNewInstance(it)
//            }
//        }
    }
}