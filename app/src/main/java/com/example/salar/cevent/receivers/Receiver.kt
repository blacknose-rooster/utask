package com.example.salar.cevent.receivers;

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.example.salar.cevent.NotificationUtil

class Receiver : BroadcastReceiver() {
    override fun onReceive(p0: Context?, p1: Intent?) {
        NotificationUtil.sendNotification(p0)
    }

}