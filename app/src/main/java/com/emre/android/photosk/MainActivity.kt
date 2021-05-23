package com.emre.android.photosk

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.emre.android.photosk.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        val mainViewModel = MainViewModel()
        val photosAdapter = PhotosAdapter()
        val linearLayoutManager =
            LinearLayoutManager(baseContext, LinearLayoutManager.VERTICAL, false)
        setContentView(binding.root)

        binding.photosRecyclerview.adapter = photosAdapter
        binding.photosRecyclerview.layoutManager = linearLayoutManager

        mainViewModel.fetchPhotoUrls()
        mainViewModel.photosLiveData.observe(this, {
            photosAdapter.setList(it)
        })
    }
}