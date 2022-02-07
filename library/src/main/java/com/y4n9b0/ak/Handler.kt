package com.y4n9b0.ak

import android.os.Handler
import android.os.Looper
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.OnLifecycleEvent

@Deprecated(
    "Cannot avoid passing arguments Looper and Handler.Callback!",
    replaceWith = ReplaceWith("Extended function LifecycleOwner#lifecycleHandler(Looper, Handler.Callback)"),
    level = DeprecationLevel.HIDDEN
)
val lifecycleHandler: LifecycleOwner.(Looper, Handler.Callback?) -> Handler = { looper, callback ->
    LifecycleHandler(this, looper, callback)
}

fun LifecycleOwner.lifecycleHandler(
    looper: Looper = Looper.getMainLooper(),
    callback: Handler.Callback? = null
): Handler = LifecycleHandler(this, looper, callback)

private class LifecycleHandler(
    private val owner: LifecycleOwner,
    looper: Looper = Looper.getMainLooper(),
    callback: Callback? = null
) : Handler(looper, callback), LifecycleObserver {
    init {
        owner.lifecycle.addObserver(this)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    private fun onDestroy() {
        owner.lifecycle.removeObserver(this)
        removeCallbacksAndMessages(null)
    }
}
