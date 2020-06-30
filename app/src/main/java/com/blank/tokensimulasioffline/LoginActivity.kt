package com.blank.tokensimulasioffline

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val sharedPref = SharedPref(this)
        if (sharedPref.isLogin) {
            Intent(this, MainActivity::class.java).apply {
                startActivity(this)
                finish()
            }
        }
        setContentView(R.layout.activity_login)


        btnLogin.setOnClickListener {
            sharedPref.isTokenExpiret = false
            sharedPref.isLogin = true
            Intent(this, MainActivity::class.java).apply {
                startActivity(this)
                finish()
            }
        }
    }
}