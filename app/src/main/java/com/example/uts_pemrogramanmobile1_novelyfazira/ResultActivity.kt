package com.example.uts_pemrogramanmobile1_novelyfazira

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.uts_pemrogramanmobile1_novelyfazira.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {

    private lateinit var binding: ActivityResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        displayData()
        setupAction()
    }

    private fun displayData() {
        val name = intent.getStringExtra("EXTRA_NAME")
        val email = intent.getStringExtra("EXTRA_EMAIL")
        val phone = intent.getStringExtra("EXTRA_PHONE")
        val gender = intent.getStringExtra("EXTRA_GENDER")
        val seminar = intent.getStringExtra("EXTRA_SEMINAR")

        binding.tvResName.text = ": $name"
        binding.tvResEmail.text = ": $email"
        binding.tvResPhone.text = ": $phone"
        binding.tvResGender.text = ": $gender"
        binding.tvResSeminar.text = ": $seminar"
    }

    private fun setupAction() {
        binding.btnBackHome.setOnClickListener {
            // Kembali ke MainActivity dan hapus backstack Form & Result
            val intent = Intent(this, MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP
            startActivity(intent)
            finish()
        }
    }
}