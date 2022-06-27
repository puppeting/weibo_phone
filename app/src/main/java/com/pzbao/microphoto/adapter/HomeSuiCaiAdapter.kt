package com.pzbao.microphoto.adapter

import android.graphics.Bitmap
import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.RequestOptions
import com.chad.library.adapter.base.BaseQuickAdapter

import com.chad.library.adapter.base.viewholder.BaseViewHolder
 import com.pzbao.microphoto.R


 import java.util.HashMap


/**

 */
class HomeSuiCaiAdapter : BaseQuickAdapter<String, BaseViewHolder>(R.layout.item_sucai_recycle)  {


      override fun convert(helper: BaseViewHolder, data: String) {
          helper.getView<ImageView>(R.id.iv_xiazai)?.visibility= View.GONE
//          val imageView = helper.getView<ImageView>(R.id.iv_bg)
//
//          val options: RequestOptions = RequestOptions()
//              .diskCacheStrategy(DiskCacheStrategy.ALL)
//              .placeholder(R.mipmap.home_banner)
//              .error(R.mipmap.home_banner)
//          Glide.with(context)
//              .asBitmap()
//              .apply(options)
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
//              .load(data.toString())
//              .into(imageView)
//
    }
}
