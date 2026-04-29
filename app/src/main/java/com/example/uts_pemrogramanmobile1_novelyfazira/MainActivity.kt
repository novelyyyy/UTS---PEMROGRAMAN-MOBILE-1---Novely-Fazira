package com.example.uts_pemrogramanmobile1_novelyfazira

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.uts_pemrogramanmobile1_novelyfazira.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Ambil data user dari Intent
        val userName = intent.getStringExtra("USER_NAME") ?: "User"
        binding.tvWelcome.text = "Welcome, $userName to Seminar Registration"

        setupAction()
    }

    private fun setupAction() {
        binding.btnGoToForm.setOnClickListener {
            // Pindah ke Halaman Form Pendaftaran
            startActivity(Intent(this, FormActivity::class.java))
        }

        binding.btnLogout.setOnClickListener {
            // Kembali ke Login dan clear task
            val intent = Intent(this, LoginActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
        }
    }
}