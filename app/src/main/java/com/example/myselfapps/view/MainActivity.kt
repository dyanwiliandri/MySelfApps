package com.example.myselfapps.view

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.example.myselfapps.R
import com.example.myselfapps.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

// 12/06/2025, 10122085, Dyan Wiliandri, IF-13
@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater )
        setContentView(binding.root)

        loadFragment(HomeFragment())

        binding.bottomNavigation.setOnItemSelectedListener{
            when(it.itemId){
                R.id.menu_home -> loadFragment(HomeFragment())
                R.id.menu_profile -> loadFragment(ProfileFragment())
                R.id.menu_multimedia -> loadFragment(MultimediaFragment())
                R.id.menu_gallery -> loadFragment(GalleryFragment())
                R.id.menu_daily -> loadFragment(DailyFragment())
            }
            true
        }
    }
    private fun loadFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }
}