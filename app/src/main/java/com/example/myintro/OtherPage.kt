package com.example.myintro

import FadeSlideAnim
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

private lateinit var fullScreenHelper: FullScreen
private lateinit var fadeSlide: FadeSlideAnim

class OtherPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        fullScreenHelper = FullScreen(this)
        fullScreenHelper.enterFullScreen()
        fadeSlide = FadeSlideAnim(this)

        setContentView(R.layout.activity_other_page)



        val buttonToFb = findViewById<ImageButton>(R.id.fb)
        buttonToFb.setOnClickListener(){
            val fbLink = "https://www.facebook.com/marbeyn.11?mibextid=ZbWKwL"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(fbLink))
            startActivity(intent)
        }

        val buttonToTk = findViewById<ImageButton>(R.id.tk)
        buttonToTk.setOnClickListener(){
            val tkLink = "https://www.tiktok.com/@marvin_cayosa?_t=8gcUHrWCesE&_r=1"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(tkLink))
            startActivity(intent)
        }

        val buttonToIg = findViewById<ImageButton>(R.id.ig)
        buttonToIg.setOnClickListener(){
            val igLink = "https://www.instagram.com/marvin_cayosa/"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(igLink))
            startActivity(intent)
        }



        fadeSlide.applyAnimation(findViewById(R.id.img_other_header), R.anim.fade_in, R.anim.slide_up, 0)
        fadeSlide.applyAnimation(findViewById(R.id.fb), R.anim.fade_in, R.anim.slide_up, 150)
        fadeSlide.applyAnimation(findViewById(R.id.ig), R.anim.fade_in, R.anim.slide_up, 300)
        fadeSlide.applyAnimation(findViewById(R.id.tk), R.anim.fade_in, R.anim.slide_up, 450)
        fadeSlide.applyAnimation(findViewById(R.id.img_tag), R.anim.fade_in, R.anim.slide_up, 600)
    }
}