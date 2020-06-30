package com.blank.tokensimulasioffline.service

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

class BootService : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        if (intent?.action == Intent.ACTION_BOOT_COMPLETED || intent?.action == "android.intent.action.QUICKBOOT_POWERON") {
            val am =
                AlarmHandle(context!!)
            if (!am.isWorking())
                am.setAlarmManager()
        }
    }
}