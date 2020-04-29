package com.example.sopt26seminar1

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        btn_register.setOnClickListener {
            val intent = Intent(this,LoginActivity::class.java)
            intent.putExtra("email", et_email_register.text.toString())
            intent.putExtra("password", et_password_register.text.toString())
            setResult(RESULT_OK, intent)
            finish()
        }
    }
}