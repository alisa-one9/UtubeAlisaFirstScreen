package com.example.myutuuubalisa.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewbinding.ViewBinding
import com.example.myutuuubalisa.R

abstract class BaseActivity <VB: ViewBinding> : AppCompatActivity() {

    lateinit var binding:VB
    abstract  fun inflateViewBinding():VB

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = inflateViewBinding()
        setContentView(binding.root)

        checkInternet()
        setUI()
        setupLiveData()
        initClickListener()

    }

    abstract fun initClickListener() //проверка инт соединения

    abstract fun setupLiveData() //инициализация LiveData

    abstract fun setUI() //инициализация UI

    abstract fun checkInternet() //обработка кликов
    abstract fun initRecycler()
}