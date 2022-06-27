package com.pzbao.microphoto.ui.sucai

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.pzbao.microphoto.R
import com.pzbao.microphoto.adapter.SuCaiListAdapter
import com.pzbao.microphoto.adapter.SuCaiListVideoAdapter
import com.pzbao.microphoto.bean.BaseTypeBean
import com.pzbao.microphoto.config.PresenterClick
import com.pzbao.microphoto.databinding.FragmentSuCaiBinding
import org.jetbrains.anko.support.v4.startActivity

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [SuCaiFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SuCaiFragment : Fragment(),PresenterClick {
    private lateinit var mAdapter: SuCaiListAdapter
    private lateinit var _binding: FragmentSuCaiBinding
    private lateinit var mAdapter2: SuCaiListVideoAdapter

    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private val listTask1: MutableList<String> =
        mutableListOf()
    private val listTask: MutableList<String> =
        mutableListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentSuCaiBinding.inflate(inflater, container, false).apply {
            presenterClick = this@SuCaiFragment
            lifecycleOwner = viewLifecycleOwner
        }
        val root: View = _binding.root
        mAdapter= SuCaiListAdapter()
        mAdapter2= SuCaiListVideoAdapter()
        listTask1.add("https://lupic.cdn.bcebos.com/20210629/2005401331_14.jpg")
        listTask1.add("https://lupic.cdn.bcebos.com/20210629/2005401331_14.jpg")
        listTask1.add("https://lupic.cdn.bcebos.com/20210629/2005401331_14.jpg")
        listTask1.add("")
        listTask.add("https://lupic.cdn.bcebos.com/20210629/2005401331_14.jpg")
        listTask.add("https://lupic.cdn.bcebos.com/20210629/2005401331_14.jpg")
        listTask.add("")
        listTask.add("")

//        viewBind?.recyview?.layoutManager = GridLayoutManager(this,4)
        val layoutManager = StaggeredGridLayoutManager(4, StaggeredGridLayoutManager.VERTICAL)
//        layoutManager.setGapStrategy(StaggeredGridLayoutManager.GAP_HANDLING_NONE)
        _binding.recyview.setLayoutManager(layoutManager)
        _binding?.recyview?.adapter = mAdapter
        mAdapter?.setNewInstance(listTask1)
        val layoutManager1 = StaggeredGridLayoutManager(4, StaggeredGridLayoutManager.VERTICAL)
//        layoutManager.setGapStrategy(StaggeredGridLayoutManager.GAP_HANDLING_NONE)
        _binding.recyview2.setLayoutManager(layoutManager1)
        _binding?.recyview2?.adapter = mAdapter2
        mAdapter2?.setNewInstance(listTask)
        var bean= BaseTypeBean().apply {
            colorType=1
        }
        _binding?.data=bean
        return root
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment SuCaiFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            SuCaiFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.tv_yunpan ->{
                var bean= BaseTypeBean().apply {
                    colorType=1
                }
                _binding?.data=bean
//                listTask1.removeAt(3)
//                mAdapter?.setData(3,"")
//                mAdapter?.notifyDataSetChanged()
            }
            R.id.tv_bendi ->{
                var bean= BaseTypeBean().apply {
                    colorType=2
                }
                _binding?.data=bean
//                listTask1.removeAt(3)
//                mAdapter?.setData(3,"11")
//                mAdapter?.notifyDataSetChanged()
            }
            R.id.tv_xiangce ->{
//                var bean= BaseTypeBean().apply {
//                    colorType=3
//                }
//                _binding?.data=bean
                startActivity<XiangCeActivity>()
            }
            R.id.chip_apply ->{
                 startActivity<DaoRuActivity>()

            }
        }
    }
}