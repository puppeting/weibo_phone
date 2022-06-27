package com.pzbao.microphoto.base

import android.os.Bundle
import android.view.View

/**
 */

internal interface AbsBaseActivity {
    /**
     * 视图，组件,数据的初始化
     */
    @Throws(Exception::class)
    fun init()

    fun init(savedInstanceState: Bundle?)

    fun initData()
    fun refreshData(type: Int?=-1)
    /**
     * 初始化电量条和状态栏
     */
    fun initToolbar()
    /**
     * 设置布局id
     */
    fun setInflateId(): Int
    /**
     * binding布局id
     */
    fun setInflateBinding()
    /**
     * 设置布局View
     */
    fun setInflateView(): View

}
