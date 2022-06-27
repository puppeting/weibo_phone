package com.pzbao.microphoto.app

import android.app.Application
import android.content.Context
import com.blankj.utilcode.util.LogUtils
import com.blankj.utilcode.util.SPUtils
import com.pzbao.microphoto.base.MyApplication
import com.pzbao.microphoto.utils.SoundUtil

import me.jessyan.autosize.AutoSizeConfig
import me.jessyan.autosize.unit.Subunits
import java.io.File
import java.security.SecureRandom
import java.security.cert.X509Certificate
import java.util.*
import javax.net.ssl.HttpsURLConnection
import javax.net.ssl.SSLContext
import javax.net.ssl.TrustManager
import javax.net.ssl.X509TrustManager


/**
 */

class ToolApplication : MyApplication() {
    private var mInit: Boolean = false
    val TAG: String? = MyApplication::class.java.simpleName
    override fun getSaltStr(): String? = ""
    override fun onCreate() {
        super.onCreate()
        init(true)
//        //数据库初始化
//        boxStore = MyObjectBox.builder().androidContext(this).build()
//        initX5()
//        UMConfigure.setLogEnabled(true)
        //初始化组件化基础库, 统计SDK/推送SDK/分享SDK都必须调用此初始化接口
//        UMConfigure.init(this, "5d101f8a0cafb285430000a7", "Umeng", UMConfigure.DEVICE_TYPE_PHONE, "ef5c818094f6924dac1b6f0ea3aab2ee")
        // PushSDK初始化(如使用推送SDK，必须调用此方法)
        //        initUpush()
        /**
         * 注意: 即使您已经在AndroidManifest.xml中配置过appkey和channel值，也需要在App代码中调
         * 用初始化接口（如需要使用AndroidManifest.xml中配置好的appkey和channel值，
         * UMConfigure.init调用中appkey和channel参数请置为null）。
         */
//        UMConfigure.init(appContext, "603f398cb8c8d45c13898050", "Umeng", UMConfigure.DEVICE_TYPE_PHONE, "")

//        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
//        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        initAutoSize()

        handleSSLHandshake()

//        initSmallVideo()
        /** PictureSelector日志管理配制开始 **/
        // PictureSelector 绑定监听用户获取全局上下文或其他...
//        PictureAppMaster.getInstance().app = this
//
//        //在使用SDK各组件之前初始化context信息，传入ApplicationContext
//        SDKInitializer.initialize(this);
//        //自4.3.0起，百度地图SDK所有接口均支持百度坐标和国测局坐标，用此方法设置您使用的坐标类型.
//        //包括BD09LL和GCJ02两种坐标，默认是BD09LL坐标。
//        SDKInitializer.setCoordType(CoordType.BD09LL);


        SoundUtil.initSound(this)
    }

//    /**
//     *
//     * 初始化压缩组件地址
//     * */
//    fun initSmallVideo() {
//        // 设置拍摄视频缓存路径
//        val movies = File(SZWUtils.createCustomMoviesOutPath(this))
//        JianXiCamera.setVideoCachePath(movies.path)
//        // 初始化拍摄，遇到问题可选择开启此标记，以方便生成日志
//        JianXiCamera.initialize(false, null)
//    }

    /**
     *
     * 信任所有证书
     * */
    fun handleSSLHandshake() {
        try {
            val trustAllCerts = arrayOf<TrustManager>(object : X509TrustManager {

                override fun checkClientTrusted(certs: Array<X509Certificate?>?, authType: String?) {}
                override fun checkServerTrusted(certs: Array<X509Certificate?>?, authType: String?) {}
                override fun getAcceptedIssuers(): Array<X509Certificate?> {
                    return arrayOfNulls(0)
                }
            })
            val sc: SSLContext = SSLContext.getInstance("TLS")
            // trustAllCerts信任所有的证书
            sc.init(null, trustAllCerts, SecureRandom())
            HttpsURLConnection.setDefaultSSLSocketFactory(sc.socketFactory)
            HttpsURLConnection.setDefaultHostnameVerifier { hostname, session -> true }
        } catch (ignored: Exception) {
        }
    }


//    override fun getAppContext(): Context? {
//        return this
//    }
//
//    override fun getPictureSelectorEngine(): PictureSelectorEngine? {
//        return PictureSelectorEngineImp()
//    }
//
//    override fun getCameraXConfig(): CameraXConfig {
//        return Camera2Config.defaultConfig()
//    }

    private fun initAutoSize() {
        AutoSizeConfig.getInstance().setBaseOnWidth(true).unitsManager.setSupportDP(false)
            .setSupportSP(false).supportSubunits = Subunits.MM
    }

    companion object {
        fun getAPP(app: Application): ToolApplication = app as ToolApplication
        const val appDebug = false
    }
}
