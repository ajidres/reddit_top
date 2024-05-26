package com.ajidres.myapplication.features.state

import android.os.Bundle
import android.view.View
import com.ajidres.myapplication.base.BaseFragment
import com.ajidres.myapplication.databinding.FragmentStateBinding


class StateFragment : BaseFragment<FragmentStateBinding>() {

    override fun initBinding(): FragmentStateBinding = FragmentStateBinding.inflate(layoutInflater)

    override fun initView(view: View, savedInstanceState: Bundle?) {

    }

}