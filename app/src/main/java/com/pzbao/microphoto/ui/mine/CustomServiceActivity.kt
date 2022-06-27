package com.pzbao.microphoto.ui.mine

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.jaeger.library.StatusBarUtil
import com.pzbao.microphoto.R
import com.pzbao.microphoto.databinding.ActivityCustomServiceBinding
import com.pzbao.microphoto.databinding.ActivityDaoRuBinding

class CustomServiceActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var viewBind =
            DataBindingUtil.setContentView<ActivityCustomServiceBinding>(this, R.layout.activity_custom_service)
                .apply {
                     lifecycleOwner = this@CustomServiceActivity
                }
         findViewById<TextView>(R.id.mTitle).setText("服务定制")
        StatusBarUtil.setColor(this,getResources().getColor(R.color.color_333),0)

        viewBind.actionBarCustom.toolbar.setNavigationOnClickListener {
            finish()
        }
    }
}