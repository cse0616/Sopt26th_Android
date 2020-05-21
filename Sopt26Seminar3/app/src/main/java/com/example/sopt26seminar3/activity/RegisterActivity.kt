package com.example.sopt26seminar3.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.sopt26seminar3.R
import com.example.sopt26seminar3.data.RequestRegister
import com.example.sopt26seminar3.data.ResponseRegister
import com.example.sopt26seminar3.network.RequestToServer
import com.example.sopt26seminar3.SharedPreferenceController
import kotlinx.android.synthetic.main.activity_register.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegisterActivity : AppCompatActivity() {

    val requestToServer = RequestToServer //싱글톤 그대로 가져옴

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        btn_register.setOnClickListener {
            if(et_email_register.text.isNullOrBlank() || et_password_register.text.isNullOrBlank() || et_name_register.text.isNullOrBlank() || et_email_register.text.isNullOrBlank() || et_phone_register.text.isNullOrBlank()){
                Toast.makeText(this, "모두 입력해주세요", Toast.LENGTH_SHORT).show()
            }else {
                requestToServer.service.requestRegister(
                    RequestRegister(
                        id = et_id_register.text.toString(),
                        password = et_password_register.text.toString(),
                        name = et_name_register.text.toString(),
                        email = et_email_register.text.toString(),
                        phone = et_phone_register.text.toString()
                    )
                ).enqueue(object :Callback<ResponseRegister>{
                    override fun onFailure(call: Call<ResponseRegister>, t: Throwable) {
                        Toast.makeText(this@RegisterActivity, "통신 실패!", Toast.LENGTH_SHORT).show()
                    }

                    override fun onResponse(call: Call<ResponseRegister>, response: Response<ResponseRegister>) {
                        if(response.isSuccessful){
                            if(response.body()!!.status == 200) {
                                Toast.makeText(this@RegisterActivity, "존재하는 ID 입니다.", Toast.LENGTH_SHORT).show()
                            }
                            else if(response.body()!!.success){
                                Toast.makeText(this@RegisterActivity, "회원가입 성공", Toast.LENGTH_SHORT).show()
                                val intent = Intent(this@RegisterActivity,LoginActivity::class.java)
                                intent.putExtra("id", et_id_register.text.toString())
                                intent.putExtra("password", et_password_register.text.toString())
                                setResult(RESULT_OK, intent)

                                val register_u_id = et_email_register.text.toString()
                                val register_u_pw = et_password_register.text.toString()

                                postLoginResponse(register_u_id, register_u_pw)

                                finish()
                            }else{
                                Toast.makeText(this@RegisterActivity, "회원가입 실패", Toast.LENGTH_SHORT).show()
                            }
                        }
                    }

                })
            }
        }
    }

    fun postLoginResponse(u_id: String, u_pw: String) {
        SharedPreferenceController.setUserID(this, u_id)
        finish()
    }
}