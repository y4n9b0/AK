package com.y4n9b0.ak

import android.annotation.SuppressLint
import android.content.Context
import android.content.res.Resources
import android.os.Build
import android.os.Handler
import android.os.Looper
import android.os.Message
import android.view.WindowManager
import android.widget.Toast
import androidx.annotation.IntDef
import androidx.annotation.StringRes

@IntDef(value = [Toast.LENGTH_SHORT, Toast.LENGTH_LONG])
@Retention(AnnotationRetention.SOURCE)
internal annotation class Duration

@Throws(Resources.NotFoundException::class)
fun Context.toast(@StringRes resId: Int, @Duration duration: Int = Toast.LENGTH_SHORT): Context =
    apply {
        Toast.makeText(this, resId, duration).ignoreBadToken().show()
    }

fun Context.toast(text: CharSequence, @Duration duration: Int = Toast.LENGTH_SHORT): Context =
    apply {
        Toast.makeText(this, text, duration).ignoreBadToken().show()
    }

@SuppressLint("DiscouragedPrivateApi")
fun Toast.ignoreBadToken(): Toast = apply {
    if (Build.VERSION.SDK_INT == Build.VERSION_CODES.N_MR1) {
        try {
            val tnField = Toast::class.java.getDeclaredField("mTN").apply { isAccessible = true }
            val tn = tnField.get(this)

            val handlerField = tnField.type.getDeclaredField("mHandler").apply {
                isAccessible = true
            }
            val handler = handlerField.get(tn) as Handler

            val looper = checkNotNull(Looper.myLooper()) {
                "Can't toast on a thread that has not called Looper.prepare()"
            }
            handlerField.set(tn, object : Handler(looper) {
                override fun handleMessage(msg: Message) {
                    try {
                        handler.handleMessage(msg)
                    } catch (ignored: WindowManager.BadTokenException) {
                    }
                }
            })
        } catch (ignored: IllegalAccessException) {
        } catch (ignored: NoSuchFieldException) {
        }
    }
}
