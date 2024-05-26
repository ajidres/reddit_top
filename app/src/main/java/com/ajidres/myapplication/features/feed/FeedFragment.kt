package com.ajidres.myapplication.features.feed

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ajidres.myapplication.R
import com.ajidres.myapplication.base.BaseFragment
import com.ajidres.myapplication.data.api.model.ResultEndpoints
import com.ajidres.myapplication.databinding.FragmentFeedBinding
import com.ajidres.myapplication.domain.model.ChildrenFeedDataEntity
import com.google.gson.Gson
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class FeedFragment : BaseFragment<FragmentFeedBinding>() {


    companion object {
        const val DATA_FEED = "DATA_FEED"
        const val PAGES_REFRESH = 10
        const val ZERO = 0
    }

    private val viewModel: FeedViewModel by viewModels()
    private val feedAdapter by lazy {
        FeedAdapter { item ->

            findNavController().navigate(R.id.action_feedFragment_to_feedDetailFragment, Bundle().apply {
                putString(DATA_FEED, Gson().toJson(item))
            })

        }
    }
    private var pagesFeed = PAGES_REFRESH

    private var originalData: MutableList<ChildrenFeedDataEntity> = mutableListOf()

    private lateinit var rvLinearLayoutManager: LinearLayoutManager

    private var fetched = false

    override fun initBinding(): FragmentFeedBinding = FragmentFeedBinding.inflate(layoutInflater)

    override fun initView(view: View, savedInstanceState: Bundle?) {
        progressBar = binding.progressBar.root
        setTitleMenu(getString(R.string.app_name))
        setupFeedRecycler()
        loadData()
    }

    private fun setupFeedRecycler() {
        binding.rvFeed.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = feedAdapter
        }

        rvLinearLayoutManager = binding.rvFeed.layoutManager as LinearLayoutManager
        binding.rvFeed.addOnScrollListener(object : RecyclerView.OnScrollListener() {

            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                val lastVisibleItemPosition = rvLinearLayoutManager.childCount
                val totalItemCount: Int = rvLinearLayoutManager.itemCount - 3
                val firstVisibleItemPosition: Int = rvLinearLayoutManager.findFirstVisibleItemPosition()

                if (lastVisibleItemPosition + firstVisibleItemPosition >= totalItemCount
                    && firstVisibleItemPosition >= ZERO && !fetched
                ) {
                    fetched = true
                    pagesFeed += PAGES_REFRESH
                    viewModel.fetchFeed(pagesFeed)
                }
            }
        })

    }

    @SuppressLint("NotifyDataSetChanged")
    private fun loadData() {
        showProgress(true)
        viewModel.feedData.observe(this) { feed ->
            when (feed) {
                is ResultEndpoints.Loading -> {}
                is ResultEndpoints.Success -> {
                    showProgress(false)
                    originalData.clear()
                    originalData.addAll(feed.data)
                    if (feedAdapter.itemCount == ZERO) {
                        feedAdapter.submitList(originalData)
                    } else {
                        feedAdapter.notifyDataSetChanged()
                        fetched = false
                    }
                }
                is ResultEndpoints.Failure -> {
                    showProgress(false)
                    manageError(feed.errorMessage)
                }
            }
        }
        viewModel.fetchFeed(pagesFeed)
    }

}