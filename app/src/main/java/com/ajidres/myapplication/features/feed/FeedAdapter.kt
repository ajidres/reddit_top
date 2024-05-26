package com.ajidres.myapplication.features.feed

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.ajidres.myapplication.R
import com.ajidres.myapplication.databinding.ViewItemFeedBinding
import com.ajidres.myapplication.domain.model.ChildrenFeedDataEntity
import com.bumptech.glide.Glide

class FeedAdapter(private val clickListener: (ChildrenFeedDataEntity) -> Unit) :
    ListAdapter<ChildrenFeedDataEntity, FeedViewHolder>(ResultDiffUtil()) {

    private lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeedViewHolder {
        context = parent.context

        val mView: ViewItemFeedBinding = ViewItemFeedBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return FeedViewHolder(mView)
    }

    override fun onBindViewHolder(holder: FeedViewHolder, position: Int) {
        holder.bind(context, getItem(position), clickListener)
    }
}

class FeedViewHolder(itemView: ViewItemFeedBinding) : RecyclerView.ViewHolder(itemView.root) {

    private var mView: ViewItemFeedBinding = itemView

    @SuppressLint("SetJavaScriptEnabled")
    fun bind(context: Context, items: ChildrenFeedDataEntity, clickListener: (ChildrenFeedDataEntity) -> Unit) {

        mView.container.setOnClickListener {
            clickListener.invoke(items)
        }

        with(mView) {
            title.text = items.title
            Glide
                .with(context)
                .load(items.url)
                .placeholder(R.drawable.icon)
                .into(imgView)

        }
    }

}

class ResultDiffUtil : DiffUtil.ItemCallback<ChildrenFeedDataEntity>() {
    override fun areItemsTheSame(oldItem: ChildrenFeedDataEntity, newItem: ChildrenFeedDataEntity): Boolean = oldItem == newItem

    override fun areContentsTheSame(oldItem: ChildrenFeedDataEntity, newItem: ChildrenFeedDataEntity): Boolean = oldItem == newItem
}