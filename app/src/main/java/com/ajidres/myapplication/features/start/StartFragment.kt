package com.ajidres.myapplication.features.start

import android.annotation.SuppressLint
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.webkit.WebResourceError
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.ajidres.movies.extentions.visible
import com.ajidres.myapplication.BuildConfig.CLIENT_ID
import com.ajidres.myapplication.BuildConfig.REDIRECT_URI
import com.ajidres.myapplication.BuildConfig.URL_BASE
import com.ajidres.myapplication.NavMainDirections
import com.ajidres.myapplication.R
import com.ajidres.myapplication.base.BaseFragment
import com.ajidres.myapplication.data.AppPreferences
import com.ajidres.myapplication.data.api.model.ResultEndpoints
import com.ajidres.myapplication.databinding.FragmentStartBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@SuppressLint("SetJavaScriptEnabled")
@AndroidEntryPoint
class StartFragment : BaseFragment<FragmentStartBinding>() {

    @Inject
    lateinit var appPreferences: AppPreferences

    private val viewModel: StartViewModel by viewModels()

    companion object {
        const val URL_CODE = "code="
        const val QUERY_PARAMETER = "code"
        const val URL_AUTH = "${URL_BASE}authorize?client_id=$CLIENT_ID&response_type=code&state=testAlien&redirect_uri=$REDIRECT_URI&scope=read"
    }

    override fun initBinding(): FragmentStartBinding = FragmentStartBinding.inflate(layoutInflater)


    override fun initView(view: View, savedInstanceState: Bundle?) {
        progressBar = binding.progressBar.root
        showViewModel()
    }


    private fun showViewModel() {
        binding.webView.settings.javaScriptEnabled = true
        binding.webView.loadUrl(URL_AUTH)
        binding.webView.setWebViewClient(object : WebViewClient() {

            override fun onReceivedError(view: WebView?, request: WebResourceRequest?, error: WebResourceError?) {
                super.onReceivedError(view, request, error)
                if(error?.errorCode==-2){
                    findNavController().navigate(NavMainDirections.moveToStateFragment())
                }
            }

            override fun onPageFinished(view: WebView?, url: String?) {
                if(url != null && url.contains(REDIRECT_URI)){
                    binding.validateAccess.visible()
                }
                if (url != null && url.contains(URL_CODE) ) {
                    val authCode = Uri.parse(url).getQueryParameter(QUERY_PARAMETER)
                    if (!authCode.isNullOrBlank()) {
                        accessDataObserverApi()
                        viewModel.grantAccess(authCode)
                    }

                }
            }
        })
    }

    private fun accessDataObserverApi() {
        viewModel.accessData.observe(this) { access ->
            when (access) {
                is ResultEndpoints.Loading -> {
                    showProgress(true)
                }

                is ResultEndpoints.Success -> {
                    showProgress(false)
                    appPreferences.token = access.data.accessToken
                    appPreferences.refresh = access.data.refreshToken
                    findNavController().navigate(R.id.action_startFragment_to_feedFragment)
                }

                is ResultEndpoints.Failure -> {
                    showProgress(false)
                    Toast.makeText(requireActivity(), access.errorMessage!!.description, Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

}