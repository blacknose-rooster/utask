package com.example.salar.cevent.receivers;

import android.annotation.SuppressLint
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.net.wifi.WifiManager
import android.util.Log
import com.example.salar.cevent.LoginService


/**
 * Created by shayan4shayan on 1/24/18.
 * receiver for track wifi connection
 */
class WifiReceiver : BroadcastReceiver() {
    var context: Context? = null
    private var isConnecting = false

    @SuppressLint("WifiManagerPotentialLeak", "UnsafeProtectedBroadcastReceiver")
    override fun onReceive(context: Context?, intent: Intent?) {
        this.context = context
        LoginService.retryCount =0
        Log.d("WifiReceiver", "onReceive called")
        val manager = context?.getSystemService(Context.WIFI_SERVICE) as WifiManager
        if (manager.isWifiEnabled) {
            Log.d("WifiReceiver", "Wifi Available")
            if (!isConnecting) {
//                LoginService.retryCount=0
                context.startService(Intent(context, LoginService::class.java))
            }
        } else {
            Log.d("WifiReceiver", "wifi not available")
        }

    }
}