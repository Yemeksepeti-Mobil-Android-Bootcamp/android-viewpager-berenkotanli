package com.beren.onboardingscreen.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.viewpager.widget.PagerAdapter
import com.beren.onboardingscreen.R
import com.beren.onboardingscreen.model.OnBoardingData

class ViewPagerAdapter(private var context: Context, private var onBoardingDataList:List<OnBoardingData>): PagerAdapter() {
    override fun getCount(): Int {
        return onBoardingDataList.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val view: View = LayoutInflater.from(context).inflate(R.layout.onboarding_layout,null)
        val imageView: ImageView
        val title:TextView
        val desc:TextView

        imageView=view.findViewById(R.id.imageViewOnboarding)
        title=view.findViewById(R.id.textViewOnboarding)
        desc=view.findViewById(R.id.textViewOnboarding2)


        imageView.setImageResource(onBoardingDataList[position].imageUrl)
        title.text=onBoardingDataList[position].title
        desc.text=onBoardingDataList[position].desc

        container.addView(view)
        return view
    }
}