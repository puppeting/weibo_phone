package com.pzbao.microphoto.model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.blankj.utilcode.util.SPUtils
 import com.pzbao.microphoto.bean.User
import com.pzbao.microphoto.config.Constants


class MainActivityModel: ViewModel() {
    var userInfo: MutableLiveData<User> = MutableLiveData(User())
     var idCardNum: String?=null
    val isGestureLogin: MutableLiveData<Boolean> by lazy {MutableLiveData(
        SPUtils.getInstance().getBoolean(
            Constants.SPUtilsConfig.ISGESTURELOCK_KEY, false
        ))
    }

}