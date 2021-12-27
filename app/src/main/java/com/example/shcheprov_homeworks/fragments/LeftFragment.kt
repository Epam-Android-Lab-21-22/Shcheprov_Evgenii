package com.example.shcheprov_homeworks.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.shcheprov_homeworks.adapters.LeftFragmentRecyclerViewAdapter
import com.example.shcheprov_homeworks.R
import com.example.shcheprov_homeworks.databinding.FragmentLeftBinding


class LeftFragment : Fragment(R.layout.fragment_left) {
    private var _binding: FragmentLeftBinding? = null
    private val binding get() = _binding!!
    val recyclerViewAdapter = LeftFragmentRecyclerViewAdapter()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentLeftBinding.inflate(inflater, container, false)
        initRecyclerView()
        return binding.root
    }

    private fun initRecyclerView() {
        val recyclerView = binding.leftFragmentRecyclerView
        recyclerView.apply {
            layoutManager =
                LinearLayoutManager(this.context, LinearLayoutManager.VERTICAL, false)
            adapter = recyclerViewAdapter
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}