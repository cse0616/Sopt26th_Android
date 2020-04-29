package com.example.sopt26seminar1

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class FirstActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)

        if(SharedPreferenceController.getUserID(this).isEmpty()){
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }
        else{
            Toast.makeText(this, "자동로그인", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}