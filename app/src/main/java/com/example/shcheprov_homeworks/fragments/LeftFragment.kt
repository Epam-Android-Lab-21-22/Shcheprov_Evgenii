package com.example.shcheprov_homeworks.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.shcheprov_homeworks.adapters.LeftFragmentRecyclerViewAdapter
import com.example.shcheprov_homeworks.R
import com.example.shcheprov_homeworks.databinding.FragmentLeftBinding
import com.example.shcheprov_homeworks.entities.Lists


class LeftFragment : Fragment(R.layout.fragment_left) {
    private var _binding: FragmentLeftBinding? = null
    private val binding get() = _binding!!
    private val recyclerViewAdapter = LeftFragmentRecyclerViewAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        if(savedInstanceState==null){
            recyclerViewAdapter.updateList(Lists.listLeft)
        }
        else{Log.d("DEBUG",recyclerViewAdapter.itemCount.toString())}
        Log.d("DEBUG",recyclerViewAdapter.toString())
        Log.d("DEBUG",this.toString())
        _binding = FragmentLeftBinding.inflate(inflater, container, false)
        initRecyclerView()

        return binding.root
    }

    private fun initRecyclerView(){
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