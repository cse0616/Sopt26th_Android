package com.example.sopt26seminar1

import android.content.Context
import android.content.SharedPreferences

object SharedPreferenceController {

    val MY_ACCOUNT = "unique_string"

    fun setUserID(ctx: Context, time:String) {
        val preference: SharedPreferences = ctx.getSharedPreferences(MY_ACCOUNT, Context.MODE_PRIVATE)
        val editor: SharedPreferences.Editor = preference.edit()
        editor.putString("u_id", time)
        editor.commit()
    }

    fun getUserID(ctx: Context): String{
        val preference: SharedPreferences = ctx.getSharedPreferences(MY_ACCOUNT, Context.MODE_PRIVATE)
        return preference.getString("u_id", "")
    }

    fun clearUserID(ctx: Context){
        val preference: SharedPreferences = ctx.getSharedPreferences(MY_ACCOUNT, Context.MODE_PRIVATE)
        val editor: SharedPreferences.Editor = preference.edit()
        editor.clear()
        editor.commit()
    }
}