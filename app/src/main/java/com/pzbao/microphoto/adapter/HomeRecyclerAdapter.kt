package com.pzbao.microphoto.adapter

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import com.pzbao.microphoto.utils.OnItemClickLitener
import android.widget.TextView
import android.view.ViewGroup
import android.view.LayoutInflater
import android.view.View
import com.pzbao.microphoto.R
import android.view.View.OnLongClickListener
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions

/**
 */
class HomeRecyclerAdapter(private val context: Context, private var list: List<String>?) :
    RecyclerView.Adapter<HomeRecyclerAdapter.ViewHolder>() {
    private var pos = -1
    private var mItemClickListener: OnItemClickLitener? = null
    private var tvName: TextView? = null
    private val tvMore: TextView? = null
    private val tvAddress: TextView? = null
    private val tvType: TextView? = null
    private val tvTime: TextView? = null
    fun setItemClickListener(mItemClickListener: OnItemClickLitener?) {
        this.mItemClickListener = mItemClickListener
    }

    fun setPos(pos: Int) {
        this.pos = pos
        notifyDataSetChanged()
    }

    fun setList(list: List<String>?) {
        this.list = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val view =
            LayoutInflater.from(context).inflate(R.layout.item_home_layout, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) { //设
        tvName = holder.itemView.findViewById<View>(R.id.tv_name) as TextView
        val iv = holder.itemView.findViewById<View>(R.id.iv_imageview) as ImageView
        //        Glide.with(context).load("https://manhua.qpic.cn/vertical/0/07_22_36_afe651da2ab940d0e257a1ec894bd992_1504795010150.jpg/420")
//                .apply(RequestOptions.bitmapTransform(RoundedCorners(20)))
//                .into(iv);
        Glide.with(context)
            .load("https://img1.baidu.com/it/u=4059217342,688374225&fm=253&fmt=auto&app=138&f=JPEG?w=821&h=500")
            .transform(CenterCrop(),RoundedCorners(16))
            .transition(DrawableTransitionOptions.withCrossFade(500))
            .into(iv)
    }

    override fun getItemCount(): Int {
        return if (list == null) 0 else list!!.size
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        init {
            view.setOnClickListener {
                if (null != mItemClickListener) {
                    mItemClickListener!!.onItemClick(view, position)
                }
            }

            /* 长按回调*/view.setOnLongClickListener {
                if (null != mItemClickListener) {
                    mItemClickListener!!.onItemLongClick(view, position)
                }
                true
            }
        }
    }
}