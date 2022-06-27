package com.pzbao.microphoto.bean



open class BaseTypeBean  {


    private val field = "" //字段名称
    var visibility = true //是否显示，默认true
    val model: String? = null //后台使用
    val dataKey = "" //后台使用
    var dataValue: String? = ""
    val keyName = ""
    val valueHint = ""
    var dataType: Int=1
    var daohangType: Int=1
    var colorType: Int=1


    val haveValue: Boolean
        get() {
            return keyName.isNotEmpty() || !picUrl.isNullOrEmpty() || !picList.isNullOrEmpty()
        }




    var picUrl: String? = "" //多图,隔开14、15
        set(value) {
            field = value

        }
    var picList: ArrayList<String>? = null //多个图片的列表
        get() {
            return if (field == null) arrayListOf() else field
        }

}