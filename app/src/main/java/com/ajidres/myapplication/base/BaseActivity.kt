package com.ajidres.myapplication.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowInsetsControllerCompat
import androidx.viewbinding.ViewBinding


abstract class BaseActivity<T> : AppCompatActivity() where T : ViewBinding {


    private lateinit var windowsController: WindowInsetsControllerCompat

    private var _bind: T? = null

    protected val binding: T get() = _bind!!

    abstract fun initBinding(): T

    abstract fun initView(savedInstanceState: Bundle?)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _bind = initBinding()
        setContentView(binding.root)
        initView(savedInstanceState)
    }

    override fun onDestroy() {
        super.onDestroy()
        _bind = null
    }


}