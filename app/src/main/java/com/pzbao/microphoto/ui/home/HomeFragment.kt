package com.pzbao.microphoto.ui.home

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.ui.home.HomeViewModel
import com.pzbao.microphoto.R
import com.pzbao.microphoto.adapter.HomeRecyclerAdapter
import com.pzbao.microphoto.adapter.HomeSuiCaiAdapter
import com.pzbao.microphoto.config.PresenterClick
import com.pzbao.microphoto.databinding.FragmentHomeBinding
import com.pzbao.microphoto.pop.*
import com.pzbao.microphoto.ui.mine.AppStoreActivity
import org.jetbrains.anko.support.v4.startActivity


class HomeFragment : Fragment() , PresenterClick {

    private var adapter2: HomeRecyclerAdapter? = null
    private var _binding: FragmentHomeBinding? = null
    private var adapter: HomeSuiCaiAdapter? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private val listTask: MutableList<String> =
        mutableListOf()
    private val listTask1: MutableList<String> =
        mutableListOf()
    @SuppressLint("WrongConstant")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false).apply {
            presenterClick = this@HomeFragment
            lifecycleOwner = viewLifecycleOwner
        }
        val root: View = binding.root

        val textView: ImageView = binding.ivSeeting
        val grid2 = LinearLayoutManager(activity)
        listTask.add("")
        adapter2 = context?.let { HomeRecyclerAdapter(it, listTask) }
        binding.recyviewHome.setLayoutManager(grid2)
        binding.recyviewHome.setAdapter(adapter2)
        val grid1 = LinearLayoutManager(activity)
         listTask1.add("https://lupic.cdn.bcebos.com/20210629/2005401331_14.jpg")
        listTask1.add("https://lupic.cdn.bcebos.com/20210629/2005401331_14.jpg")
        listTask1.add("https://lupic.cdn.bcebos.com/20210629/2005401331_14.jpg")
        listTask1.add("https://lupic.cdn.bcebos.com/20210629/2005401331_14.jpg")
        listTask1.add("https://lupic.cdn.bcebos.com/20210629/2005401331_14.jpg")
        grid1.orientation=LinearLayoutManager.HORIZONTAL
        binding.llMore.setOnClickListener {
//            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("main://user")))
              startActivity<AppStoreActivity>()
        }
        adapter = HomeSuiCaiAdapter()
        binding.recyviewSucai.setLayoutManager(grid1)
        binding.recyviewSucai.setAdapter(adapter)
        adapter?.setNewInstance(listTask1)
        _binding?.ivSeeting?.setOnClickListener {
            _binding?.drawerLayout?.openDrawer(Gravity.START); }

          root!!.findViewById<LinearLayout>(R.id.ll_tuiliu_seet).setOnClickListener {
              TuiLiuDialog(context, R.style.MyDialogStyle).show()

          } //自定义的控件名
        binding?.drawerLayout?.addDrawerListener(object :DrawerLayout.DrawerListener{
            override fun onDrawerSlide(drawerView: View, slideOffset: Float) {

            }

            override fun onDrawerOpened(drawerView: View) {

            }

            override fun onDrawerClosed(drawerView: View) {

            }

            override fun onDrawerStateChanged(newState: Int) {

            }

        })
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.ll_tuiliu_seet ->{
                TuiLiuDialog(context, R.style.MyDialogStyle).show()
            }
            R.id.relative_laliu_seet ->{

                LaLiuDialog(context, R.style.MyDialogStyle).show()

            }
            R.id.ll_yuyinzhushou ->{

                YuYinDialog(context, R.style.MyDialogStyle).show()

            }
            R.id.ll_fenxiang ->{

                DanMuDialog(context, R.style.MyDialogStyle).show()

            }
            R.id.ll_aboutus ->{

                ZhiBoJianDialog(context, R.style.MyDialogStyle).show()

            }

            R.id.tv_more2 ->{
                 startActivity<SuiCaiActivity>()

            }
        }
    }
}