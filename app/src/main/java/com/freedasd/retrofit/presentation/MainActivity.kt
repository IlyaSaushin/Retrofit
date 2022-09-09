package com.freedasd.retrofit.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.freedasd.retrofit.MainViewModel
import com.freedasd.retrofit.R
import com.freedasd.retrofit.databinding.ActivityMainBinding
import com.freedasd.retrofit.presentation.MovieDetailsFragment.Companion.newInstance

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        initFragment()
    }

    private fun initFragment() {
        val fragment = MovieListFragment.newInstance()
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, fragment)
            .commit()
    }
}