package com.example.netnet.extension

import android.content.Context
import android.widget.Toast
import androidx.appcompat.app.AlertDialog


fun Context.showToast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}


inline fun Context.alertDialog(init: AlertDialog.Builder.() -> Unit): AlertDialog =
    AlertDialog.Builder(this).apply(init).show()

fun Context.toast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}
