package com.pzbao.microphoto.ui.sucai

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.jaeger.library.StatusBarUtil
import com.king.zxing.CaptureActivity
import com.pzbao.microphoto.R
import com.pzbao.microphoto.config.PresenterClick
import com.pzbao.microphoto.databinding.ActivityDaoRuBinding
import org.jetbrains.anko.startActivity


class DaoRuActivity : AppCompatActivity(),PresenterClick {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
         var viewBind =
            DataBindingUtil.setContentView<ActivityDaoRuBinding>(this, R.layout.activity_dao_ru)
                .apply {
                    presenterClick=this@DaoRuActivity
                    lifecycleOwner = this@DaoRuActivity
                }
        StatusBarUtil.setColor(this,getResources().getColor(R.color.bg_color),0)
        findViewById<TextView>(R.id.mTitle).setText("导入")

         viewBind.actionBarCustom.toolbar.setNavigationOnClickListener {
            finish()
        }
    }

    override fun onClick(v: View?) {
         when(v?.id){
             R.id.tv_saoyisao ->{
//                 startActivityForResult(Intent(this, CaptureActivity::class.java), 100)
                 startActivity<SaoYiSaoActivity>()
             }
         }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {

        Log.e("messsss",""+requestCode+"***"+resultCode)
        Log.e("messsss",""+requestCode+"***"+data?.extras)

        super.onActivityResult(requestCode, resultCode, data)
    }
}