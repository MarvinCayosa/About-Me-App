package com.example.myintro

import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import android.view.*
import android.view.animation.AccelerateDecelerateInterpolator
import android.view.animation.BounceInterpolator

class home : AppCompatActivity() {

    private lateinit var fullScreenHelper: FullScreen
    private lateinit var gestureDetector: GestureDetector
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        fullScreenHelper = FullScreen(this)
        fullScreenHelper.enterFullScreen()


        setContentView(R.layout.activity_home)

        gestureDetector = GestureDetector(this, SwipeGestureListener())


        val swipeText = findViewById<TextView>(R.id.txt_swipe)
        val animator = ValueAnimator.ofFloat(1f, -30f, 1f)
        animator.repeatCount = ValueAnimator.INFINITE
        animator.repeatMode = ValueAnimator.RESTART
        animator.duration = 1000
        animator.interpolator = AccelerateDecelerateInterpolator()
        animator.addUpdateListener { valueAnimator ->
            val value = valueAnimator.animatedValue as Float
            swipeText.translationY = value
        }
        animator.start()
        
    }
    override fun onTouchEvent(event: MotionEvent): Boolean {
        return gestureDetector.onTouchEvent(event) || super.onTouchEvent(event)
    }
    private inner class SwipeGestureListener : GestureDetector.SimpleOnGestureListener() {
        override fun onFling(
            e1: MotionEvent,
            e2: MotionEvent,
            velocityX: Float,
            velocityY: Float
        ): Boolean {
            if (e1.x - e2.x > SWIPE_THRESHOLD && kotlin.math.abs(velocityX) > SWIPE_VELOCITY_THRESHOLD) {
                // Swipe-up detected, navigate to the destination activity
                startActivity(MenuPage.getIntent(this@home))
                return true
            }
            return false
        }
    }
    companion object {
        private const val SWIPE_THRESHOLD = 100
        private const val SWIPE_VELOCITY_THRESHOLD = 100
    }


}
