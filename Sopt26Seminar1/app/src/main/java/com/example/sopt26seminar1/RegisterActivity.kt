package com.example.sopt26seminar1

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        btn_register.setOnClickListener {
            if(et_email_register.text.isNullOrBlank() || et_password_register.text.isNullOrBlank() || et_password2.text.isNullOrBlank() || et_nickname.text.isNullOrBlank()){
                Toast.makeText(this, "모두 입력해주세요", Toast.LENGTH_SHORT).show()
            }else {
                val intent = Intent(this,LoginActivity::class.java)
                intent.putExtra("email", et_email_register.text.toString())
                intent.putExtra("password", et_password_register.text.toString())
                setResult(RESULT_OK, intent)

                val login_u_id = et_email_register.text.toString()
                val login_u_pw = et_password_register.text.toString()

                postLoginResponse(login_u_id, login_u_pw)

                finish()
            }
        }
    }

    fun postLoginResponse(u_id: String, u_pw: String) {
        SharedPreferenceController.setUserID(this, u_id)
        finish()
    }
}