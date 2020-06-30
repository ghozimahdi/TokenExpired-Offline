package com.blank.tokensimulasioffline.service

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast
import com.blank.tokensimulasioffline.SharedPref

class MyReceiverToken : BroadcastReceiver() {
    private val TAG = MyReceiverToken::class.simpleName

    companion object {
        val TOKEN = "TOKEN"
    }

    override fun onReceive(context: Context?, intent: Intent?) {
        Log.d(TAG, "Start")
        if (intent?.action == TOKEN) {
            Toast.makeText(context, "Token Receiver Working", Toast.LENGTH_LONG).show()
            val shared = SharedPref(context!!)
            if (shared.count > 0) {
                shared.isTokenExpiret = true
                shared.isLogin = false
            }
            shared.count++
        }
    }
}