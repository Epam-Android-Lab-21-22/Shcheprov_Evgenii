package com.example.shcheprov_homeworks

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import com.example.shcheprov_homeworks.databinding.FragmentBlueBinding


class Blue : Fragment(), ColorFragmentInterface {
    private var _binding: FragmentBlueBinding? = null
    private val binding get() = _binding!!

    private val backStackChangedListener = FragmentManager.OnBackStackChangedListener {
        binding.counterTextView.text = parentFragmentManager.backStackEntryCount.toString()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentBlueBinding.inflate(inflater, container, false)
        setRootOnClickListener(
            binding.root,
            parentFragmentManager,
            TAGS.BLUE_FRAGMENT_TAG,
            Blue::class.java
        )
        initCounter(binding.counterTextView, parentFragmentManager, backStackChangedListener)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        removeCounterListener(parentFragmentManager, backStackChangedListener)
        _binding = null
    }
}