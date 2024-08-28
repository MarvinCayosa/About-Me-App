package com.example.myintro

import CarouselAdapter
import FadeSlideAnim
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.*
import java.lang.Math.abs

private lateinit var fadeSlide: FadeSlideAnim
private lateinit var fullScreenHelper: FullScreen
class MoviesPage : AppCompatActivity() {

    private val images = listOf(
        R.drawable.jojo,
        R.drawable.brc,
        R.drawable.meearl,
        R.drawable.sing,
        R.drawable.notting,
        R.drawable.mitch,
        R.drawable.mills,
        R.drawable.matrix,
        R.drawable.thing,
        R.drawable.kill
    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        fadeSlide = FadeSlideAnim(this)
        fullScreenHelper = FullScreen(this)
        fullScreenHelper.enterFullScreen()
        setContentView(R.layout.activity_movies_page)

        val viewPager = findViewById<ViewPager2>(R.id.view_pager)

        viewPager.apply {
            clipChildren = false  // No clipping the left and right items
            clipToPadding = false  // Show the viewpager in full width without clipping the padding
            offscreenPageLimit = 3  // Render the left and right items
            (getChildAt(0) as RecyclerView).overScrollMode =
                RecyclerView.OVER_SCROLL_NEVER // Remove the scroll effect
        }


        viewPager.adapter = CarouselAdapter(images)

        val compositePageTransformer = CompositePageTransformer()
        compositePageTransformer.addTransformer(MarginPageTransformer(resources.getDimensionPixelOffset(R.dimen.page_margin)))
        compositePageTransformer.addTransformer { page: View, position: Float ->
            val r = 1 - abs(position)
            page.scaleY = (0.80f + r * 0.20f)
        }

        viewPager.setPageTransformer(compositePageTransformer)



        // Animations

        fadeSlide.applyAnimation(findViewById(R.id.img_txt_header), R.anim.fade_in, R.anim.slide_up, 0)
        fadeSlide.applyAnimation(findViewById(R.id.img_mov1), R.anim.fade_in, R.anim.slide_up, 100)
        fadeSlide.applyAnimation(findViewById(R.id.img_mov2), R.anim.fade_in, R.anim.slide_up, 200)
        fadeSlide.applyAnimation(findViewById(R.id.img_mov3), R.anim.fade_in, R.anim.slide_up, 300)
        fadeSlide.applyAnimation(findViewById(R.id.img_mov4), R.anim.fade_in, R.anim.slide_up, 400)
        fadeSlide.applyAnimation(findViewById(R.id.img_mov5), R.anim.fade_in, R.anim.slide_up, 500)
        fadeSlide.applyAnimation(findViewById(R.id.img_txt_personal), R.anim.fade_in, R.anim.slide_up, 600)
        fadeSlide.applyAnimation(findViewById(R.id.view_pager), R.anim.fade_in, R.anim.slide_up, 600)
    }
}

