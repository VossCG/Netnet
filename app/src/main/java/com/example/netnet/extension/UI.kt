package com.example.netnet.extension

import android.content.Context
import android.graphics.Color
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment


fun View.show() {
    this.visibility = View.VISIBLE
}

fun View.hide() {
    this.visibility = View.INVISIBLE
}

fun View.gone() {
    this.visibility = View.GONE
}

fun Fragment.toast(message: String) {
    Toast.makeText(this.requireContext(), message, Toast.LENGTH_SHORT).show()
}

fun TextView.setAccountText(text: String?) {
    text?.let {
        if (it.contains("-")) {
            setTextColor(Color.RED)
        } else {
            setTextColor(Color.WHITE)
        }
        setText(it)
    } ?: setText("")
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