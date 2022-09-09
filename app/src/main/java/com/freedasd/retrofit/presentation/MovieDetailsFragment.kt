package com.freedasd.retrofit.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import com.freedasd.retrofit.core.BaseFragment
import com.freedasd.retrofit.databinding.FragmentMovieDetailsBinding
import com.freedasd.retrofit.presentation.models.MovieUi

class MovieDetailsFragment : BaseFragment<FragmentMovieDetailsBinding, MovieDetailsViewModel>() {

    override fun viewModelClass() = MovieDetailsViewModel::class.java

    override fun createBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentMovieDetailsBinding.inflate(inflater, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val movie = details()
        movie?.mapDetails(
            binding.movieTitle,
            binding.movieImageView,
            binding.movieDescription,
            binding.moviePublicationDate,
            binding.movieByLine
        )
    }

    private fun details() = requireArguments().getParcelable<MovieUi.Base>(DETAILS_ITEM)

    companion object {

        const val TAG = "simple tag"
        const val DETAILS_ITEM = "DETAILS_ITEM"

        fun newInstance(item: MovieUi) = MovieDetailsFragment().apply {
            arguments = bundleOf(DETAILS_ITEM to item)
        }
    }
}