package com.pzbao.microphoto.ui.mine

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.pzbao.microphoto.R
import com.pzbao.microphoto.databinding.ActivityMineBinding

class MineActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var viewBind =
            DataBindingUtil.setContentView<ActivityMineBinding>(this, R.layout.activity_mine)
                .apply {
                    lifecycleOwner = this@MineActivity
                }

     }
}