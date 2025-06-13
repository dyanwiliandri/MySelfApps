package com.example.myselfapps.view

import android.content.Intent
import android.os.Bundle
import android.view.animation.AnimationUtils
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.datastore.dataStore
import androidx.lifecycle.lifecycleScope
import com.example.myselfapps.R
import com.example.myselfapps.databinding.ActivitySplashScreenBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

@AndroidEntryPoint
class SplashScreenActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySplashScreenBinding
    private lateinit var datastoreManager: DataStoreManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        datastoreManager = DataStoreManager(applicationContext)
        val slideInAnim = AnimationUtils.loadAnimation(this, R.anim.slide_in)
        binding.txtLoading.startAnimation(slideInAnim)

        lifecycleScope.launch {
            delay(4000)
            val isOnboardingCompleted = datastoreManager.isOnboardingCompleted.first()
            val intent: Intent
            if (!isOnboardingCompleted){
                intent = Intent(this@SplashScreenActivity, OnBoardingActivity::class.java)
            }else{
                intent = Intent(this@SplashScreenActivity, MainActivity::class.java)
            }
            startActivity(intent)
            finish()
        }
    }
}