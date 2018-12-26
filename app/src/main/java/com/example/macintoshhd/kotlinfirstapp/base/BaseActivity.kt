package com.example.macintoshhd.kotlinfirstapp.base

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.support.annotation.Nullable
import android.support.v7.app.AppCompatActivity
import cn.pedant.SweetAlert.SweetAlertDialog
import com.example.macintoshhd.kotlinfirstapp.R

open class BaseActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    fun showDialog(
        context: Context,
        sweetDialogType: Int, @Nullable content: String, @Nullable cancelable: Boolean
    ) {
        val pDialog = SweetAlertDialog(context, sweetDialogType)
        when (content.isNullOrEmpty()) {
            true -> when (sweetDialogType) {
                0 -> pDialog.setTitleText("Message")
                1 -> pDialog.setTitleText("Error!")
                2 -> pDialog.setTitleText("Success!")
                3 -> pDialog.setTitleText("Warning!")
                4 -> pDialog.setTitleText("Message")
                5 -> pDialog.setTitleText("Loading")
            }
            false -> pDialog.setTitleText(content)
        }
        when (cancelable) {
            true -> pDialog.setCancelable(true)
            false -> pDialog.setCancelable(false)
        }
    }

}