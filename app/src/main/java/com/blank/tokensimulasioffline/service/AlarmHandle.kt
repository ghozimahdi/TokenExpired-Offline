package com.blank.tokensimulasioffline.service

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent

class AlarmHandle(private val context: Context) {

    fun setAlarmManager() {
        val intent = Intent(context, MyReceiverToken::class.java).apply {
            action = MyReceiverToken.TOKEN
        }
        val sender = PendingIntent.getBroadcast(context, 2, intent, 0)
        val am = context.getSystemService(Context.ALARM_SERVICE) as AlarmManager

        val triggerAfter: Long = 2 * 60 * 1000
        val triggerEvery: Long = 2 * 60 * 1000 // mengulang setiap 2 menit
        am.setRepeating(AlarmManager.RTC_WAKEUP, triggerAfter, triggerEvery, sender)
    }

    fun isWorking(): Boolean {
        val intent = Intent(context, MyReceiverToken::class.java).apply {
            action = MyReceiverToken.TOKEN
        }
        return (PendingIntent.getBroadcast(
            context,
            2,
            intent,
            PendingIntent.FLAG_NO_CREATE
        ) != null)
    }

    fun cancelAlarmManager() {
        val intent = Intent(context, MyReceiverToken::class.java).apply {
            action = MyReceiverToken.TOKEN
        }
        val sender = PendingIntent.getBroadcast(context, 2, intent, 0)
        val am = context.getSystemService(Context.ALARM_SERVICE) as AlarmManager
        am.cancel(sender)
        sender.cancel()
    }
}