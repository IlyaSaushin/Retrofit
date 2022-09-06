package com.freedasd.retrofit.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.freedasd.retrofit.databinding.ItemErrorBinding
import com.freedasd.retrofit.databinding.ItemLayoutBinding
import com.freedasd.retrofit.databinding.ItemLoadingBinding
import com.freedasd.retrofit.presentation.models.MovieUi

interface ItemClickListener {

    fun onClick(item: MovieUi)
}

class MovieListAdapter(
    private val clickListener: ItemClickListener
) : ListAdapter<MovieUi, RecyclerView.ViewHolder>(Diff()) {

    override fun getItemViewType(position: Int) = when(getItem(position)){
        is MovieUi.Base -> BASE_TYPE
        is MovieUi.Loading -> LOADING_TYPE
        is MovieUi.Fail -> ERROR_TYPE
        else -> throw IllegalStateException("No such view type :_(")
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) : RecyclerView.ViewHolder {
        return when(viewType) {
            BASE_TYPE -> {
                BaseItemViewHolder(ItemLayoutBinding.inflate(parent.inflater(), parent, false), clickListener)
            }
            ERROR_TYPE -> {
                FailItemViewHolder(ItemErrorBinding.inflate(parent.inflater(), parent,false))
            }
            LOADING_TYPE -> {
                LoadingViewHolder(ItemLoadingBinding.inflate(parent.inflater(), parent, false))
            }
            else -> throw IllegalStateException("No such view type :_(")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (val item = getItem(position)) {
            is MovieUi.Base -> (holder as BaseItemViewHolder).bind(item)
            is MovieUi.Fail -> (holder as FailItemViewHolder).bind(item)
        }
    }

    private class Diff : DiffUtil.ItemCallback<MovieUi>() {
        override fun areItemsTheSame(oldItem: MovieUi, newItem: MovieUi) =
            oldItem.same(newItem)

        override fun areContentsTheSame(oldItem: MovieUi, newItem: MovieUi) =
            oldItem.equals(newItem)
    }

    private fun ViewGroup.inflater(): LayoutInflater {
        return LayoutInflater.from(this.context)
    }

    companion object {

        const val BASE_TYPE = 0
        const val ERROR_TYPE = 1
        const val LOADING_TYPE = 2
    }
}

class BaseItemViewHolder (
    private val binding: ItemLayoutBinding,
    private val clickListener: ItemClickListener
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: MovieUi) {
        item.map(binding.title, binding.imageView, binding.publicationDateTv)
        itemView.setOnClickListener { clickListener.onClick(item) }
    }
}

class FailItemViewHolder (
    private val binding: ItemErrorBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: MovieUi) {
        item.mapError(binding.textError)
    }
}

class LoadingViewHolder(binding: ItemLoadingBinding) : RecyclerView.ViewHolder(binding.root)