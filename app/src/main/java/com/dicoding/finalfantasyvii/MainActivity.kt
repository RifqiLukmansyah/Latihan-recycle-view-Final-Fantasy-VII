package com.dicoding.finalfantasyvii

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var rvHeroes: RecyclerView
    private val list = ArrayList<Character>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)





        setContentView(R.layout.activity_main)
        rvHeroes = findViewById(R.id.rv_heroes)
        rvHeroes.setHasFixedSize(true)
        list.addAll(listHeroes)
        showRecyclerList()
    }

    private val listHeroes: ArrayList<Character>
        get() {
            val dataName = resources.getStringArray(R.array.data_name)
            val dataAge = resources.getStringArray(R.array.data_age)
            val dataOccupation = resources.getStringArray(R.array.data_occupation)
            val dataPhoto = resources.getStringArray(R.array.data_photo)
            val dataDescription = resources.getStringArray(R.array.data_description)
            val dataHome = resources.getStringArray(R.array.data_home)
            val dataAffiliation = resources.getStringArray(R.array.data_affiliation)
            val dataRace = resources.getStringArray(R.array.data_race)
            val dataGender = resources.getStringArray(R.array.data_gender)
            val dataHeight = resources.getStringArray(R.array.data_height)
            val dataHairColor = resources.getStringArray(R.array.data_hair_color)
            val dataEyeColor = resources.getStringArray(R.array.data_eye_color)
            val dataBloodType = resources.getStringArray(R.array.data_blood_type)
            val dataWeapon = resources.getStringArray(R.array.data_weapon)
            val listHero = ArrayList<Character>()
            for (i in dataName.indices) {
                val hero = Character(dataName[i], dataAge[i], dataOccupation[i], dataPhoto[i], dataDescription[i], dataHome[i], dataAffiliation[i], dataRace[i], dataGender[i],dataHeight[i], dataHairColor[i],dataEyeColor[i],dataBloodType[i],dataWeapon[i])
                listHero.add(hero)
            }
            return listHero
        }
    private fun showRecyclerList() {
        rvHeroes.layoutManager = LinearLayoutManager(this)
        val listHeroAdapter = ListHeroAdapter(list)
        rvHeroes.adapter = listHeroAdapter

        listHeroAdapter.setOnItemClickCallback(object : ListHeroAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Character) {
                val detailCharActivityIntent = Intent(this@MainActivity, DetailActivity::class.java)
                detailCharActivityIntent.putExtra("key_character",data)
                startActivity(detailCharActivityIntent) // Corrected spelling
                showSelectedHero(data)
            }
        })
    }
    private fun showSelectedHero(hero: Character) {
        Toast.makeText(this, "Kamu memilih " + hero.name, Toast.LENGTH_SHORT).show()

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_list -> {
                rvHeroes.layoutManager = LinearLayoutManager(this)
            }
            R.id.action_grid -> {
                rvHeroes.layoutManager = GridLayoutManager(this, 2)
            }
            R.id.action_about -> {
                val goAbout = Intent(this@MainActivity, AboutActivity::class.java)
                startActivity(goAbout)
            }
        }
        return super.onOptionsItemSelected(item)
    }


}