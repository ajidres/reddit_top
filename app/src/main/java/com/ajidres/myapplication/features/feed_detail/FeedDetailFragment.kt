package com.ajidres.myapplication.features.feed_detail

import android.os.Bundle
import android.view.View
import com.ajidres.myapplication.R
import com.ajidres.myapplication.base.BaseFragment
import com.ajidres.myapplication.databinding.FragmentFeedDetailBinding
import com.ajidres.myapplication.domain.model.ChildrenFeedDataEntity
import com.ajidres.myapplication.features.feed.FeedFragment.Companion.DATA_FEED
import com.bumptech.glide.Glide
import com.google.gson.Gson
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale


class FeedDetailFragment : BaseFragment<FragmentFeedDetailBinding>() {

    override fun initBinding(): FragmentFeedDetailBinding = FragmentFeedDetailBinding.inflate(layoutInflater)

    override fun initView(view: View, savedInstanceState: Bundle?) {

        val dataFeed = Gson().fromJson(arguments?.getString(DATA_FEED), ChildrenFeedDataEntity::class.java)

        showBackButton(dataFeed.linkFlairCssClass)

        showDetail(dataFeed)


    }

    private fun showDetail(dataFeed: ChildrenFeedDataEntity) {

        binding.subReddit.text = dataFeed.subredditNamePrefixed
        val itemDate = Date(dataFeed.created)
        val format = SimpleDateFormat("dd-MM HH:mm", Locale.US)
        binding.date.text = format.format(itemDate)
        binding.author.text = dataFeed.author
        binding.title.text = dataFeed.title
        binding.subtitle.text = dataFeed.selftext
        binding.votes.text = dataFeed.ups.toString()
        binding.comments.text = dataFeed.numComments.toString()


        Glide
            .with(this)
            .load(dataFeed.url)
            .placeholder(R.drawable.icon)
            .into(binding.imgView)

    }


}