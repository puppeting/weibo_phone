package com.pzbao.microphoto.utils

import android.os.Bundle
import android.view.View
import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import androidx.navigation.NavOptions
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import com.alibaba.android.arouter.launcher.ARouter
import com.pzbao.microphoto.R

object IRouter {
    fun go(context: Any?, url: String, vararg bundle:Bundle) {
        val aRouter = ARouter.getInstance().build(url)
        aRouter.navigation()
    }

    fun goF(view: View, action: String? = "", vararg bundle:Bundle) {
        val actionId = when (action) {
            "action_to_applyActivity" -> {
                2
            }
            "action_to_applyList" -> {
                1
            }
            else -> {
                null
            }
        }
        goF2(view, actionId, *bundle)
    }

    fun goF2(view: View, @IdRes action: Int? = null, vararg bundle:Bundle) {
        val bundle = Bundle()
        val findNavController = Navigation.findNavController(view)
        when (action) {
//            R.id.action_to_applyActivity -> {
//                bean.forEachIndexed { index, any ->
//                    when (index) {
//                        0 -> {
//                            bundle.putString("creditId", any.toString())
//                            bundle.putString("dhId", any.toString())
//                            bundle.putString("zfId", any.toString())
//                            bundle.putString("ysxId", any.toString())
//                            bundle.putString("keyId", any.toString())
//                        }
//                        1 -> {
//                            bundle.putInt("businessType", any as Int)
//                        }
//                        2 -> {
//                            bundle.putBoolean("seeOnly", any as Boolean)
//                        }
//
//                    }
//
//                }
//            }

        }
        if (action != null) findNavController.navigate(action, bundle)
    }

    fun goF(fragment: Fragment, @IdRes action: Int? = null, isPopUpTo: Boolean, inclusive: Boolean = true, vararg bean: Any?) {
        val bundle = Bundle()
        val findNavController = NavHostFragment.findNavController(fragment)
        if (action != null) if (isPopUpTo) {
            findNavController.navigate(action, bundle, NavOptions.Builder()
                .setPopUpTo(action, inclusive).build())
        } else {
            findNavController.navigate(action)
        }

    }


}