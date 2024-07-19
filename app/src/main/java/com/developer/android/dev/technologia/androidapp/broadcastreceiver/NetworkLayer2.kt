package com.developer.android.dev.technologia.androidapp.broadcastreceiver

import android.content.Context
import android.net.ConnectivityManager
import android.net.ConnectivityManager.NetworkCallback
import android.net.Network
import android.net.NetworkCapabilities
import android.net.NetworkRequest
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class NetworkLayer2 : AppCompatActivity() {
    lateinit var connectivityManager: ConnectivityManager
    lateinit var networkCallback: NetworkCallback

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_network_layer2)

        connectivityManager = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

        networkCallback = object : ConnectivityManager.NetworkCallback(){
            override fun onAvailable(network: Network) {
                super.onAvailable(network)
                Toast.makeText(this@NetworkLayer2,"Network Available",Toast.LENGTH_LONG).show()
            }

            override fun onUnavailable() {
                super.onUnavailable()
                Toast.makeText(this@NetworkLayer2,"Network Unavailable",Toast.LENGTH_LONG).show()
            }

            override fun onLost(network: Network) {
                super.onLost(network)
                Toast.makeText(this@NetworkLayer2,"Network Lost",Toast.LENGTH_LONG).show()
            }

        }

    }

    override fun onResume() {
        super.onResume()

        val request = NetworkRequest.Builder()
            .addCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
            .build()

        connectivityManager.registerNetworkCallback(request,networkCallback)
    }

    override fun onStop() {
        super.onStop()
        connectivityManager.unregisterNetworkCallback(networkCallback)
    }
}