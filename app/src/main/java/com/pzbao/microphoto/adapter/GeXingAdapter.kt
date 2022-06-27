package com.pzbao.microphoto.adapter

import android.graphics.Bitmap
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.RequestOptions
import com.chad.library.adapter.base.BaseQuickAdapter

import com.chad.library.adapter.base.viewholder.BaseViewHolder
 import com.pzbao.microphoto.R


 import java.util.HashMap


/**

 */
class GeXingAdapter : BaseQuickAdapter<String, BaseViewHolder>(R.layout.item_gexing_recycle)  {
    private val hashMap = HashMap<Int, Int?>()
    private var mWidth = 0
    private var mHeight = 0

//    constructor(data: List<String>?) : super(R.layout.item_main, data) {}
//    constructor() : super(R.layout.item_main) {}

      override fun convert(helper: BaseViewHolder, data: String) {
//        //将每一个需要赋值的id和对应的数据绑定
           val imageView = helper.getView<ImageView>(R.id.iv_bg)
          val layoutParams = imageView.layoutParams

          val roundOptions = RequestOptions().transform(RoundedCorners(18))
//处理CenterCrop的情况,保证圆角不失效
          roundOptions.transform(CenterCrop(), RoundedCorners(18))
          if(data==""){

              Glide.with(context)
                  .load("https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fbpic.588ku.com%2Felement_origin_min_pic%2F01%2F31%2F98%2F23573b5dd1b58d8.jpg&refer=http%3A%2F%2Fbpic.588ku.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=auto?sec=1658618896&t=b4045b062c8567c350dfe502c296b8d8")
                  .transform(CenterCrop(), RoundedCorners(56))
                  .apply(roundOptions)
                  .override(layoutParams.width, 800)  //给个最大值
                  .fitCenter()
                  .transition(DrawableTransitionOptions.withCrossFade(500))


                  .into(imageView)
          }else {
              Glide.with(context)
                  .load("https://img-blog.csdnimg.cn/e2ec68645e3946efa0d173b4648d1fa9.png?x-oss-process=image/watermark,type_ZHJvaWRzYW5zZmFsbGJhY2s,shadow_50,text_Q1NETiBA5aSW5aSq56m655qE5bCP55m9,size_8,color_FFFFFF,t_70,g_se,x_16")
                  .transform(CenterCrop(), RoundedCorners(56))
                  .override(layoutParams.width, 800)  //给个最大值
                  .fitCenter()
                  .apply(roundOptions)
                  .transition(DrawableTransitionOptions.withCrossFade(500))

                  .into(imageView)
          }
//        if (hashMap[helper.adapterPosition] != null) {
//            //屏幕的宽度(px值）
//            val screenWidth = context.resources.displayMetrics.widthPixels
//            //图片的宽度
//            mWidth = screenWidth / 2
//            //图片的高度
//            mHeight = hashMap[helper.adapterPosition]!!
//            //如果图片存储的高度不为空，则使用图片的存储高度作为imageView的高度
//            val layoutParams = imageView.layoutParams
//            layoutParams.width = mWidth
//            layoutParams.height = mHeight
//            imageView.layoutParams = layoutParams
//
//        }
//        val options: RequestOptions = RequestOptions()
//            .diskCacheStrategy(DiskCacheStrategy.ALL)
//            .placeholder(R.mipmap.home_banner)
//            .error(R.mipmap.home_banner)
//        Glide.with(context)
//            .asBitmap()
//            .apply(options)
////            .addListener(object : RequestListener<Bitmap> {
////                override fun onLoadFailed(
////                    e: GlideException?,
////                    model: Any,
////                    target: Target<Bitmap?>,
////                    isFirstResource: Boolean
////                ): Boolean {
////                    return false
////                }
////
////                override fun onResourceReady(
////                    bitmap: Bitmap,
////                    model: Any,
////                    target: Target<Bitmap>,
////                    dataSource: DataSource,
////                    isFirstResource: Boolean
////                ): Boolean {
////                    //存储图片的高度，以便在向上滚动的时候使用
////                    val height = bitmap.height
////                    if (hashMap[helper.adapterPosition] == null) {
////                        hashMap[helper.adapterPosition] = height
////                    }
////                    //                        Log.d("mmm", "S_width" + helper.getAdapterPosition() + "=" + width); //400px
//////                        Log.d("mmm", "S_height" + helper.getAdapterPosition() + "=" + height); //400px
////                    return false
////                }
////            })
//            .load(data.toString())
//            .into(imageView)
        //对两个按钮进行监听
    }
}
