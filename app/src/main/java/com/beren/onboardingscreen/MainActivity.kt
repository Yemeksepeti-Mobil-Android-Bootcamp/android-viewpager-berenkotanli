package com.beren.onboardingscreen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.viewpager.widget.ViewPager
import com.beren.onboardingscreen.adapter.ViewPagerAdapter
import com.beren.onboardingscreen.model.OnBoardingData
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {

    var viewPagerAdapter:ViewPagerAdapter?=null
    var tabLayout:TabLayout?=null
    var viewPager: ViewPager?=null
    var textViewNext: Button?=null
    var position=0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tabLayout=findViewById(R.id.idTabLayout)
        textViewNext=findViewById(R.id.textViewNext)

        val onBoardingData: MutableList<OnBoardingData> = ArrayList()
        onBoardingData.add(OnBoardingData("Best Choice For Everyone",R.drawable.image1,"Master Study is the"))
        onBoardingData.add(OnBoardingData("Teacher and Learners",R.drawable.image2,"Growth Mindset for"))
        onBoardingData.add(OnBoardingData("Anywhere",R.drawable.image3,"Learn Anytime"))

        setViewPagerAdapter(onBoardingData)
        position=viewPager!!.currentItem
        textViewNext?.setOnClickListener {
            if (position< onBoardingData.size){
                position++
                viewPager!!.currentItem=position
            }

        }
        tabLayout!!.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
                position=tab!!.position
                if (tab.position==onBoardingData.size-1){
                    textViewNext!!.text="Get Started"
                }else{
                    textViewNext!!.text="Next"
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
            }

        })

    }
    private fun setViewPagerAdapter(onBoardingData: List<OnBoardingData>){
        viewPager=findViewById(R.id.viewPagerScreen)
        viewPagerAdapter= ViewPagerAdapter(this,onBoardingData)
        viewPager!!.adapter=viewPagerAdapter
        tabLayout?.setupWithViewPager(viewPager)
    }
}