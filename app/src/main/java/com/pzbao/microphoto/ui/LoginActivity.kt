package com.pzbao.microphoto.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.jaeger.library.StatusBarUtil
import com.pzbao.microphoto.R
import com.pzbao.microphoto.bean.BaseTypeBean
import com.pzbao.microphoto.config.PresenterClick
import com.pzbao.microphoto.databinding.ActivityLoginBinding
import org.jetbrains.anko.startActivity

class LoginActivity : AppCompatActivity() , PresenterClick {

    private lateinit var viewBind: ActivityLoginBinding
    private lateinit var bean: BaseTypeBean

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBind =
            DataBindingUtil.setContentView<ActivityLoginBinding>(this, R.layout.activity_login)
                .apply {
                    presenterClick=this@LoginActivity
                    lifecycleOwner = this@LoginActivity
                }
        bean= BaseTypeBean().apply {
            dataType=1
        }
        StatusBarUtil.setColor(this,getResources().getColor(R.color.bg_color),0)

        viewBind?.data=bean
    }
    override fun onClick(v: View?) {
        when(v?.id){
            R.id.tv_login->{
                if(bean.dataType==1){
                    bean.dataType=2
                    viewBind?.data=bean
                }else{
                    startActivity<MainActivity>()
                }
            }
        }
    }
}