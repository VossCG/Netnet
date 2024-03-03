package com.example.netnet.extension

import android.content.Context
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment


fun Fragment.toast(message: String) {
    Toast.makeText(this.requireContext(), message, Toast.LENGTH_SHORT).show()
}

inline fun Context.alertDialog(init: AlertDialog.Builder.() -> Unit): AlertDialog =
    AlertDialog.Builder(this).apply(init).show()

fun Context.toast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}

fun dpToPx(context: Context, dp: Float): Int {
    val scale = context.resources.displayMetrics.density
    return (dp * scale + 0.5f).toInt()
}