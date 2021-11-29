package com.example.myutuuubalisa.ui

import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myutuuubalisa.databinding.ActivityMainBinding
import com.example.myutuuubalisa.remote.PlayListViewModel

class PlayListActivity : BaseActivity<ActivityMainBinding> () {

    private lateinit var viewModel :PlayListViewModel


    override fun checkInternet() {

    }
    override fun initClickListener() {

    }

    override fun setupLiveData() {
       viewModel.getPlayList().observe(this) { response ->
           Toast.makeText(this, response.kind,Toast.LENGTH_SHORT).show()

       }
    }

    override fun setUI() {
       viewModel = ViewModelProvider(this).get(PlayListViewModel::class.java)
    }



    override fun inflateViewBinding(): ActivityMainBinding {
        return ActivityMainBinding.inflate(layoutInflater)
    }

    override fun initRecycler() {
        binding.rvPlaylist.apply {
            layoutManager = LinearLayoutManager(this@PlayListActivity)
            adapter  = this.adapter
        }

    }


}