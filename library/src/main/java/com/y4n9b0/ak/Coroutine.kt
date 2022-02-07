package com.y4n9b0.ak

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

inline fun <T> CoroutineScope.launch(
    context: CoroutineContext = CoroutineExceptionHandler { _, throwable -> onFailure(throwable) },
    start: CoroutineStart = CoroutineStart.DEFAULT,
    crossinline action: suspend () -> Result<T>,
    crossinline onSuccess: (T?) -> Unit = {},
    crossinline onFailure: (Throwable) -> Unit = {}
): Job = launch(context, start) { action().onSuccess(onSuccess).onFailure(onFailure) }

inline fun <T> ViewModel.launch(
    context: CoroutineContext = CoroutineExceptionHandler { _, throwable -> onFailure(throwable) },
    start: CoroutineStart = CoroutineStart.DEFAULT,
    crossinline action: suspend () -> Result<T>,
    crossinline onSuccess: (T?) -> Unit = {},
    crossinline onFailure: (Throwable) -> Unit = {}
): Job = viewModelScope.launch(context, start, action, onSuccess, onFailure)

val coroutineExceptionHandler: ((Throwable) -> Unit).() -> CoroutineExceptionHandler = {
    CoroutineExceptionHandler { _, throwable -> this(throwable) }
}

private val jobs: MutableMap<String, Job> = mutableMapOf()
fun Job.cancelLast(): Job = apply {
    val trace = Thread.currentThread().stackTrace[4]
    val tag = "${trace.className}#${trace.methodName}#${trace.lineNumber}"
    jobs[tag]?.cancel()
    jobs[tag] = apply {
        invokeOnCompletion { jobs.remove(tag) }
    }
}
