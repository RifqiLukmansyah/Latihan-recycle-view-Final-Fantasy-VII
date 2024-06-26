package com.dicoding.finalfantasyvii

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class AboutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)
        val tvResource: TextView = findViewById(R.id.tv_resource)
        tvResource.setOnClickListener {
            val url = "https://finalfantasy.fandom.com/wiki/Final_Fantasy_VII_Rebirth"
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(url)
            startActivity(intent)
        }
    }
    fun onShareClicked(view: View) {
        val author = resources.getString(R.string.author)
        val email = resources.getString(R.string.email)
        val aboutApp = resources.getString(R.string.about_app_description)

        val shareIntent = Intent(Intent.ACTION_SEND).apply {
            type = "text/plain"
            putExtra(
                Intent.EXTRA_TEXT,
                "Author: $author \nEmail: $email \nAbout app: $aboutApp"
            )
        }
        startActivity(Intent.createChooser(shareIntent, "Send to"))

    }
    @Suppress("DEPRECATION")
    fun onBackPressed(view: View) {
        onBackPressed()
    }

}