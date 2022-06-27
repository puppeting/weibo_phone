package com.pzbao.microphoto.adapter


import android.widget.ImageView
import android.widget.TextView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.pzbao.microphoto.R


class SuCaiListVideoAdapter : BaseQuickAdapter<String, BaseViewHolder>(R.layout.item_sucai_wenjianjia) {
    override fun convert(holder: BaseViewHolder, item: String) {
        holder.getView<ImageView>(R.id.iv_bg).setBackgroundResource(R.mipmap.gexing_tupian)
        holder.getView<TextView>(R.id.tv_name).setText("图片1")
        if(item=="") {
            holder.getView<ImageView>(R.id.iv_bg).setBackgroundResource(R.mipmap.gexing_shipin)
            holder.getView<TextView>(R.id.tv_name).setText("视频1")
        }
    }


}