package com.freedasd.retrofit.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.freedasd.retrofit.core.BaseFragment
import com.freedasd.retrofit.databinding.FragmentMovieListBinding
import com.freedasd.retrofit.presentation.adapter.ItemClickListener
import com.freedasd.retrofit.presentation.adapter.MovieListAdapter
import com.freedasd.retrofit.presentation.models.MovieUi

class MovieListFragment(): BaseFragment<FragmentMovieListBinding, MovieListViewModel>(), ItemClickListener {

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
        viewModel.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }
    }

    inner class ItemClickAdapter : ItemClickListener {
        override fun onClick(item: MovieUi) {
            Toast.makeText(requireContext(), "sdfsdf", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onClick(item: MovieUi) {
        Toast.makeText(requireContext(), "sdfsf", Toast.LENGTH_SHORT).show()
    }

    companion object {

        fun newInstance() = MovieListFragment()
    }
}