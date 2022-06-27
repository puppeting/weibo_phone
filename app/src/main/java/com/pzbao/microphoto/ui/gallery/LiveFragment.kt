package com.pzbao.microphoto.ui.gallery

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.ui.gallery.GalleryViewModel
import com.gaoding.editor.image.api.EditorMode
import com.gaoding.editor.image.api.GDImageEditorSDK
import com.gaoding.editor.image.api.IGDImageEditorSDKCallback
import com.pzbao.microphoto.R
import com.pzbao.microphoto.adapter.BujuListAdapter
import com.pzbao.microphoto.adapter.NumberListAdapter
import com.pzbao.microphoto.adapter.SuiCaiKuAdapter
import com.pzbao.microphoto.bean.BaseTypeBean
import com.pzbao.microphoto.config.PresenterClick
import com.pzbao.microphoto.databinding.FragmentGalleryBinding

class LiveFragment : Fragment() , PresenterClick {

    private var mImageEditor: GDImageEditorSDK? = null
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
        mImageEditor = GDImageEditorSDK(requireActivity())
        mImageEditor?.setThirdCateId("80")
        mImageEditor?.setCallback(object : IGDImageEditorSDKCallback() {
            override fun onTemplateClick(templateId: String, mode: EditorMode) {
                mImageEditor?.openImageEditor(templateId, mode)
            }

            override fun onEditCompleted(workId: String, sourceId: String, imageUrl: String) {
                mImageEditor?.openCompletePage(workId, sourceId, imageUrl)
            }

            override fun onDownloadEditResult(imageUrl: String) {
                Log.d("ddddd", "onDownloadEditResult:$imageUrl")
            }

            override fun getAuthCode(callback: AuthCallback) {
                Log.d("ddddd", "onDownloadEditResult:${callback.onFailure().toString()}")

                try {
//                    getOkHttpAuthCode(callback)
                } catch (e: Exception) {
                    Toast.makeText(requireContext(), "getAuthCode出错", Toast.LENGTH_SHORT).show()
                    e.printStackTrace()
                }
            }
        })
        return root
    }
//    @Throws(java.lang.Exception::class)
//    private fun getOkHttpAuthCode(callback: AuthCallback?) {
//        val client = OkHttpClient()
//        val JSON: MediaType = MediaType.get("application/json;charset=utf-8")
//        val jsonObject = JSONObject()
//        try {
//            jsonObject.put("uid", "666")
//        } catch (e: JSONException) {
//            e.printStackTrace()
//        }
//        val timeStamp = System.currentTimeMillis() / 1000
//        Log.d(MainActivity.TAG, "timeStamp:$timeStamp")
//        val ak = "8DF7FEF5DFFFACDEF0F287266D0B8B21"
//        val sk = "50BE03427C039AD53391586BF9D7A907"
//        val httpMethod = "POST"
//        val uri = "/sso/oauth/authorize/sdk/"
//        val queryString = ""
//        val requestRaw = "$httpMethod@$uri@$queryString@$timeStamp@$jsonObject"
//        Log.d(MainActivity.TAG, "body:$jsonObject")
//        Log.d(MainActivity.TAG, "requestRaw:$requestRaw")
//        val signature = getHMAC(requestRaw, sk).trim { it <= ' ' }
//        Log.d(MainActivity.TAG, "signature:$signature")
//        val body = RequestBody.create(JSON, jsonObject.toString())
//        val request = Request.Builder()
//            .url("https://api.open.gaoding.com/sso/oauth/authorize/sdk/")
//            .addHeader("Content-Type", "application/json")
//            .addHeader("X-Timestamp", timeStamp.toString())
//            .addHeader("X-AccessKey", ak)
//            .addHeader("X-Signature", signature)
//            .post(body)
//            .build()
//        client.newCall(request).enqueue(object : Callback {
//            @Throws(IOException::class)
//            override fun onResponse(call: Call, response: Response) {
//                val body = response.body()
//                if (body == null) {
//                    callback?.onFailure()
//                    return
//                }
//                val data = body.string()
//                Log.d(MainActivity.TAG, "onResponse data:$data")
//                try {
//                    val jsonObject = JSONObject(data)
//                    val code = jsonObject.optString("code")
//                    callback?.onSuccess(code)
//                } catch (e: JSONException) {
//                    e.printStackTrace()
//                    callback?.onFailure()
//                }
//            }
//
//            override fun onFailure(call: Call, e: IOException) {
//                e.printStackTrace()
//                callback?.onFailure()
//            }
//        })
//    }
//
//    @Throws(java.lang.Exception::class)
//    fun getHMAC(data: String, key: String): String {
//        val HMAC_SHA1_ALGORITHM = "HmacSHA1"
//        val signinKey = SecretKeySpec(key.toByteArray(), HMAC_SHA1_ALGORITHM)
//        val mac = Mac.getInstance(HMAC_SHA1_ALGORITHM)
//        mac.init(signinKey)
//        val rawHmac = mac.doFinal(data.toByteArray())
//        return String(Base64.encode(rawHmac, Base64.NO_WRAP))
//    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.ll_tuceng ->{
                mImageEditor?.openImageEditor("14026604557898833", EditorMode.COMPANY)
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