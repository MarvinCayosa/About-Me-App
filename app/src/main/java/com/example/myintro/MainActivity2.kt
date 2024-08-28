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

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        fullScreenHelper = FullScreen(this)
        fullScreenHelper.enterFullScreen()


        setContentView(R.layout.activity_main2)

        val name = findViewById<TextView>(R.id.marvin_txt)
        val fadeInAnimation = AlphaAnimation(0f, 1f).apply {
            duration = 1000 // Adjust the duration as needed (in milliseconds)
            setAnimationListener(object : Animation.AnimationListener {
                override fun onAnimationStart(animation: Animation?) {}

                override fun onAnimationEnd(animation: Animation?) {}

                override fun onAnimationRepeat(animation: Animation?) {}
            })
        }
        name.startAnimation(fadeInAnimation)
        val tapScreen = findViewById<LinearLayout>(R.id.main2) // screen as a trigger
        tapScreen.setOnClickListener {
            // Start the fade-out animation
            val fadeOutAnimation = AlphaAnimation(1f, 0f).apply {
                duration = 500 // Adjust the duration as needed (in milliseconds)
                setAnimationListener(object : Animation.AnimationListener {
                    override fun onAnimationStart(animation: Animation?) {
                        // Set the text view to be invisible at the start of the animation
                        name.visibility = View.INVISIBLE
                    }
                    override fun onAnimationEnd(animation: Animation?) {
                        // Set the text view to be gone after the animation ends
                        name.visibility = View.GONE
                        val intent = Intent(this@MainActivity2, home::class.java)
                        startActivity(intent)
                        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
                    }
                    override fun onAnimationRepeat(animation: Animation?) {}
                })
            }

            name.startAnimation(fadeOutAnimation)
        }
    }
}

