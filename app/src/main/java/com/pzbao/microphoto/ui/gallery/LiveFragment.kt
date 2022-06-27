package com.pzbao.microphoto.ui.gallery

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.ui.gallery.GalleryViewModel
import com.pzbao.microphoto.R
import com.pzbao.microphoto.adapter.BujuListAdapter
import com.pzbao.microphoto.adapter.NumberListAdapter
import com.pzbao.microphoto.adapter.SuiCaiKuAdapter
import com.pzbao.microphoto.bean.BaseTypeBean
import com.pzbao.microphoto.config.PresenterClick
import com.pzbao.microphoto.databinding.FragmentGalleryBinding
import com.pzbao.microphoto.ui.mine.AboutUsActivity
import com.pzbao.microphoto.ui.mine.CustomServiceActivity
import com.pzbao.microphoto.ui.mine.FeedBackActivity
import com.pzbao.microphoto.ui.mine.OpenServiceActivity
import org.jetbrains.anko.support.v4.startActivity

class LiveFragment : Fragment() , PresenterClick {

    private lateinit var sucaiAdapter: SuiCaiKuAdapter
    private lateinit var numAdapter: NumberListAdapter
    private lateinit var mAdapter: BujuListAdapter
    private var _binding: FragmentGalleryBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private val listTask: MutableList<String> =
        mutableListOf()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val galleryViewModel =
            ViewModelProvider(this).get(GalleryViewModel::class.java)

        _binding = FragmentGalleryBinding.inflate(inflater, container, false).apply {
            presenterClick = this@LiveFragment
            lifecycleOwner = viewLifecycleOwner
        }
        val root: View = binding.root
        var bean=BaseTypeBean().apply {
            dataType=1
        }
        _binding?.data=bean
        numAdapter=NumberListAdapter()
       var  m=LinearLayoutManager(context)
        m.orientation=LinearLayoutManager.HORIZONTAL
        _binding?.recyviewNum?.layoutManager =m
        _binding?.recyviewNum?.adapter = numAdapter
        mAdapter=BujuListAdapter()
        _binding?.mRecyclerView?.layoutManager = GridLayoutManager(context,4)
        _binding?.mRecyclerView?.adapter = mAdapter
        listTask.add("")
        listTask.add("")
        listTask.add("")
        listTask.add("")
        listTask.add("")
        listTask.add("")
        listTask.add("")
        mAdapter.setNewInstance(listTask)
        numAdapter.setNewInstance(listTask)
        sucaiAdapter=SuiCaiKuAdapter()
        _binding?.recyviewSucai?.layoutManager = GridLayoutManager(context,5)
        _binding?.recyviewSucai?.adapter = sucaiAdapter
        sucaiAdapter?.setNewInstance(listTask)
//        val textView: TextView = binding.textGallery
//        galleryViewModel.text.observe(viewLifecycleOwner) {
//            textView.text = it
//        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.ll_tuceng ->{
                var bean=BaseTypeBean().apply {
                    dataType=1
                }
                 _binding?.data=bean
            }
            R.id.ll_buju ->{
                var bean=BaseTypeBean().apply {
                    dataType=2
                }
                _binding?.data=bean
            }
            R.id.ll_koutu ->{
                var bean=BaseTypeBean().apply {
                    dataType=3
                }
                _binding?.data=bean
            }
            R.id.ll_meiyan ->{
                var bean=BaseTypeBean().apply {
                    dataType=4
                }
                _binding?.data=bean
            }
            R.id.ll_meisheng ,R.id.ll_shengxiao->{
                var bean=BaseTypeBean().apply {
                    dataType=5
                }
                _binding?.data=bean
            }
            R.id.ll_shoushi ->{
                var bean=BaseTypeBean().apply {
                    dataType=6
                }
                _binding?.data=bean
            }
            R.id.ll_shengka ->{
                var bean=BaseTypeBean().apply {
                    dataType=7
                }
                _binding?.data=bean
            }
        }
    }
}