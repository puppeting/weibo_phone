package com.pzbao.microphoto.base

import android.Manifest.permission.*
import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.Window
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LifecycleOwner
import com.alibaba.android.arouter.launcher.ARouter
import com.hwangjr.rxbus.RxBus
import com.pzbao.microphoto.base.AbsBaseActivity
import com.pzbao.microphoto.config.Constants
import com.pzbao.microphoto.base.MyApplication
import com.pzbao.microphoto.widget.CustomProgress

import permissions.dispatcher.NeedsPermission
import permissions.dispatcher.RuntimePermissions


/**
 * Created by Swain
 * on 2017/1/16.
 */
@RuntimePermissions
abstract class BaseActivity : AppCompatActivity(), LifecycleOwner, AbsBaseActivity {
    lateinit var mContext: Context

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        /**
         * 设置状态栏透明
         */


        //        if ((getIntent().getFlags() & Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT) != 0) {
        //            finish();
        //            return;
        //        }
        //        if (!SZWUtils.authentication){
        //            SZWUtils.security {
        //                if (!SZWUtils.authentication)
        //                    finish()
        //            }
        //        }
//        window.setFlags(WindowManager.LayoutParams.FLAG_SECURE, WindowManager.LayoutParams.FLAG_SECURE)
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE)
        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN)
        window.setFlags(WindowManager.LayoutParams.FLAG_SECURE, WindowManager.LayoutParams.FLAG_SECURE)

        when {
            setInflateId() == -1 -> setInflateBinding()
            setInflateId() > 0 -> setContentView(setInflateId())
            setInflateId() == 0 -> setContentView(setInflateView())
        }

        mContext = this
        //        ButterKnife.bind(this);
        try {
            RxBus.get().register(this)
            ARouter.getInstance().inject(this)
            init()
            init(savedInstanceState)
            initToolbar()
            initData()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    override fun onStart() {
        super.onStart()
        if (MyApplication.user?.screenRecordeAble == false) {
            window.setFlags(WindowManager.LayoutParams.FLAG_SECURE, WindowManager.LayoutParams.FLAG_SECURE)
        }else{
            window.clearFlags(WindowManager.LayoutParams.FLAG_SECURE)
        }
    }
    override fun setInflateBinding() {

    }

    override fun setInflateView(): View {
        return View(this)
    }

    override fun setInflateId() = -1

    /**
     * 视图，组件,数据的初始化
     */
    @Throws(Exception::class)
    override fun init() {

    }

    override fun init(savedInstanceState: Bundle?) {

    }

    override fun initData() {}
    override fun refreshData(type: Int?) {
        initData()
    }

    @NeedsPermission(CAMERA, WRITE_EXTERNAL_STORAGE)
    fun permissionCamera(intent: Intent?, requestCode: Int, isService: Boolean, listener: Runnable) {
        listener.run()
        startAction(intent, isService, if (requestCode == -1) Constants.Permission.Camera else requestCode)
    }

    @NeedsPermission(ACCESS_COARSE_LOCATION, ACCESS_FINE_LOCATION)
    fun permissionLocation(listener: Runnable) {
        listener.run()
    }

    @NeedsPermission(RECEIVE_SMS, READ_SMS)
    fun permissionSMS(intent: Intent?, requestCode: Int, isService: Boolean) {
        startAction(intent, isService, if (requestCode == -1) Constants.Permission.SMS else requestCode)
    }

    @NeedsPermission(CALL_PHONE)
    fun permissionCallPhone(listener: Runnable) {
        listener.run()
    }

    @NeedsPermission(READ_PHONE_STATE)
    fun permissionPhoneState(intent: Intent?, requestCode: Int, isService: Boolean) {
        startAction(intent, isService, if (requestCode == -1) Constants.Permission.Phone else requestCode)
    }

    @NeedsPermission(WRITE_EXTERNAL_STORAGE, READ_EXTERNAL_STORAGE)
    fun permissionWAndR(intent: Intent?, requestCode: Int, isService: Boolean, listener: Runnable) {
        listener.run()
        startAction(intent, isService, if (requestCode == -1) Constants.Permission.Phone else requestCode)
    }

    @NeedsPermission(REQUEST_INSTALL_PACKAGES)
    fun permissionInstallAPP(listener: Runnable) {
        listener.run()
    }

    private fun startAction(intent: Intent?, isService: Boolean, requestCode: Int) {
        if (intent != null) {
            if (isService) startService(intent)
            else startActivityForResult(intent, requestCode)
        }
    }

    @SuppressLint("NeedOnRequestPermissionsResult")
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>,
        grantResults: IntArray,
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        onRequestPermissionsResult(requestCode, grantResults)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        val allFragments = supportFragmentManager.fragments
        for (fragment in allFragments) {
            fragment.onActivityResult(requestCode, resultCode, data)
        }
    }

    public override fun onDestroy() {

        try {
            RxBus.get().unregister(this)
        } catch (e: Exception) {
            e.printStackTrace()
        }

        CustomProgress.disMissNow()
        super.onDestroy()
    }
}
