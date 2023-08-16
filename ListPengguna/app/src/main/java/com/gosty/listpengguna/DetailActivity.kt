package com.gosty.listpengguna

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.gosty.listpengguna.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val user = intent.getParcelableExtra<UserModel>(EXTRA_DATA)
        initView(user)
    }

    private fun initView(user: UserModel?) {
        binding.apply {
            Glide.with(this@DetailActivity)
                .load(user?.photo)
                .placeholder(R.drawable.ic_image)
                .error(R.drawable.ic_broken_image)
                .into(ivAvatar)

            tvDataName.text = getString(R.string.show_data, user?.name)
            tvDataEmail.text = getString(R.string.show_data, user?.email)
            tvDataJurusan.text = getString(R.string.show_data, user?.jurusan)
            tvDataSemester.text = getString(R.string.show_data, user?.semester.toString())
        }
    }

    companion object {
        const val EXTRA_DATA = "extra"
    }
}