package com.blank.tokensimulasioffline

import android.content.Context

class SharedPref(context: Context) {
    private val pref = context.getSharedPreferences("cobaAjah", Context.MODE_PRIVATE)
    private val ISTOKENBRO = "isTokenExpt"
    private val ISlOGIN = "islogin"
    private val COUNT = "COUNT"

    var isTokenExpiret: Boolean
        set(value) {
            pref.edit()
                .putBoolean(ISTOKENBRO, value)
                .apply()
        }
        get() = pref.getBoolean(ISTOKENBRO, false)

    var isLogin: Boolean
        set(value) {
            pref.edit()
                .putBoolean(ISlOGIN, value)
                .apply()
        }
        get() = pref.getBoolean(ISlOGIN, false)

    var count: Int
        set(value) {
            pref.edit()
                .putInt(COUNT, value)
                .apply()
        }
        get() = pref.getInt(COUNT, 0)
}