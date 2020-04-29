# Sopt26th_Android

### 1차 세미나

#### [기본 과제1]
------------
ConstraintDimensionRatio 심화 학습
- ConstraintDimensionRatio 이용해서 이미지를 1:1 비율로 만들기
- Guideline 이용해보기
<img src="https://user-images.githubusercontent.com/51014789/80585582-93cd2a00-8a4e-11ea-9f52-7c7172059ba9.PNG" width="30%">

- Ratio<br>
위젯 크기는 수평:수직의 비율로 정할 수도 있다. 비율로 크기를 정하려면, width나 height를 0dp (or math_constraint)로 지정하고 layout_constaintDimensionRatio 속성을 이용해 수평:수직 비율값을 준다.
```kotlin
<ImageView
            android:layout_width="wrap_content"
            android:layout_height="0dp"
            app:srcCompat="@drawable/chicken_img"
            app:layout_constraintDimensionRatio="1:1"
```
            
            
- Guideline
```kotlin
<androidx.constraintlayout.widget.Guideline
        android:id="@+id/guideline"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:orientation="vertical"
        app:layout_constraintGuide_percent="0.8"/>
```

<br><br>

#### [기본 과제2]
------------
회원가입 및 로그인 기능 구현하기
- 회원가입 완료시 LoginActivity로 돌아오고, 회원가입 성공한 id와 pw가 입력되어 있도록 구현
<div>
<img src="https://user-images.githubusercontent.com/51014789/80586544-11de0080-8a50-11ea-98ee-65e8818ba109.PNG" width="23%">
<img src="https://user-images.githubusercontent.com/51014789/80586549-14405a80-8a50-11ea-844b-0d9f7e3824fc.PNG" width="23%">
<img src="https://user-images.githubusercontent.com/51014789/80586555-15718780-8a50-11ea-902b-8932187a7fb0.PNG" width="23%">
<img src="https://user-images.githubusercontent.com/51014789/80586557-16a2b480-8a50-11ea-959f-f901351bf4f6.PNG" width="23%">
</div>
<br>회원가입 완료시 LoginActivity에 id와 pw가 입력되어 있다
<br>
##### startActivityForResult()로 Activity 호출하기
기존에 startActivity()로 호출하던 것을 startActivityForResult()로 호출을 하면서 인수를 하나 추가한다. 이 인수는 0보다 크거나 같은 integer 값으로 추후 onActivityResult() 메소드에도 동일한 값이 전달되며 이를 통해 하나의 onActivityResult() 메소드에서 여러 개의 startActivityForResult()를 구분할 수 있다.
```kotlin
startActivityForResult(intent, REQUEST_CODE)
```
##### 호출된 액티비티에서 setResult()로 결과 돌려주기
호출된 액티비티에서 setResult() 메소드로 결과를 저장할 수 있다. 성공인 경우는 RESULT_OK로 실패라면 RESULT_CANCEL을 설정할 수 있다. (Activity의 멤버 변수) 이후 finish() 메소드로 액티비티 종료
```kotlin
val intent = Intent(this,LoginActivity::class.java)
intent.putExtra("email", et_email_register.text.toString())
intent.putExtra("password", et_password_register.text.toString())
setResult(RESULT_OK, intent)
finish()
```
##### onActivityResult()에서 결과 확인하기	
안드로이드에서는 onActivityResult() 메소드를 통해 호출된 액티비티에서 저장한 결과를 돌려준다. 이 때 requestCode는 처음 startActivityResult()의 두번째 인수 값이며, resultCode는 호출된 액티비티에서 설정한 성공/실패 값이다. 이를 통해 어떤 호출이었는지와 결과가 어떠한지를 알 수 있다. 세 번쨰 인수 intent는 호출된 액티비티에서 저장한 결과이다.
```kotlin
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
```
<br>

#### [성장 과제2]
------------
자동 로그인 구현하기
- 회원가입시 LoginActivity로 돌아와 가입한 id,pw로 자동 로그인 하기
- 로그인 하여 MainActivity로 간 경우 앱을 종료했다가 다시 켜면 LoginActivity에서 자동 로그인 하기
<img src="https://user-images.githubusercontent.com/51014789/80587156-05a67300-8a51-11ea-9f7d-69dbc0323276.png" width="30%">
로그아웃 버튼을 누르지 않는 한 앱을 종료했다가 다시 켜면 자동 로그인 toast 메시지와 함께 자동 로그인이 되고 MainActivity로 넘어간다


SharedPreferences.kt
```kotlin
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
```
위와 같은 내부 db를 이용하여 SharedPreferenceController의 getUserID가 비어있으면 로그인 액티비티를 호출하고 저장되어 있는 정보가 있을 경우 바로 로그인 다음 액티비티를 호출했다.

<br><br>

### 2차 세미나

#### [기본 과제 1]
------------
Bottom Navigation, ViewPager, RecyclerView 실습
<div>
<img src="https://user-images.githubusercontent.com/51014789/80582994-975eb200-8a4a-11ea-8255-d4629adf60ae.PNG" width="25%">
<img src="https://user-images.githubusercontent.com/51014789/80583024-a180b080-8a4a-11ea-9338-dae654186c78.PNG" width="25%">
<img src="https://user-images.githubusercontent.com/51014789/80583031-a3e30a80-8a4a-11ea-9bd1-5ab7f2f2d3ae.PNG" width="25%">
</div>
