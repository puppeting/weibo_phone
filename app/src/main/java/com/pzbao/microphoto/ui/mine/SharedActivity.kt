package com.pzbao.microphoto.ui.mine

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.jaeger.library.StatusBarUtil
import com.pzbao.microphoto.R

class SharedActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shared)
        StatusBarUtil.setColor(this,getResources().getColor(R.color.shared_color),0)

        findViewById<ImageView>(R.id.iv_back).setOnClickListener { finish() }
    }
}