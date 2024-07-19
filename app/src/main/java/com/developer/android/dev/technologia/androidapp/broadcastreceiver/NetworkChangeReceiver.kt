package com.developer.android.dev.technologia.androidapp.broadcastreceiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.widget.Toast

class NetworkChangeReceiver:BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        val connectivityManager = context?.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

        val network = connectivityManager.activeNetwork
        val networkInfo = connectivityManager.getNetworkCapabilities(network)

        val isConnected = networkInfo?.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET) == true

        if(isConnected){
            Toast.makeText(context,"Network available",Toast.LENGTH_LONG).show()
        }else{
            Toast.makeText(context,"Network not available",Toast.LENGTH_LONG).show()
        }

    }
}