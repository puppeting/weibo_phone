package com.pzbao.microphoto.ui.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.jaeger.library.StatusBarUtil
import com.pzbao.microphoto.R
import com.pzbao.microphoto.config.PresenterClick
import com.pzbao.microphoto.databinding.ActivitySeetCanBinding
import org.jetbrains.anko.startActivity

class SeetCanActivity : AppCompatActivity(), PresenterClick {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
         var viewBind =
            DataBindingUtil.setContentView<ActivitySeetCanBinding>(this, R.layout.activity_seet_can)
                .apply {
                    presenterClick=this@SeetCanActivity
                    lifecycleOwner = this@SeetCanActivity
                }
        StatusBarUtil.setColor(this,getResources().getColor(R.color.bg_color),0)

    }

    override fun onClick(v: View?) {
         when(v?.id){
            R.id.tv_ok ->{
                startActivity<SSSCActivity>()
            }
             R.id.iv_back ->{
                 finish()
             }
         }
    }
}
