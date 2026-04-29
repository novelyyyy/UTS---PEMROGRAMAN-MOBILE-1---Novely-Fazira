package com.example.uts_pemrogramanmobile1_novelyfazira

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.uts_pemrogramanmobile1_novelyfazira.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    // Data user hardcode untuk keperluan demonstrasi
    private val validEmail = "novelyfazira@gmail.com"
    private val validPassword = "novel123"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupAction()
    }

    private fun setupAction() {
        binding.btnLogin.setOnClickListener {
            val email = binding.etEmail.text.toString().trim()
            val password = binding.etPassword.text.toString().trim()

            // Validasi sederhana
            if (email.isEmpty()) {
                binding.tilEmail.error = "Email tidak boleh kosong"
                return@setOnClickListener
            } else {
                binding.tilEmail.error = null
            }

            if (password.isEmpty()) {
                binding.tilPassword.error = "Password tidak boleh kosong"
                return@setOnClickListener
            } else {
                binding.tilPassword.error = null
            }

            // Cek kredensial (Hardcoded)
            if (email == validEmail && password == validPassword) {
                Toast.makeText(this, "Login Berhasil!", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, MainActivity::class.java)
                intent.putExtra("USER_NAME", "Novely Fazira") // Contoh kirim data user
                startActivity(intent)
                finish() // Tutup LoginActivity
            } else {
                Toast.makeText(this, "Email atau Password salah!", Toast.LENGTH_SHORT).show()
            }
        }

        binding.tvRegister.setOnClickListener {
            // Pindah ke halaman Register
            startActivity(Intent(this, RegisterActivity::class.java))
        }
    }
}