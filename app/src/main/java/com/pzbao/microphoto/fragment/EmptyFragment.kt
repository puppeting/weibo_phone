package com.pzbao.microphoto.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.pzbao.microphoto.base.MyBaseFragment
import com.pzbao.microphoto.config.PresenterClick
import com.pzbao.microphoto.databinding.FragmentEmptyBinding

/**
 * 暂未开发
 *
 * */
class EmptyFragment : MyBaseFragment(), PresenterClick {
    lateinit var viewBind: FragmentEmptyBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        viewBind = FragmentEmptyBinding.inflate(inflater, container, false).apply {
            presenterClick = this@EmptyFragment
            lifecycleOwner = viewLifecycleOwner
        }
        return viewBind.root
    }

    override fun initView() {
    }
    override fun initData() {
    }


    override fun onClick(v: View?) {
    }

}