package com.example.sopt26seminar1


import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_login.*
import com.example.sopt26seminar1.data.RequestLogin
import com.example.sopt26seminar1.data.ResponseLogin
import com.example.sopt26seminar1.network.RequestToServer
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class LoginActivity : AppCompatActivity() {

    val requestToServer = RequestToServer //싱글톤 그대로 가져옴

    private val REQUEST_CODE = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        btn_login.setOnClickListener {
            if(et_id_login.text.isNullOrBlank() || et_password_login.text.isNullOrBlank()){
                Toast.makeText(this, "아이디와 비밀번호를 확인하세요", Toast.LENGTH_SHORT).show()
            }else{
                requestToServer.service.requestLogin(
                        RequestLogin(
                            id = et_id_login.text.toString(),
                            password = et_password_login.text.toString()
                        )//로그인 정보를 전달
                ).enqueue(object :Callback<ResponseLogin>{//Callback등록. Retrofit의 Callback을 import 해줘야 함!
                    override fun onFailure(call: Call<ResponseLogin>, t: Throwable) {
                        //통신 실패
                        Toast.makeText(this@LoginActivity, "통신 실패!", Toast.LENGTH_SHORT).show()
                    }

                    override fun onResponse(call: Call<ResponseLogin>, response: Response<ResponseLogin>) {
                        //통신 성공
                        if(response.isSuccessful) {//statusCode가 200~300 사이일때. 응답 body 이용 가능
                            if(response.body()!!.success){//ResponseLogin의 success가 true인 경우 -> 로그인
                                Toast.makeText(this@LoginActivity, "로그인 성공", Toast.LENGTH_SHORT).show()
                                val intent = Intent(this@LoginActivity,MainActivity::class.java)
                                startActivity(intent)
                                val login_u_id = et_id_login.text.toString()
                                val login_u_pw = et_password_login.text.toString()

                                postLoginResponse(login_u_id, login_u_pw)
                                finish()
                            }else{
                                Toast.makeText(this@LoginActivity, "아이디/비밀번호를 확인하세요!", Toast.LENGTH_SHORT).show()
                            }
                        }
                    }

                })
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
                val id = data!!.getStringExtra("id")
                val pw = data!!.getStringExtra("password")
                et_id_login.setText(id)
                et_password_login.setText(pw)

                if(SharedPreferenceController.getUserID(this).isEmpty()){
                    Toast.makeText(this, "로그인을 해주세요", Toast.LENGTH_SHORT).show()
                }
                else{
                    Toast.makeText(this, "자동 로그인 합니다", Toast.LENGTH_SHORT).show()
                    val delayHandler = Handler()
                    delayHandler.postDelayed(Runnable {
                        val intent = Intent(this, MainActivity::class.java)
                        startActivity(intent)
                        finish()
                    }, 2000)
                }
            }
        }
    }

    fun postLoginResponse(u_id: String, u_pw: String) {
        SharedPreferenceController.setUserID(this, u_id)
        finish()
    }
}