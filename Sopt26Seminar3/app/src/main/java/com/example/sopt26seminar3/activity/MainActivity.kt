package com.example.sopt26seminar3.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import com.example.sopt26seminar3.R
import com.example.sopt26seminar3.SharedPreferenceController
import com.example.sopt26seminar3.adapter.MainPagerAdapter
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

        main_viewPager.adapter = MainPagerAdapter(supportFragmentManager)
        main_viewPager.offscreenPageLimit = 2
        main_viewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {
            }

            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
            }

            override fun onPageSelected(position: Int) {
                //네비게이션 메뉴 아이템 체크
                main_bottom_navigation.menu.getItem(position).isChecked = true
            }

        })


        main_bottom_navigation.setOnNavigationItemReselectedListener {
            when (it.itemId) {
                R.id.menu_home -> main_viewPager.currentItem = 0
                R.id.menu_book -> main_viewPager.currentItem = 1
                R.id.menu_person -> main_viewPager.currentItem = 2
            }
            true
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
