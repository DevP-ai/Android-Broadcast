package com.developer.android.dev.technologia.androidapp.broadcastreceiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.BatteryManager
import android.widget.TextView

class BatteryLevelReceiver(private val textView: TextView):BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {
        val level = intent?.getIntExtra(BatteryManager.EXTRA_LEVEL,-1)?:-1
        val scale = intent?.getIntExtra(BatteryManager.EXTRA_SCALE,-1)?:-1
        val batteryPct = level/scale.toFloat()*100


        textView.text = "Battery level: ${batteryPct}%"

    }

}