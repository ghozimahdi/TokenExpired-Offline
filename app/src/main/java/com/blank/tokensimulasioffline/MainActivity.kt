package com.blank.tokensimulasioffline

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.blank.tokensimulasioffline.service.AlarmHandle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val TAG = this::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val am = AlarmHandle(this)
        if (am.isWorking()) {
            Log.d(TAG, "Alarm Manager is Working")
        } else {
            Log.d(TAG, "Alarm Manager is Not Working, Will Start")
            am.setAlarmManager()
        }

        fetchDataUser.setOnClickListener {
            val sharedPref = SharedPref(this@MainActivity)
            if (sharedPref.isTokenExpiret) {
                Intent(this, LoginActivity::class.java).apply {
                    startActivity(this)
                    finish()
                }
            } else {
                tvShowData.text = "Token Belum Habis Kok ini Buktiknya!"
            }
        }
    }
}