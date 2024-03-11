package com.dicoding.finalfantasyvii

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bumptech.glide.Glide

class DetailActivity : AppCompatActivity() {

    companion object{
        const val  KEY_CHAR = "key_character"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val dataCharacter = intent.getParcelableExtra<Character>(KEY_CHAR)!!
        val tvname: TextView = findViewById(R.id.tv_detail_name)
        val tvage: TextView = findViewById(R.id.tv_detail_age)
        val tvoccupation: TextView = findViewById(R.id.tv_detail_occupation)
        val tvphoto: ImageView = findViewById(R.id.iv_detail_photo)
        val tvdescription : TextView = findViewById(R.id.tv_detail_description)
        val tvhome : TextView = findViewById(R.id.tv_detail_home)
        val tvaffiliation : TextView = findViewById(R.id.tv_detail_affiliation)
        val tvrace: TextView = findViewById(R.id.tv_detail_race)
        val tvgender: TextView = findViewById(R.id.tv_detail_gender)
        val tvheight : TextView = findViewById(R.id.tv_detail_height)
        val tvhair_color : TextView = findViewById(R.id.tv_detail_haircolor)
        val tveye_color : TextView = findViewById(R.id.tv_detail_eyecolor)
        val tvblood_type : TextView = findViewById(R.id.tv_detail_bloodtype)
        val tvweapon : TextView = findViewById(R.id.tv_detail_weapon)

        tvname.text = dataCharacter.name
        tvage.text = dataCharacter.age
        tvoccupation.text = dataCharacter.occupation
        Glide.with(this)
            .load(dataCharacter.photo) // The URL string
            .into(tvphoto)
        tvdescription.text = dataCharacter.description
        tvhome.text = dataCharacter.home
        tvaffiliation.text = dataCharacter.affiliation
        tvrace.text = dataCharacter.race
        tvgender.text = dataCharacter.gender
        tvheight.text = dataCharacter.height
        tvhair_color.text = dataCharacter.hair_color
        tveye_color.text = dataCharacter.eye_color
        tvblood_type.text = dataCharacter.blood_type
        tvweapon.text = dataCharacter.weapon




    }

    @Suppress("DEPRECATION")
    fun onShareClicked(view: View) {

        val dataChar = intent.getParcelableExtra<Character>(KEY_CHAR)!!
        val shareIntent = Intent(Intent.ACTION_SEND).apply {
            type = "text/plain"
            putExtra(
                Intent.EXTRA_TEXT,
                "Name: ${dataChar.name} \nAge: ${dataChar.age} \nOccupation: ${dataChar.occupation}"
            )
        }
        startActivity(Intent.createChooser(shareIntent, "Send to"))

    }

    @Suppress("DEPRECATION")
    fun onBackPressed(view: View) {
        onBackPressed()
    }
}