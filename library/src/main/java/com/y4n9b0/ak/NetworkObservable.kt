package com.y4n9b0.ak

import android.Manifest
import android.content.Context
import android.content.ContextWrapper
import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkCapabilities
import android.net.NetworkRequest
import android.os.Build
import androidx.annotation.RequiresPermission
import androidx.lifecycle.LiveData

class NetworkObservable @RequiresPermission(Manifest.permission.ACCESS_NETWORK_STATE) constructor(
    context: ContextWrapper
) : LiveData<Boolean>() {

    private val connectivityManager =
        context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

    private val networkRequest by lazy {
        NetworkRequest.Builder()
            .addTransportType(NetworkCapabilities.TRANSPORT_CELLULAR)
            .addTransportType(NetworkCapabilities.TRANSPORT_ETHERNET)
            .addTransportType(NetworkCapabilities.TRANSPORT_WIFI)
            .build()
    }

    private val networkCallback = object : ConnectivityManager.NetworkCallback() {
        override fun onAvailable(network: Network) {
            if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
                postValue(true)
            }
        }

        override fun onCapabilitiesChanged(
            network: Network,
            networkCapabilities: NetworkCapabilities
        ) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                networkCapabilities.run {
                    postValue(
                        hasCapability(NetworkCapabilities.NET_CAPABILITY_VALIDATED) &&
                                hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
                    )
                }
            }
        }

        override fun onLost(network: Network) {
            postValue(false)
        }
    }

    override fun onActive() {
        super.onActive()
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N)
            connectivityManager.registerDefaultNetworkCallback(networkCallback)
        else connectivityManager.registerNetworkCallback(networkRequest, networkCallback)
    }

    override fun onInactive() {
        super.onInactive()
        connectivityManager.unregisterNetworkCallback(networkCallback)
    }
}
