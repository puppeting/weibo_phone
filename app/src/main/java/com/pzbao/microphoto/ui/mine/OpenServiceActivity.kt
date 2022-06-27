package com.pzbao.microphoto.ui.mine

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.jaeger.library.StatusBarUtil
import com.pzbao.microphoto.R
import com.pzbao.microphoto.adapter.HomeRecyclerAdapter
import com.pzbao.microphoto.adapter.ServiceRecyclerAdapter
import com.pzbao.microphoto.adapter.YKServiceAdapter
import com.pzbao.microphoto.databinding.ActivityAboutUsBinding
import com.pzbao.microphoto.databinding.ActivityOpenServiceBinding
import com.pzbao.microphoto.utils.OnItemClickLitener

class OpenServiceActivity : AppCompatActivity() {
    private var recyclerView: RecyclerView? = null
    private var adapter2: YKServiceAdapter? = null
    private val listTask: MutableList<String> =
        mutableListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
         var viewBind =
            DataBindingUtil.setContentView<ActivityOpenServiceBinding>(this, R.layout.activity_open_service)
                .apply {
                    lifecycleOwner = this@OpenServiceActivity
                }
//        viewBind.actionBarCustom.toolbar.title="已开通服务"
        StatusBarUtil.setColor(this,getResources().getColor(R.color.color_333),0)

//        viewBind.actionBarCustom.toolbar.title="已开通服务"
        findViewById<TextView>(R.id.mTitle).setText("开通服务")
        viewBind.actionBarCustom.toolbar.setNavigationOnClickListener {
            finish()
        }
        val grid1 = LinearLayoutManager(this)
        listTask.add("")
        listTask.add("")
        recyclerView=findViewById<RecyclerView>(R.id.recyview_service)
        adapter2 = YKServiceAdapter()
        recyclerView?.setLayoutManager(grid1)
        recyclerView?.setAdapter(adapter2)
        adapter2?.setNewInstance(listTask)

    }
}