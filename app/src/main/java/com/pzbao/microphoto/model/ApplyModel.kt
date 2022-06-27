package com.pzbao.microphoto.model

import androidx.lifecycle.ViewModel

open class ApplyModel  constructor(): ViewModel() {
     var jsonObject: String? = null //某个被选中的条目
    var creditId: String? = null
    var keyId: String? = null
    var dhId: String? = null
    var zfId: String? = null
    var ysxId: String? = null
    var seeOnly: Boolean? = false
    var businessType = BUSINESS_TYPE_APPLY
    var title: String? = "" //同一页面不同内容，刷新时使用

    companion object {
        const val BUSINESS_TYPE_APPLY = 10 //类型

    }
}