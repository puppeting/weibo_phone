package com.pzbao.microphoto.ui.home

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.google.android.flexbox.*
import com.jaeger.library.StatusBarUtil
import com.pzbao.microphoto.R
import com.pzbao.microphoto.adapter.SuiCaiMoBanAdapter
import com.pzbao.microphoto.config.PresenterClick
import com.pzbao.microphoto.databinding.ActivitySuiCaiBinding
import org.jetbrains.anko.startActivity


class SuiCaiActivity : AppCompatActivity(),PresenterClick {
    private var mAdapter: SuiCaiMoBanAdapter? = null
    private val listTask: MutableList<String> =
        mutableListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var viewBind =
            DataBindingUtil.setContentView<ActivitySuiCaiBinding>(this, R.layout.activity_sui_cai)
                .apply {
                    presenterClick=this@SuiCaiActivity
                    lifecycleOwner = this@SuiCaiActivity
                }
        mAdapter= SuiCaiMoBanAdapter()
        listTask.add("https://lupic.cdn.bcebos.com/20210629/2005401331_14.jpg")
        listTask.add("https://lupic.cdn.bcebos.com/20210629/2005401331_14.jpg")
        listTask.add("")
        listTask.add("https://lupic.cdn.bcebos.com/20210629/2005401331_14.jpg")
        listTask.add("")
//        listTask.add("https://lupic.cdn.bcebos.com/20210629/2005401331_14.jpg")
//        listTask.add("")
//        listTask.add("https://lupic.cdn.bcebos.com/20210629/2005401331_14.jpg")
         StatusBarUtil.setColor(this,getResources().getColor(R.color.bg_color),0)
//        var mLayoutManager = FlexboxLayoutManager(this);
//        //设置主轴为水平方向，从左到右
//        mLayoutManager.setFlexDirection(FlexDirection.ROW_REVERSE);
//        mLayoutManager.setJustifyContent(JustifyContent.FLEX_START)
//        //换行
//        mLayoutManager.setFlexWrap(FlexWrap.WRAP);

        //设置副轴对齐方式
//        mLayoutManager.setAlignItems(AlignItems.CENTER);
//        viewBind?.recyview?.setLayoutManager(mLayoutManager);
//        viewBind?.recyview?.layoutManager = GridLayoutManager(this,4)
         val layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
//        layoutManager.setGapStrategy(StaggeredGridLayoutManager.GAP_HANDLING_NONE)
//        layoutManager.setGapStrategy(StaggeredGridLayoutManager.GAP_HANDLING_MOVE_ITEMS_BETWEEN_SPANS);
        viewBind.recyview.setLayoutManager(layoutManager)



        viewBind?.recyview?.adapter = mAdapter
        mAdapter?.setNewInstance(listTask)

    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.chip_apply->{
                startActivity<GeXingActivity>()
            }
            R.id.iv_back ->{
                finish()
            }
        }
    }
}