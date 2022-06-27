package com.pzbao.microphoto.config

import android.view.View

interface PresenterClick : View.OnClickListener {
    override fun onClick(v: View?)
}

