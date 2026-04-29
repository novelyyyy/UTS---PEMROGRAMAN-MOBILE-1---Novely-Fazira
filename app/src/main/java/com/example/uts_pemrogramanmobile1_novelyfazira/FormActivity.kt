package com.example.uts_pemrogramanmobile1_novelyfazira

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.uts_pemrogramanmobile1_novelyfazira.databinding.ActivityFormBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class FormActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFormBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFormBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupSpinner()
        setupValidation()
        setupAction()
    }

    private fun setupSpinner() {
        val listSeminar = arrayOf(
            "Seminar AI & Future Tech",
            "Seminar Mobile Dev with Kotlin",
            "Seminar UI/UX Modern Design",
            "Seminar Cyber Security Essentials",
            "Seminar Data Science Mastery"
        )
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, listSeminar)
        binding.spinnerSeminar.adapter = adapter
    }

    private fun setupValidation() {
        val watcher = object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                validateForm()
            }
            override fun afterTextChanged(s: Editable?) {}
        }

        binding.etName.addTextChangedListener(watcher)
        binding.etEmail.addTextChangedListener(watcher)
        binding.etPhone.addTextChangedListener(watcher)
        
        binding.cbAgreement.setOnCheckedChangeListener { _, _ -> validateForm() }
    }

    private fun validateForm() {
        val name = binding.etName.text.toString().trim()
        val email = binding.etEmail.text.toString().trim()
        val phone = binding.etPhone.text.toString().trim()
        val isAgreed = binding.cbAgreement.isChecked

        var isValid = true

        // Validasi Nama
        if (name.isEmpty()) {
            isValid = false
        }

        // Validasi Email
        if (email.isEmpty() || !email.contains("@")) {
            binding.tilEmail.error = if (email.isNotEmpty()) "Email harus valid (@)" else null
            isValid = false
        } else {
            binding.tilEmail.error = null
        }

        // Validasi Phone
        if (phone.isEmpty() || !phone.startsWith("08") || phone.length < 10 || phone.length > 13) {
            binding.tilPhone.error = if (phone.isNotEmpty()) "No HP tidak valid (08..., 10-13 digit)" else null
            isValid = false
        } else {
            binding.tilPhone.error = null
        }

        binding.btnSubmit.isEnabled = isValid && isAgreed
    }

    private fun setupAction() {
        binding.btnSubmit.setOnClickListener {
            MaterialAlertDialogBuilder(this)
                .setTitle("Konfirmasi Pendaftaran")
                .setMessage("Apakah data yang Anda isi sudah benar?")
                .setPositiveButton("Ya") { _, _ ->
                    sendData()
                }
                .setNegativeButton("Tidak", null)
                .show()
        }
    }

    private fun sendData() {
        val genderId = binding.rgGender.checkedRadioButtonId
        val gender = if (genderId == binding.rbMale.id) "Laki-laki" else "Perempuan"
        
        val intent = Intent(this, ResultActivity::class.java).apply {
            putExtra("EXTRA_NAME", binding.etName.text.toString())
            putExtra("EXTRA_EMAIL", binding.etEmail.text.toString())
            putExtra("EXTRA_PHONE", binding.etPhone.text.toString())
            putExtra("EXTRA_GENDER", gender)
            putExtra("EXTRA_SEMINAR", binding.spinnerSeminar.selectedItem.toString())
        }
        startActivity(intent)
    }
}