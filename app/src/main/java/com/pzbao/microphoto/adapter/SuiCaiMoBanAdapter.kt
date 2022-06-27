package com.pzbao.microphoto.adapter


import android.content.Context
import android.graphics.drawable.Drawable
import android.util.DisplayMetrics
import android.view.WindowManager
import android.widget.ImageView
import androidx.core.graphics.drawable.toBitmap
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.Target
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.pzbao.microphoto.R


/**

 */
class SuiCaiMoBanAdapter : BaseQuickAdapter<String, BaseViewHolder>(R.layout.item_sucai_recycle2)  {
    private val hashMap = HashMap<Int, Int?>()
    private var mWidth = 0
    private var mHeight = 0

//    constructor(data: List<String>?) : super(R.layout.item_main, data) {}
//    constructor() : super(R.layout.item_main) {}

      override fun convert(helper: BaseViewHolder, data: String) {
//        //将每一个需要赋值的id和对应的数据绑定
        val imageView = helper.getView<ImageView>(R.id.iv_bg)
          var width = getScreenWidthPx();
          // 注意：每行布局有2列，以下两行代码的意思是，
//           每个图片的宽度为w = width /2 - marginLeft - marginRight，marginLeft == marginRight == 5
          var margin = dip2px(context, 5 * 4);
          var w = (width - margin) / 2;
 //          var layoutParams = imageView.getLayoutParams();
//          layoutParams.width = w;
//
//           imageView.setLayoutParams(layoutParams);
          val ratio: Double = w * 1.0 / imageView.getWidth()
          val layoutParams = imageView.layoutParams
//          layoutParams.width = w
//          layoutParams.height = ((imageView.getHeight() * ratio).toInt())
//          imageView.layoutParams = layoutParams
          val roundOptions = RequestOptions().transform(RoundedCorners(18))
//处理CenterCrop的情况,保证圆角不失效
          roundOptions.transform(CenterCrop(), RoundedCorners(18))


          if(data==""){

              Glide.with(context)
                  .load("https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fbpic.588ku.com%2Felement_origin_min_pic%2F01%2F31%2F98%2F23573b5dd1b58d8.jpg&refer=http%3A%2F%2Fbpic.588ku.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=auto?sec=1658618896&t=b4045b062c8567c350dfe502c296b8d8")
                  .transform(CenterCrop(), RoundedCorners(56))
                  .apply(roundOptions)
                  .override(w, 800)  //给个最大值
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
    private fun getScreenWidthPx(): Int {
        val windowManager: WindowManager =
            context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
        val displayMetrics = DisplayMetrics()
        windowManager.getDefaultDisplay().getMetrics(displayMetrics)
        return displayMetrics.widthPixels
    }

    private fun getScreenHeightPx(): Int {
        val windowManager: WindowManager =
            context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
        val displayMetrics = DisplayMetrics()
        windowManager.getDefaultDisplay().getMetrics(displayMetrics)
        return displayMetrics.heightPixels
    }

    /**
     * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
     */
    fun dip2px(context: Context, dpValue: Int): Int {
        val scale = context.resources.displayMetrics.density
        return (dpValue * scale + 0.5f).toInt()
    }

    /**
     * 根据手机的分辨率从 sp 的单位 转成为 px(像素)
     */
    fun sp2px(context: Context, spValue: Float): Int {
        val scale = context.resources.displayMetrics.scaledDensity
        return (spValue * scale + 0.5f).toInt()
    }

    /**
     * 根据手机的分辨率从 px(像素) 的单位 转成为 dp
     */
    fun px2dip(context: Context, pxValue: Float): Int {
        val scale = context.resources.displayMetrics.density
        return (pxValue / scale + 0.5f).toInt()
    }
}
