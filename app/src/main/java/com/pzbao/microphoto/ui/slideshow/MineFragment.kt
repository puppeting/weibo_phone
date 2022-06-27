package com.pzbao.microphoto.ui.slideshow

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.ui.slideshow.SlideshowViewModel
import com.pzbao.microphoto.R
import com.pzbao.microphoto.config.PresenterClick
import com.pzbao.microphoto.databinding.FragmentSlideshowBinding
import com.pzbao.microphoto.ui.home.SuiCaiActivity
import com.pzbao.microphoto.ui.mine.*
import org.jetbrains.anko.support.v4.startActivity

class MineFragment : Fragment(), PresenterClick {

    private var _binding: FragmentSlideshowBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    @SuppressLint("WrongConstant")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val slideshowViewModel =
            ViewModelProvider(this).get(SlideshowViewModel::class.java)

        _binding = FragmentSlideshowBinding.inflate(inflater, container, false).apply {
             presenterClick = this@MineFragment
            lifecycleOwner = viewLifecycleOwner
        }
        val root: View = binding.root

        _binding?.llJifen?.setOnClickListener {
            _binding?.drawerLayout?.openDrawer(Gravity.START); }
//        _binding?.barB?.getThumb()?.set//滑块

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onClick(v: View?) {
         when(v?.id){
             R.id.ll_aboutus ->{
                 startActivity<AboutUsActivity>()
             }
             R.id.relative_seeting ->{
                 startActivity<OpenServiceActivity>()
             }
             R.id.relative_dingzhi ->{
                 startActivity<CustomServiceActivity>()
             }
             R.id.ll_question ->{
                 startActivity<FeedBackActivity>()
             }
             R.id.ll_sucai ->{
                      startActivity<SuiCaiActivity>()

             }
             R.id.ll_fenxiang ->{
                 startActivity<SharedActivity>()

             }
         }
    }
}