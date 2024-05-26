package com.ajidres.myapplication.base

import android.R
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.View.GONE
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.navigation.fragment.findNavController
import androidx.viewbinding.ViewBinding
import com.ajidres.movies.extentions.clearFlagProgress
import com.ajidres.movies.extentions.gone
import com.ajidres.movies.extentions.setFlagProgress
import com.ajidres.movies.extentions.visible
import com.ajidres.myapplication.NavMainDirections
import com.ajidres.myapplication.domain.model.ResponseErrorUI
import com.ajidres.myapplication.extentions.IO_EXCEPTION_CODE


abstract class BaseFragment<T : ViewBinding> : Fragment(), MenuProvider {

    private var _bind: T? = null
    protected val binding: T get() = _bind!!
    lateinit var progressBar: View


    abstract fun initBinding(): T

    abstract fun initView(view: View, savedInstanceState: Bundle?)


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _bind = initBinding()
        val menuHost: MenuHost = requireActivity()
        menuHost.addMenuProvider(this, viewLifecycleOwner, Lifecycle.State.RESUMED)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView(view, savedInstanceState)
    }

    override fun onDestroy() {
        super.onDestroy()
        _bind = null
    }

    protected fun showBackButton(title: String = "") {
        setTitleMenu(title)
        val actionBar = (requireActivity() as AppCompatActivity?)!!.supportActionBar!!
        actionBar.setDisplayHomeAsUpEnabled(true)

    }

    override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {}
    override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
        when (menuItem.itemId) {
            R.id.home -> {
                findNavController().popBackStack()
                return true
            }
        }
        return false
    }

    protected fun setTitleMenu(title: String = "") {
        val actionBar = (requireActivity() as AppCompatActivity?)!!.supportActionBar!!

        if (title.isNotEmpty()) {
            actionBar.title = title
        }
    }

    protected fun manageError(errorMessage: ResponseErrorUI?) {
        if (errorMessage != null) {
            if (errorMessage.errorCode == IO_EXCEPTION_CODE) {
                findNavController().navigate(NavMainDirections.moveToStateFragment())
            } else {
                Toast.makeText(requireActivity(), errorMessage.description, Toast.LENGTH_SHORT).show()
            }
        } else {
            Toast.makeText(requireActivity(), "ERROR", Toast.LENGTH_SHORT).show()
        }
    }

    fun showProgress(show:Boolean) {
        if (show) {
            requireActivity().window.setFlagProgress()
            progressBar.visible()
        } else {
            requireActivity().window.clearFlagProgress()
            progressBar.gone()
        }
    }


}