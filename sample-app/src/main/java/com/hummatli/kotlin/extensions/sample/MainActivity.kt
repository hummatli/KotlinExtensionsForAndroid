package com.hummatli.kotlin.extensions.sample

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

import com.hummatli.kotlin.extensions.R
import com.hummatli.kotlin.extensions.makeInvisible
import com.hummatli.kotlin.extensions.makeVisible
import com.hummatli.kotlin.extensions.setFont
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val FONT_MEDIUM = "fonts/RobotoTTF/Roboto-Medium.ttf"
    val FONT_REGULAR = "fonts/RobotoTTF/Roboto-Regular.ttf"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }

    fun init() {
        tbChangeVisibility.setOnCheckedChangeListener { compoundButton, b ->
            if(b) tvChangeVisibility.makeInvisible() else tvChangeVisibility.makeVisible()
        }

        tvChangeFont.setFont(FONT_MEDIUM)
        tbChangeFont.setOnCheckedChangeListener { compoundButton, b ->
            if(b) tvChangeFont.setFont(FONT_REGULAR) else tvChangeFont.setFont(FONT_MEDIUM)
        }
    }
}
