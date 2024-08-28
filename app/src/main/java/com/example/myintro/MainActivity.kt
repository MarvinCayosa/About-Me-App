package com.example.myintro

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

private lateinit var fullScreenHelper: FullScreen
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        fullScreenHelper = FullScreen(this)
        fullScreenHelper.enterFullScreen()

        setContentView(R.layout.activity_main)
        val helloTextView = findViewById<TextView>(R.id.helloTextView)
        val fadeInAnimation = AlphaAnimation(0f, 1f).apply {
            duration = 1000 // Adjust the duration as needed (in milliseconds)
            setAnimationListener(object : Animation.AnimationListener {
                override fun onAnimationStart(animation: Animation?) {}

                override fun onAnimationEnd(animation: Animation?) {}

                override fun onAnimationRepeat(animation: Animation?) {}
            })
        }
            helloTextView.startAnimation(fadeInAnimation)

        val tapScreen = findViewById<LinearLayout>(R.id.main1)
        tapScreen.setOnClickListener {
            // Start the fade-out animation
            val fadeOutAnimation = AlphaAnimation(1f, 0f).apply {
                duration = 500 // Adjust the duration as needed (in milliseconds)
                setAnimationListener(object : Animation.AnimationListener {
                    override fun onAnimationStart(animation: Animation?) {
                        // Set the text view to be invisible at the start of the animation
                        helloTextView.visibility = View.INVISIBLE
                    }

                    override fun onAnimationEnd(animation: Animation?) {
                        helloTextView.visibility = View.GONE

                        // Navigate to Page2 after the animation ends
                        val intent = Intent(this@MainActivity, MainActivity2::class.java)
                        startActivity(intent)
                        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
                    }
                    override fun onAnimationRepeat(animation: Animation?) {}
                })
            }
            helloTextView.startAnimation(fadeOutAnimation)
        }

    }
}
