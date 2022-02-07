package com.y4n9b0.ak

import android.util.Log

// 调用链中如果有 inline 函数，trace 则会有偏差
private val traceTag: String
    get() {
        val trace: StackTraceElement = Thread.currentThread().stackTrace[4]
        return "${trace.className}#${trace.methodName}#${trace.lineNumber}"
    }

fun String.logv(tag: String = traceTag) = Log.v(tag, this)

fun String.logd(tag: String = traceTag) = Log.d(tag, this)

fun String.logi(tag: String = traceTag) = Log.i(tag, this)

fun String.logw(tag: String = traceTag) = Log.w(tag, this)

fun String.loge(tag: String = traceTag) = Log.e(tag, this)
