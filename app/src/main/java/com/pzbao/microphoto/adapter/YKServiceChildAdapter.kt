package com.pzbao.microphoto.adapter


import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.pzbao.microphoto.R


class YKServiceChildAdapter : BaseQuickAdapter<String, BaseViewHolder>(R.layout.item_recyview_text) {
    private val listTask = ArrayList<String>()

    override fun convert(holder: BaseViewHolder, item: String) {

    }


}