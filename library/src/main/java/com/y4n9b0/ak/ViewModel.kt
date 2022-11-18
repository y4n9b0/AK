package com.y4n9b0.ak

import android.os.Build
import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import androidx.annotation.MainThread
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

fun argViewModelFactory(vararg args: Any): ViewModelProvider.Factory =
    object : ViewModelProvider.NewInstanceFactory() {
        @Suppress("UNCHECKED_CAST")
        override fun <VM : ViewModel> create(modelClass: Class<VM>): VM {
            modelClass.constructors.filter {
                args.size == if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    it.parameterCount
                } else {
                    it.parameterTypes.size
                }
            }.forEach {
                try {
                    return it.newInstance(*args) as VM
                } catch (ignore: Exception) {
                    // 构造参数个数一致，但可能参数类型不匹配
                }
            }
            throw InstantiationException("Cannot create an instance of $modelClass")
        }
    }

@MainThread
inline fun <reified VM : ViewModel> Fragment.argViewModels(vararg args: Any) =
    viewModels<VM> { argViewModelFactory(*args) }

@MainThread
inline fun <reified VM : ViewModel> Fragment.activityArgViewModels(vararg args: Any) =
    activityViewModels<VM> { argViewModelFactory(*args) }

@MainThread
inline fun <reified VM : ViewModel> ComponentActivity.argViewModels(vararg args: Any) =
    viewModels<VM> { argViewModelFactory(*args) }