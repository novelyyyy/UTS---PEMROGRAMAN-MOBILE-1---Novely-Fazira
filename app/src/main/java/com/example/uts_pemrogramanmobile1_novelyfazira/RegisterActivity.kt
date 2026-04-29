package com.example.uts_pemrogramanmobile1_novelyfazira

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.uts_pemrogramanmobile1_novelyfazira.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupAction()
    }

    private fun setupAction() {
        binding.btnRegister.setOnClickListener {
            val name = binding.etFullName.text.toString().trim()
            val email = binding.etEmail.text.toString().trim()
            val password = binding.etPassword.text.toString().trim()

            if (name.isEmpty() || email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Harap lengkapi semua data!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Simulasi register berhasil
            Toast.makeText(this, "Registrasi Berhasil! Silakan Login", Toast.LENGTH_SHORT).show()
            finish() // Kembali ke LoginActivity
        }

        binding.tvLogin.setOnClickListener {
            finish() // Kembali ke LoginActivity
        }
    }
}