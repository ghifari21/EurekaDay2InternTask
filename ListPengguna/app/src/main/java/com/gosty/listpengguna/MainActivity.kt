package com.gosty.listpengguna

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.gosty.listpengguna.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val adapter = UserListAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initView()
    }

    private fun initView() {
        val layoutManager = LinearLayoutManager(this@MainActivity)
        val decor = DividerItemDecoration(this@MainActivity, layoutManager.orientation)
        binding.apply {
            rv.layoutManager = layoutManager
            rv.setHasFixedSize(true)
            rv.addItemDecoration(decor)
            rv.adapter = adapter
        }

        adapter.submitList(DataDummy.provideDataDummy())
        adapter.setOnItemClickCallback(
            object : UserListAdapter.OnItemClickCallback {
                override fun onItemClicked(user: UserModel) {
                    val intent = Intent(this@MainActivity, DetailActivity::class.java)
                    intent.putExtra(DetailActivity.EXTRA_DATA, user)
                    startActivity(intent)
                }
            }
        )
    }
}