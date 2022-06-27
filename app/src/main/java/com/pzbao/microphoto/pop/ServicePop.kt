package com.pzbao.microphoto.pop


import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import androidx.fragment.app.DialogFragment
import com.blankj.utilcode.util.ScreenUtils
import com.pzbao.microphoto.R

import com.pzbao.microphoto.databinding.ServicePopLayoutBinding
import com.pzbao.microphoto.utils.StatusBarUtil

class ServicePop(var mContext: Context?, val title: String, var listener: (confirm: Boolean) -> Unit) :
    DialogFragment(), View.OnClickListener {
    var confirmStr="确定"
    var cancelStr="取消"
    fun setCancelText(str: String): ServicePop {
        cancelStr = str
        return this
    }

    fun setConfirmText(str: String): ServicePop {
        confirmStr = str
        return this
    }

    override fun onClick(v: View?) { //        KeyboardUtils.hideSoftInput(findViewById<EditText>(R.id.tv))
        when (v?.id) {

            R.id.tv_ok -> {
                listener.invoke(true)
                dismiss()
            }
            else -> {
            }
        }
    }

    //    override fun onCreateContentView(): View {
    //        return createPopupById(R.layout.pop_confirm)
    //    }
    override fun onStart() {
        super.onStart()
        StatusBarUtil.immersive(dialog?.window) //        setStyle(STYLE_NO_TITLE,R.style.MyDialog)
        val params = dialog?.window?.attributes
        dialog?.setCanceledOnTouchOutside(false)
        params?.width = ScreenUtils.getScreenWidth()
        params?.height = RelativeLayout.LayoutParams.MATCH_PARENT
        params?.gravity = Gravity.CENTER //高度自己定义
        dialog?.window?.setLayout(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT)

    }

    lateinit var dataBind: ServicePopLayoutBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View { //        dialog?.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT)) //设置背景为透明

        dataBind = ServicePopLayoutBinding.inflate(inflater, container, false)
        return dataBind.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        dataBind.tvTitle.text = title
        dataBind.tvOk.text = confirmStr

        dataBind.tvOk.setOnClickListener(this)
    }
}