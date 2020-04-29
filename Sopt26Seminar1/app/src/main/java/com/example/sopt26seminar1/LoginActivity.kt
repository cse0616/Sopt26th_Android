package com.example.sopt26seminar1

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.FrameLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    private val REQUEST_CODE = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        btn_login.setOnClickListener {
            if(et_email.text.isNullOrBlank() || et_password.text.isNullOrBlank()){
                Toast.makeText(this, "아이디와 비밀번호를 확인하세요", Toast.LENGTH_SHORT).show()
            }else{
                val login_u_id = et_email.text.toString()
                val login_u_pw = et_password.text.toString()

                postLoginResponse(login_u_id, login_u_pw)

                val intent = Intent(this,MainActivity::class.java)
                startActivity(intent)
            }
        }

        fl_register.setOnClickListener {
            val intent = Intent(this,RegisterActivity::class.java)
            startActivityForResult(intent, REQUEST_CODE)
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                val email = data!!.getStringExtra("email")
                val pw = data!!.getStringExtra("password")
                et_email.setText(email)
                et_password.setText(pw)
            }
        }
    }

    fun postLoginResponse(u_id: String, u_pw: String) {
        SharedPreferenceController.setUserID(this, u_id)
        finish()
    }
}