package com.developer.android.dev.technologia.androidapp.broadcastreceiver

import android.annotation.SuppressLint
import android.content.Intent
import android.content.IntentFilter
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.net.NetworkRequest
import android.os.Build
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    lateinit var receiver: AirplaneModeReceiver
    lateinit var network : NetworkChangeReceiver
    lateinit var connectivityManager: ConnectivityManager
    private lateinit var batteryLevelReceiver: BatteryLevelReceiver


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        receiver = AirplaneModeReceiver()

        network = NetworkChangeReceiver()

        val textView = findViewById<TextView>(R.id.batteryLevel)
        batteryLevelReceiver = BatteryLevelReceiver(textView)


        IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED).also {
            registerReceiver(receiver,it)
        }


    }

    override fun onResume() {
        super.onResume()

        val intentFilter = IntentFilter().apply {
            addAction(ConnectivityManager.CONNECTIVITY_ACTION)
        }
        registerReceiver(network,intentFilter)

        registerReceiver(batteryLevelReceiver, IntentFilter(Intent.ACTION_BATTERY_CHANGED))
    }

    override fun onStop() {
        super.onStop()
        unregisterReceiver(receiver)
        unregisterReceiver(network)
        unregisterReceiver(batteryLevelReceiver)
    }
}