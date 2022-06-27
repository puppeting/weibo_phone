package com.pzbao.microphoto.ui.mine

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.jaeger.library.StatusBarUtil
import com.pzbao.microphoto.R
import com.pzbao.microphoto.adapter.AppstoreAdapter
import com.pzbao.microphoto.base.BaseActivity
import com.pzbao.microphoto.bean.BaseTypeBean
import com.pzbao.microphoto.config.PresenterClick
import com.pzbao.microphoto.databinding.ActivityAppStoreBinding
 import com.pzbao.microphoto.pop.AppInfoDialog

class AppStoreActivity : BaseActivity() ,PresenterClick{
    private var mAdapter: AppstoreAdapter? = null
    private val listTask: MutableList<String> =
        mutableListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var viewBind =
            DataBindingUtil.setContentView<ActivityAppStoreBinding>(this, R.layout.activity_app_store)
                .apply {
                    presenterClick=this@AppStoreActivity
                    lifecycleOwner = this@AppStoreActivity
                }
        mAdapter= AppstoreAdapter()
        var bean= BaseTypeBean().apply {
            dataType=1
        }
        StatusBarUtil.setColor(this,getResources().getColor(R.color.bg_color),0)
        viewBind?.data=bean
        listTask.add("https://lupic.cdn.bcebos.com/20210629/2005401331_14.jpg")
        listTask.add("https://lupic.cdn.bcebos.com/20210629/2005401331_14.jpg")
        listTask.add("https://lupic.cdn.bcebos.com/20210629/2005401331_14.jpg")
        listTask.add("https://lupic.cdn.bcebos.com/20210629/2005401331_14.jpg")
        listTask.add("https://lupic.cdn.bcebos.com/20210629/2005401331_14.jpg")
        val layoutManager = LinearLayoutManager(this)
        viewBind.recyview.setLayoutManager(layoutManager)
        viewBind?.recyview?.adapter = mAdapter
        mAdapter?.setNewInstance(listTask)
        mAdapter?.setOnItemClickListener { adapter, view, position ->
            AppInfoDialog(this, R.style.MyDialogStyle).show()
        }
        viewBind?.ivBack?.setOnClickListener { finish() }
    }

    override fun initToolbar() {

    }

    override fun onClick(v: View?) {

    }
}