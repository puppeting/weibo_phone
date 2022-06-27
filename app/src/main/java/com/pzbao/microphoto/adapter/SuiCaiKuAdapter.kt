package com.pzbao.microphoto.adapter


import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.pzbao.microphoto.R


class SuiCaiKuAdapter : BaseQuickAdapter<String, BaseViewHolder>(R.layout.item_sucaiku_recycle) {
    override fun convert(holder: BaseViewHolder, item: String) {

    }

    private fun getCzlx(s: String?): String {
        return when (s) {
            "agree" ->
                "同意"
            "returnTo" ->
                "回退"
            "reject" ->
                "否决"
            else -> {
                ""
            }
        }
    }
}