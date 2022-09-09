package com.freedasd.retrofit.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.freedasd.retrofit.R
import com.freedasd.retrofit.core.BaseFragment
import com.freedasd.retrofit.databinding.FragmentMovieListBinding
import com.freedasd.retrofit.presentation.adapter.ItemClickListener
import com.freedasd.retrofit.presentation.adapter.MovieListAdapter
import com.freedasd.retrofit.presentation.models.MovieUi

class MovieListFragment(): BaseFragment<FragmentMovieListBinding, MovieListViewModel>() {

    override fun viewModelClass() = MovieListViewModel::class.java

    override fun createBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentMovieListBinding.inflate(inflater, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val clickListener = ItemClickAdapter()

        val adapter = MovieListAdapter(clickListener)
        binding.recyclerView.adapter = adapter

        viewModel.list()
        viewModel.observeList(viewLifecycleOwner) { adapter.submitList(it) }
        viewModel.observeSelectedItem(viewLifecycleOwner, ::openDetailsDialog)
    }

    inner class ItemClickAdapter : ItemClickListener {
        override fun onClick(item: MovieUi) {
            viewModel.fetchMovieById(item.id())
        }
    }

    private fun openDetailsDialog(item: MovieUi) {

        requireActivity().supportFragmentManager.beginTransaction().hide(this).apply {
            add(R.id.container, MovieDetailsFragment.newInstance(item))
                .addToBackStack(null)
                .commit()
        }
    }


    companion object {

        fun newInstance() = MovieListFragment()
    }
}