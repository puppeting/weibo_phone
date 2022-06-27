package com.pzbao.microphoto.ui.mine

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.jaeger.library.StatusBarUtil
import com.pzbao.microphoto.R
import com.pzbao.microphoto.base.BaseActivity
import com.pzbao.microphoto.databinding.ActivityAboutUsBinding
import com.pzbao.microphoto.databinding.ActivityDaoRuBinding

class AboutUsActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
         var viewBind =
            DataBindingUtil.setContentView<ActivityAboutUsBinding>(this, R.layout.activity_about_us)
                .apply {
                    lifecycleOwner = this@AboutUsActivity
                }
        StatusBarUtil.setColor(this,getResources().getColor(R.color.bg_color),0)

        findViewById<TextView>(R.id.mTitle).setText("关于我们")
        viewBind.actionBarCustom.toolbar.setNavigationOnClickListener {
            finish()
        }
    }

    override fun initToolbar() {

    }
}