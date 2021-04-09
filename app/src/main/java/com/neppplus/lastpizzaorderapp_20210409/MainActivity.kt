package com.neppplus.lastpizzaorderapp_20210409

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.neppplus.lastpizzaorderapp_20210409.adapters.MainViewPagerAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    lateinit var mViewPagerAdapter : MainViewPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupEvents()
        setValues()
    }

    override fun setupEvents() {

    }

    override fun setValues() {

        mViewPagerAdapter = MainViewPagerAdapter(supportFragmentManager)
        mainViewPager.adapter = mViewPagerAdapter

        mainTabLayout.setupWithViewPager(mainViewPager)

    }


}