package com.developer.android.dev.technologia.androidapp.broadcastreceiver

import android.content.Intent
import android.content.IntentFilter
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.net.NetworkRequest
import android.os.Build
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    lateinit var receiver: AirplaneModeReceiver
    lateinit var network : NetworkChangeReceiver
    lateinit var connectivityManager: ConnectivityManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        receiver = AirplaneModeReceiver()

//        network = NetworkChangeReceiver()


        val goToNetworkLayer = this.findViewById<Button>(R.id.btn_network)
        goToNetworkLayer.setOnClickListener {
            startActivity(Intent(this@MainActivity,NetworkLayer2::class.java))
        }



        IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED).also {
            registerReceiver(receiver,it)
        }



    }

    override fun onResume() {
        super.onResume()

//        val intentFilter = IntentFilter().apply {
//            addAction(ConnectivityManager.CONNECTIVITY_ACTION)
//        }
//        registerReceiver(network,intentFilter)
    }

    override fun onStop() {
        super.onStop()
        unregisterReceiver(receiver)
//        unregisterReceiver(network)
    }
}