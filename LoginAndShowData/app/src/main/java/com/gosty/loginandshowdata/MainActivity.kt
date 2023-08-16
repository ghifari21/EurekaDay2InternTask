package com.gosty.loginandshowdata

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import com.gosty.loginandshowdata.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initView()
    }

    private fun initView() {
        binding.btnLogin.setOnClickListener {
            if (validateData()) {
                val student = StudentModel(
                    name = binding.edtName.text.toString().trim(),
                    email = binding.edtEmail.text.toString().trim(),
                    jurusan = binding.edtJurusan.text.toString().trim(),
                    semester = binding.edtSemester.text.toString().trim().toInt()
                )
                val intent = Intent(this@MainActivity, DetailActivity::class.java)
                intent.putExtra(DetailActivity.EXTRA_DATA, student)
                startActivity(intent)
            } else {
                Toast.makeText(
                    this@MainActivity,
                    getString(R.string.invalid_input),
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

    private fun validateData(): Boolean {
        var result = true
        binding.apply {
            val name = edtName.text.toString().trim()
            val email = edtEmail.text.toString().trim()
            val jurusan = edtJurusan.text.toString().trim()
            val semester = edtSemester.text.toString().trim()

            // validate empty fields
            if (name.isEmpty()) {
                edtName.error = getString(R.string.empty_name)
                result = false
            }
            if (email.isEmpty()) {
                edtEmail.error = getString(R.string.empty_email)
                result = false
            }
            if (jurusan.isEmpty()) {
                edtJurusan.error = getString(R.string.empty_jurusan)
                result = false
            }
            if (semester.isEmpty()) {
                edtSemester.error = getString(R.string.empty_semester)
                result = false
            }

            // validate email format
            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                edtEmail.error = getString(R.string.email_wrong)
                result = false
            }

            // validate semester range
            if (semester.isNotEmpty() && semester.toInt() !in 14 downTo 1) {
                edtSemester.error = getString(R.string.semester_wrong)
                result = false
            }
        }

        return result
    }
}