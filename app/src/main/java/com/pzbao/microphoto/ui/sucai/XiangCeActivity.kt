package com.pzbao.microphoto.ui.sucai

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.jaeger.library.StatusBarUtil
import com.pzbao.microphoto.R
import com.pzbao.microphoto.config.PresenterClick
import com.pzbao.microphoto.databinding.ActivityXiangCeBinding

class XiangCeActivity : AppCompatActivity() , PresenterClick {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
         var viewBind =
            DataBindingUtil.setContentView<ActivityXiangCeBinding>(this, R.layout.activity_xiang_ce)
                .apply {
                    lifecycleOwner = this@XiangCeActivity
                }
        StatusBarUtil.setColor(this,getResources().getColor(R.color.bg_color),0)

        viewBind?.tvCancel?.setOnClickListener { finish() }
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.tv_cancel ->{
                finish()
            }
        }
    }
}