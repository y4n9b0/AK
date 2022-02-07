package com.y4n9b0.ak

import android.Manifest
import android.content.Context
import android.content.ContextWrapper
import android.content.pm.PackageInfo
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import androidx.annotation.RequiresPermission

private val ContextWrapper.packageInfo: PackageInfo
    get() = packageManager.getPackageInfo(packageName, 0)

val ContextWrapper.appName: CharSequence
    get() = applicationInfo.loadLabel(packageManager)

val ContextWrapper.versionName: String
    get() = packageInfo.versionName

@Suppress("DEPRECATION")
val ContextWrapper.versionCode: Long
    get() =
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) packageInfo.longVersionCode
        else packageInfo.versionCode.toLong()

@Suppress("DEPRECATION")
@get:RequiresPermission(Manifest.permission.ACCESS_NETWORK_STATE)
val ContextWrapper.isNetworkAvailable: Boolean
    get() {
        val cm = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            cm.getNetworkCapabilities(cm.activeNetwork)?.run {
                hasCapability(NetworkCapabilities.NET_CAPABILITY_VALIDATED) &&
                        hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
            }
        } else {
            cm.activeNetworkInfo?.isConnectedOrConnecting
        } ?: false
    }
