package com.example.sopt26seminar2_webtoon

import android.content.Context
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.RelativeLayout
import androidx.viewpager.widget.ViewPager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        main_viewPager.adapter = MainPagerAdapter(supportFragmentManager)
        main_viewPager.offscreenPageLimit = 8
        main_top_navigation.setupWithViewPager(main_viewPager)  //tablayout과 viewpager를 연결
        main_top_navigation.setTabTextColors(Color.parseColor("#484848"), Color.parseColor("#ffffff"))

        /*main_viewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener{
            override fun onPageScrollStateChanged(state: Int) {
            }

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
            }

            override fun onPageSelected(position: Int) {
                main_bottom_navigation.menu.getItem(position).isChecked = true
            }

        })

        main_bottom_navigation.setOnNavigationItemReselectedListener {
            when(it.itemId){
                R.id.menu_webtoon -> main_viewPager.currentItem = 0
                R.id.menu_recommend -> main_viewPager.currentItem = 1
                R.id.menu_best -> main_viewPager.currentItem = 2
                R.id.menu_my -> main_viewPager.currentItem = 3
                R.id.menu_more -> main_viewPager.currentItem = 4
            }
            true
        }*/

        val navCategoryMainLayout: View = (this.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater)
            .inflate(R.layout.top_navigation, null, false)
        main_top_navigation.getTabAt(0)!!.customView = navCategoryMainLayout.findViewById(R.id.rl_main_new) as RelativeLayout
        main_top_navigation.getTabAt(1)!!.customView = navCategoryMainLayout.findViewById(R.id.rl_main_mon) as RelativeLayout
        main_top_navigation.getTabAt(2)!!.customView = navCategoryMainLayout.findViewById(R.id.rl_main_tue) as RelativeLayout
        main_top_navigation.getTabAt(3)!!.customView = navCategoryMainLayout.findViewById(R.id.rl_main_wed) as RelativeLayout
        main_top_navigation.getTabAt(4)!!.customView = navCategoryMainLayout.findViewById(R.id.rl_main_thur) as RelativeLayout
        main_top_navigation.getTabAt(5)!!.customView = navCategoryMainLayout.findViewById(R.id.rl_main_fri) as RelativeLayout
        main_top_navigation.getTabAt(6)!!.customView = navCategoryMainLayout.findViewById(R.id.rl_main_sat) as RelativeLayout
        main_top_navigation.getTabAt(7)!!.customView = navCategoryMainLayout.findViewById(R.id.rl_main_sun) as RelativeLayout
        main_top_navigation.getTabAt(8)!!.customView = navCategoryMainLayout.findViewById(R.id.rl_main_fin) as RelativeLayout

    }
}
