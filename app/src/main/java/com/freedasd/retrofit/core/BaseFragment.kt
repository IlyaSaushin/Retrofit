package com.freedasd.retrofit.core

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.viewbinding.ViewBinding
import com.freedasd.retrofit.RetrofitApp
import com.freedasd.retrofit.data.VMFactoryProvider
import com.freedasd.retrofit.sl.ViewModelsFactory

abstract class BaseFragment<VB: ViewBinding, VM: ViewModel> : Fragment() {

    var _binding: VB? = null
    val binding: VB get() = _binding!!

    protected lateinit var viewModel: VM

    abstract fun viewModelClass() : Class<VM>

    abstract fun createBinding(inflater: LayoutInflater, container: ViewGroup?) : VB

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val factory = (requireActivity().application as VMFactoryProvider).provide()
        viewModel = ViewModelProvider(this, factory)[viewModelClass()]
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = createBinding(inflater, container)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}