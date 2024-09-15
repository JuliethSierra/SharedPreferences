package com.example.sharedpreferences

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.activity.ComponentActivity
import com.example.sharedpreferences.databinding.ActivityMainBinding

class MainActivity : ComponentActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sharedPreferences = getSharedPreferences("AppPreferences", Context.MODE_PRIVATE)

        updateViewCount()
    }

    override fun onResume() {
        super.onResume()
        countNumberOfViews()
    }

    private fun countNumberOfViews() {
        var count = sharedPreferences.getInt("viewCount", 0)
        count++

        binding.tvCount.text = count.toString()

        val editor = sharedPreferences.edit()
        editor.putInt("viewCount", count)
        editor.apply()
    }

    private fun updateViewCount() {
        val count = sharedPreferences.getInt("viewCount", 0)
        binding.tvCount.text = count.toString()
    }
}
