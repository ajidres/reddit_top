package com.ajidres.myapplication

import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import com.ajidres.myapplication.base.BaseActivity
import com.ajidres.myapplication.data.AppPreferences
import com.ajidres.myapplication.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>() {

    @Inject
    lateinit var appPreferences: AppPreferences

    override fun initBinding(): ActivityMainBinding = ActivityMainBinding.inflate(layoutInflater)

    override fun initView(savedInstanceState: Bundle?) {

        val navHostFragment = (supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment)
        val inflater = navHostFragment.navController.navInflater
        val graph = inflater.inflate(R.navigation.nav_main)
        if (!appPreferences.token.isNullOrBlank()) {
            graph.setStartDestination(R.id.feedFragment)
        } else {
            graph.setStartDestination(R.id.startFragment)
        }
        navHostFragment.navController.graph = graph

    }
}