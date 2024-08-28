package com.example.myintro

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.*
import android.widget.*
import FadeSlideAnim
import android.view.animation.AnimationUtils


private lateinit var fadeSlide: FadeSlideAnim
private lateinit var fullScreenHelper: FullScreen
class MusicPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        fullScreenHelper = FullScreen(this)
        fullScreenHelper.enterFullScreen()

        fadeSlide = FadeSlideAnim(this)


        setContentView(R.layout.activity_music_page)

        // Animations
        val txtHeader = findViewById<TextView>(R.id.txt_music_header)
        val txtSub = findViewById<TextView>(R.id.txt_music_desc)
        val txtTop = findViewById<TextView>(R.id.txt_top4)
        val fadeIn = AnimationUtils.loadAnimation(this, R.anim.fade_in2)
        txtHeader.startAnimation(fadeIn)
        txtSub.startAnimation(fadeIn)
        txtTop.startAnimation(fadeIn)

        fadeSlide.applyAnimation(findViewById(R.id.img_top1), R.anim.fade_in, R.anim.slide_up, 0)
        fadeSlide.applyAnimation(findViewById(R.id.img_top2), R.anim.fade_in, R.anim.slide_up, 200)
        fadeSlide.applyAnimation(findViewById(R.id.img_top3), R.anim.fade_in, R.anim.slide_up, 400)
        fadeSlide.applyAnimation(findViewById(R.id.img_top4), R.anim.fade_in, R.anim.slide_up, 600)
        fadeSlide.applyAnimation(findViewById(R.id.img_top5), R.anim.fade_in, R.anim.slide_up, 800)
        fadeSlide.applyAnimation(findViewById(R.id.img_top6), R.anim.fade_in, R.anim.slide_up, 1000)

        // To Spotify Profile
        val followBtn = findViewById<ImageButton>(R.id.btn_to_profile)
        followBtn.setOnClickListener(){
            val spotifyURL = "https://open.spotify.com/user/317wvawrrsjfr2chxox4ip3cunvu?si=02f6d942237247b2"
            val i = Intent(Intent.ACTION_VIEW, Uri.parse(spotifyURL))
            startActivity(i)

        }

        val playlist1: WebView = findViewById(R.id.web_playlist1)
        playlist1.settings.javaScriptEnabled = true
        playlist1.webChromeClient = WebChromeClient()
        playlist1.webViewClient = WebViewClient()

        val spotifyUrl1 = "https://open.spotify.com/embed/playlist/11n2qNTXkKymY0kJtwLWW5?utm_source=generator&theme=0"
        val html1 = "<iframe style=\"border-radius:12px\" src=\"$spotifyUrl1\" width=\"100%\" height=\"152\" frameBorder=\"0\" " +
                "allowfullscreen=\"\" allow=\"autoplay; clipboard-write; encrypted-media; fullscreen; picture-in-picture\" " +
                "loading=\"lazy\"></iframe>"
        // Load the HTML content into the WebView
        playlist1.loadData(html1, "text/html", "utf-8")

        val playlist2: WebView = findViewById(R.id.web_playlist2)
        playlist2.settings.javaScriptEnabled = true
        playlist2.webChromeClient = WebChromeClient()
        playlist2.webViewClient = WebViewClient()

        val spotifyUrl2 = "https://open.spotify.com/embed/playlist/4e7Vou1ZDtzZyxUdsHYBVx?utm_source=generator"
        val html2 = "<iframe style=\"border-radius:12px\" src=\"$spotifyUrl2\" width=\"100%\" " +
                "height=\"152\" frameBorder=\"0\" allowfullscreen=\"\" allow=\"autoplay; clipboard-write; " +
                "encrypted-media; fullscreen; picture-in-picture\" loading=\"lazy\"></iframe>"
        playlist2.loadData(html2, "text/html", "utf-8")


    }
}
