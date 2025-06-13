package com.example.myselfapps.view

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import androidx.viewpager2.widget.ViewPager2
import com.example.myselfapps.R
import com.example.myselfapps.adapter.OnBoardingPagerAdapter
import com.example.myselfapps.databinding.ActivityOnBoardingBinding
import com.google.android.material.tabs.TabLayout
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class OnBoardingActivity : AppCompatActivity() {
    private lateinit var binding: ActivityOnBoardingBinding // Deklarasi binding
    private lateinit var datastoreManager: DataStoreManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOnBoardingBinding.inflate(layoutInflater) // Inisialisasi binding
        setContentView(binding.root) // Set root view dari binding

        datastoreManager = DataStoreManager(applicationContext)

        val onboardingItems = listOf(
            OnBoardingPagerAdapter.OnboardingItem(
                lottieRawResId = R.raw.anim_splash,
                title = "Welcome!",
                description = "Welcome to my app!",
                // Menggunakan Color.parseColor untuk hex string
                backgroundColor = Color.parseColor("#8fafa1")
            ),
            OnBoardingPagerAdapter.OnboardingItem(
                lottieRawResId = R.raw.beat,
                title = "About",
                description = "Learn More About ME",
                backgroundColor = Color.parseColor("#50545B")
            ),
            OnBoardingPagerAdapter.OnboardingItem(
                lottieRawResId = R.raw.surprise,
                title = "Lets Get Started!",
                // Karena hanya ada dua deskripsi yang diberikan, halaman ketiga tidak punya deskripsi.
                // Anda bisa tambahkan teks di sini jika mau.
                description = "", // Atau teks kosong jika memang tidak ada
                backgroundColor = Color.parseColor("#f0d8a4")
            )
        )

        val pagerAdapter = OnBoardingPagerAdapter(onboardingItems)
        binding.viewPager.adapter = pagerAdapter

        // Sembunyikan tombol "Back" di awal dan atur tampilan tombol sesuai posisi
        binding.btnBack.visibility = View.GONE
        updateNavigationButtons(binding.viewPager.currentItem, onboardingItems.size)

        binding.viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                updateNavigationButtons(position, onboardingItems.size)
            }
        })

        binding.btnBack.setOnClickListener {
            binding.viewPager.currentItem = binding.viewPager.currentItem - 1
        }

        binding.btnNext.setOnClickListener {
            if (binding.viewPager.currentItem == onboardingItems.size - 1) {
                completeOnboardingAndNavigate()
            } else {
                binding.viewPager.currentItem = binding.viewPager.currentItem + 1
            }
        }
    }

    private fun updateNavigationButtons(currentPosition: Int, totalPages: Int) {
        if (currentPosition == 0) {
            binding.btnBack.visibility = View.GONE
            binding.btnNext.text = "Selanjutnya"
        } else if (currentPosition == totalPages - 1) {
            binding.btnBack.visibility = View.VISIBLE
            binding.btnNext.text = "Mulai Aplikasi"
        } else {
            binding.btnBack.visibility = View.VISIBLE
            binding.btnNext.text = "Selanjutnya"
        }
    }

    private fun completeOnboardingAndNavigate() {
        lifecycleScope.launch {
            datastoreManager.setOnBoardingCompleted(true)
            val intent = Intent(this@OnBoardingActivity, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}