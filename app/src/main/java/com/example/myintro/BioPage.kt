package com.example.myintro

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import FadeSlideAnim


private lateinit var fullScreenHelper: FullScreen
private lateinit var fadeSlide: FadeSlideAnim
class BioPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        fullScreenHelper = FullScreen(this)
        fullScreenHelper.enterFullScreen()
        fadeSlide = FadeSlideAnim(this)

        setContentView(R.layout.activity_bio_page)



        // Animations
        fadeSlide.applyAnimation(findViewById(R.id.img_baby_pic1), R.anim.fade_in, R.anim.slide_up, 0)
        fadeSlide.applyAnimation(findViewById(R.id.img_baby_pic2), R.anim.fade_in, R.anim.slide_up, 50)
        fadeSlide.applyAnimation(findViewById(R.id.txt_hobbies), R.anim.fade_in, R.anim.slide_up, 100)
        fadeSlide.applyAnimation(findViewById(R.id.txt_sub_hobbies), R.anim.fade_in, R.anim.slide_up, 100)
        fadeSlide.applyAnimation(findViewById(R.id.img_guitar1), R.anim.fade_in, R.anim.slide_up, 150)
        fadeSlide.applyAnimation(findViewById(R.id.img_guitar2), R.anim.fade_in, R.anim.slide_up, 200)
        fadeSlide.applyAnimation(findViewById(R.id.img_guitar3), R.anim.fade_in, R.anim.slide_up, 250)
        fadeSlide.applyAnimation(findViewById(R.id.img_guitar4), R.anim.fade_in, R.anim.slide_up, 300)
        fadeSlide.applyAnimation(findViewById(R.id.txt_family), R.anim.fade_in, R.anim.slide_up, 350)
        fadeSlide.applyAnimation(findViewById(R.id.txt_sub_fam), R.anim.fade_in, R.anim.slide_up, 350)
        fadeSlide.applyAnimation(findViewById(R.id.img_mama), R.anim.fade_in, R.anim.slide_up, 400)
        fadeSlide.applyAnimation(findViewById(R.id.img_papa), R.anim.fade_in, R.anim.slide_up, 450)
        fadeSlide.applyAnimation(findViewById(R.id.img_kat), R.anim.fade_in, R.anim.slide_up, 500)
        fadeSlide.applyAnimation(findViewById(R.id.img_char), R.anim.fade_in, R.anim.slide_up, 550)
        fadeSlide.applyAnimation(findViewById(R.id.school), R.anim.fade_in, R.anim.slide_up, 550)
    }
}