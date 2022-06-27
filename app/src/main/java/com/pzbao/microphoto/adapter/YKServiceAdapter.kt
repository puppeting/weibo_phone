package com.pzbao.microphoto.adapter


import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.pzbao.microphoto.R
import com.pzbao.microphoto.pop.TsDialog


class YKServiceAdapter : BaseQuickAdapter<String, BaseViewHolder>(R.layout.item_recyview_layout) {
    private val listTask = ArrayList<String>()

    override fun convert(holder: BaseViewHolder, item: String) {
        //设
        val recyview2 = holder.itemView.findViewById<RecyclerView>(R.id.recyview)
        val grid1 = LinearLayoutManager(context)
        grid1.orientation = RecyclerView.HORIZONTAL
        listTask.add("")
        listTask.add("")
        listTask.add("")
        listTask.add("")

        val adapter2 = YKServiceChildAdapter()
        recyview2.layoutManager = grid1
        recyview2.adapter = adapter2
        adapter2.setNewInstance(listTask)
        adapter2?.setOnItemClickListener { adapter, view, position ->
            val mdialog = TsDialog(context, R.style.MyDialogStyle)
            mdialog.show()
        }
    }


}