package jp.co.faith.playlog_android.data.ext

import android.content.Context
import android.view.Gravity
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.StringRes

inline val Context.widthScreen: Int
    get() = resources.displayMetrics.widthPixels

inline val Context.heightScreen: Int
    get() = resources.displayMetrics.heightPixels

fun Context.toast(message: String, duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, message, duration)
        .apply { view?.findViewById<TextView>(android.R.id.message)?.gravity = Gravity.CENTER }
        .show()
}

fun Context.toast(@StringRes resId: Int, duration: Int = Toast.LENGTH_SHORT) {
    this.toast(this.getString(resId), duration)
}