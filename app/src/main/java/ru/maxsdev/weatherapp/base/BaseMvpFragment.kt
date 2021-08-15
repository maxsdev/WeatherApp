package ru.maxsdev.weatherapp.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding
import moxy.MvpAppCompatFragment

abstract class BaseMvpFragment<Binding : ViewBinding> : MvpAppCompatFragment() {

    private var _binding: Binding? = null
    protected val binding get() = requireNotNull(_binding) { "Binding is null." }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = inflate(inflater, container)
        return binding.root
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

    abstract fun inflate(inflater: LayoutInflater, container: ViewGroup?): Binding
}
