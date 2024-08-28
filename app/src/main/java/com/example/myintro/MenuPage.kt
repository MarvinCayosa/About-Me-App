package com.example.myintro

import FadeSlideAnim
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity


class MenuPage : AppCompatActivity() {
    private lateinit var fullScreenHelper: FullScreen
    private lateinit var fadeSlide: FadeSlideAnim

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        fullScreenHelper = FullScreen(this)
        fullScreenHelper.enterFullScreen()

        fadeSlide = FadeSlideAnim(this)

        overridePendingTransition(R.anim.slide_left_animation, R.anim.no_animation)
        setContentView(R.layout.activity_menupage)

        fadeSlide.applyAnimation(findViewById(R.id.btn_to_bio), R.anim.fade_in, R.anim.slide_up, 0)
        fadeSlide.applyAnimation(findViewById(R.id.btn_to_music), R.anim.fade_in, R.anim.slide_up, 100)
        fadeSlide.applyAnimation(findViewById(R.id.btn_to_movies), R.anim.fade_in, R.anim.slide_up, 200)
        fadeSlide.applyAnimation(findViewById(R.id.btn_to_other), R.anim.fade_in, R.anim.slide_up, 300)

        val buttonToMusicPage = findViewById<ImageButton>(R.id.btn_to_music)
        buttonToMusicPage.setOnClickListener {
            val intent = Intent(this, MusicPage::class.java)
            startActivity(intent)
        }

        val buttonToBioPage = findViewById<ImageButton>(R.id.btn_to_bio)
        buttonToBioPage.setOnClickListener {
            val intent = Intent(this, BioPage::class.java)
            startActivity(intent)
        }

        val buttonToMoviesPage = findViewById<ImageButton>(R.id.btn_to_movies)
        buttonToMoviesPage.setOnClickListener {
            val intent = Intent(this, MoviesPage::class.java)
            startActivity(intent)
        }

        val buttonToOthersPage = findViewById<ImageButton>(R.id.btn_to_other)
        buttonToOthersPage.setOnClickListener {
            val intent = Intent(this, OtherPage::class.java)
            startActivity(intent)
        }

    }
    companion object {
        fun getIntent(context: Context): Intent {
            return Intent(context, MenuPage::class.java)
        }
    }
}




