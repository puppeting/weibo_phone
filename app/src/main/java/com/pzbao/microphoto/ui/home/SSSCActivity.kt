package com.pzbao.microphoto.ui.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.jaeger.library.StatusBarUtil
import com.pzbao.microphoto.R
import com.pzbao.microphoto.config.PresenterClick
import com.pzbao.microphoto.databinding.ActivitySsscCanBinding
import org.jetbrains.anko.startActivity

class SSSCActivity : AppCompatActivity(), PresenterClick {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        StatusBarUtil.setColor(this,getResources().getColor(R.color.bg_color),0)

        var viewBind =
            DataBindingUtil.setContentView<ActivitySsscCanBinding>(this, R.layout.activity_sssc_can)
                .apply {
                    presenterClick=this@SSSCActivity
                    lifecycleOwner = this@SSSCActivity
                }
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.tv_ok ->{
                finish()
            }
            R.id.iv_back ->{
                finish()
            }
        }
    }
}