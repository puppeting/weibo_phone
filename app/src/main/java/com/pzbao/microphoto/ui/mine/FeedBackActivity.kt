package com.pzbao.microphoto.ui.mine

import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import com.blankj.utilcode.util.ObjectUtils
import com.bumptech.glide.Glide
import com.jaeger.library.StatusBarUtil
import com.luck.picture.lib.PictureSelector
import com.luck.picture.lib.config.PictureConfig
import com.luck.picture.lib.config.PictureMimeType
import com.luck.picture.lib.entity.LocalMedia
import com.luck.picture.lib.listener.OnResultCallbackListener
import com.pzbao.microphoto.R
import com.pzbao.microphoto.base.BaseActivity
import com.pzbao.microphoto.glide.GlideCacheEngine
import com.pzbao.microphoto.glide.GlideEngine
import java.io.File

class FeedBackActivity : BaseActivity() {
    private lateinit var rlDel: RelativeLayout
    private lateinit var iv_1: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_feed_back)
        iv_1=findViewById<ImageView>(R.id.iv_add1)
        findViewById<Toolbar>(R.id.toolbar).setOnClickListener { finish() }
        findViewById<TextView>(R.id.mTitle).setText("问题反馈")
        StatusBarUtil.setColor(this,getResources().getColor(R.color.bg_color),0)

        rlDel=findViewById<RelativeLayout>(R.id.rl_del)

        findViewById<LinearLayout>(R.id.iv_add).setOnClickListener {
            val pictureSelector = PictureSelector.create(this)
            val openSelector = pictureSelector.openGallery(PictureMimeType.ofImage())
//            else pictureSelector.openCamera(PictureMimeType.ofImage())

            openSelector.selectionMode(PictureConfig.MULTIPLE)
            openSelector.imageEngine(GlideEngine.createGlideEngine()) // 外部传入图片加载引擎，必传项
                .maxSelectNum(9).minSelectNum(1) // 最小选择数量
                .isSingleDirectReturn(true)
                .isCamera(true) //                    .isUseCustomCamera(true)//是否使用自定义相机
                //                    .setButtonFeatures(CustomCameraView.BUTTON_STATE_ONLY_CAPTURE)//自定相机是否单独拍照、录像
                .isCompress(true) //是否压缩.imageEngine(GlideEngine.createGlideEngine()) // 请参考Demo GlideEngine.java.loadCacheResourcesCallback(GlideCacheEngine.createCacheEngine())
                .minimumCompressSize(80) // 小于多少kb的图片不压缩
                //                    .setOutputCameraPath(SZWUtils.createCustomCameraOutPath(context))
                .loadCacheResourcesCallback(GlideCacheEngine.createCacheEngine()) // 获取图片资源缓存，主要是解决华为10部分机型在拷贝文件过多时会出现卡的问题，这里可以判断只在会出现一直转圈问题机型上使用
//                .setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_REVERSE_PORTRAIT) // 设置相册Activity方向，不设置默认使用系统
                .compressQuality(80).synOrAsy(true)
                .forResult(object : OnResultCallbackListener<LocalMedia?> {
                    override fun onResult(result: List<LocalMedia?>) {
                        var picturePath: String? = result[0]?.compressPath
                        if (picturePath == null) {
                            picturePath = result[0]?.realPath.toString()
                        }
                        rlDel?.visibility= View.VISIBLE
                        Glide.with(this@FeedBackActivity).load(picturePath).into(iv_1)
//                    if (ObjectUtils.isEmpty(result) || result.isEmpty()) {
//                        return
//                    }
//                    when {
//                        item.picCount == 1 && item.valueHint.contains("身份证") -> {
//                            var picturePath: String? = result[0]?.compressPath
//                            if (picturePath == null) {
//                                picturePath = result[0]?.realPath.toString()
//                            }
//                            val mFile = File(picturePath)
//                            iDCardUpData(item, mFile) {
//                                listener?.invoke()
//                            }
//                        }


                    }

                    override fun onCancel() {
                    }
                }) //PictureConfig.CHOOSE_REQUEST
        }

    }

    override fun initToolbar() {

    }
}