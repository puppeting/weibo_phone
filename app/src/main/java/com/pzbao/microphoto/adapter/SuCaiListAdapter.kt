package com.pzbao.microphoto.adapter


import android.widget.ImageView
import android.widget.TextView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.pzbao.microphoto.R


class SuCaiListAdapter : BaseQuickAdapter<String, BaseViewHolder>(R.layout.item_sucai_wenjianjia) {
    override fun convert(holder: BaseViewHolder, item: String) {
        if(item=="") {
            holder.getView<ImageView>(R.id.iv_bg).setBackgroundResource(R.mipmap.add)
            holder.getView<TextView>(R.id.tv_name).setText("新建文件夹")
        }
    }


}