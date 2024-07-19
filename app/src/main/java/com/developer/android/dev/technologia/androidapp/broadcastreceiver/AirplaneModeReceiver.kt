package com.developer.android.dev.technologia.androidapp.broadcastreceiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class AirplaneModeReceiver:BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        val isAirPlaneModeEnable = intent?.getBooleanExtra("state",false) ?: return

        if(isAirPlaneModeEnable){
            Toast.makeText(context,"Airplane Mode enable",Toast.LENGTH_LONG).show()
        }else{
            Toast.makeText(context,"Airplane Mode disable",Toast.LENGTH_LONG).show()
        }
    }
}