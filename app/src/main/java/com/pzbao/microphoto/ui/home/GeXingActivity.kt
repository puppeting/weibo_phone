package com.pzbao.microphoto.ui.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.jaeger.library.StatusBarUtil
import com.pzbao.microphoto.R
import com.pzbao.microphoto.adapter.GeXingAdapter
import com.pzbao.microphoto.config.PresenterClick
import com.pzbao.microphoto.databinding.ActivityGeXingBinding
import org.jetbrains.anko.startActivity

class GeXingActivity : AppCompatActivity(),PresenterClick {
    private var mAdapter: GeXingAdapter? = null
    private val listTask: MutableList<String> =
        mutableListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var viewBind =
            DataBindingUtil.setContentView<ActivityGeXingBinding>(this, R.layout.activity_ge_xing)
                .apply {
                    presenterClick=this@GeXingActivity
                    lifecycleOwner = this@GeXingActivity
                }
        mAdapter= GeXingAdapter()
        listTask.add("https://lupic.cdn.bcebos.com/20210629/2005401331_14.jpg")
        listTask.add("https://lupic.cdn.bcebos.com/20210629/2005401331_14.jpg")
        listTask.add("https://lupic.cdn.bcebos.com/20210629/2005401331_14.jpg")
        listTask.add("")
//        listTask.add("https://lupic.cdn.bcebos.com/20210629/2005401331_14.jpg")
        StatusBarUtil.setColor(this,getResources().getColor(R.color.bg_color),0)

//        viewBind?.recyview?.layoutManager = GridLayoutManager(this,4)
        val layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
//        layoutManager.setGapStrategy(StaggeredGridLayoutManager.GAP_HANDLING_NONE)
        viewBind.recyview.setLayoutManager(layoutManager)
        viewBind?.recyview?.adapter = mAdapter
        mAdapter?.setNewInstance(listTask)
        mAdapter?.setOnItemClickListener { adapter, view, position -> 
            startActivity<SeetCanActivity>()
        }

    }

    override fun onClick(v: View?) {
            when(v?.id){
                R.id.iv_back ->{
                    finish()
                }
            }
    }
}