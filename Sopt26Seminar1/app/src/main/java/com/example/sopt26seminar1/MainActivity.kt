package com.example.sopt26seminar1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button()
        btn_logout.setOnClickListener {
            SharedPreferenceController.clearUserID(this)
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()

        }
    }

    private fun button(){
        if(SharedPreferenceController.getUserID(this).isEmpty()){
            btn_logout.text = "로그인"
        }
        else{
            btn_logout.text = "로그아웃"
        }
    }
}
