package com.y4n9b0.ak

import android.os.Looper

/**
 * 如果 minSdkVersion >= 23 (Build.VERSION_CODES.M)，
 * 可以直接使用 Looper.getMainLooper().isCurrentThread，
 * 其判断原理是一样，仅写法更简便。
 */
val isMainThread: Boolean
    get() = Looper.getMainLooper().thread == Thread.currentThread()
