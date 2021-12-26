package com.example.shcheprov_homeworks.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.shcheprov_homeworks.LeftFragmentRecyclerViewAdapter
import com.example.shcheprov_homeworks.R
import com.example.shcheprov_homeworks.RightFragmentRecyclerViewAdapter
import com.example.shcheprov_homeworks.databinding.FragmentLeftBinding
import com.example.shcheprov_homeworks.databinding.FragmentRightBinding
import com.example.shcheprov_homeworks.entities.RightFragmentRecyclerViewItem
import kotlin.random.Random


class RightFragment : Fragment() {
    private var _binding: FragmentRightBinding? = null
    private val binding get() = _binding!!
    private val recyclerViewAdapter = RightFragmentRecyclerViewAdapter()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRightBinding.inflate(inflater, container, false)
        initRecyclerView()
        binding.addNewItemButton.setOnClickListener {

                val icons = requireContext().resources.obtainTypedArray(R.array.icons)
                val strings = requireContext().resources.getStringArray(R.array.phrases)

            val icon = icons.getDrawable(Random.nextInt(icons.length()))
            val string = strings[Random.nextInt(strings.size)]
            val item = RightFragmentRecyclerViewItem(icon!!,string)
            recyclerViewAdapter.addItem(item)
        }
        return binding.root
    }
    private fun initRecyclerView(){
        val recyclerView = binding.rightFragmentRecyclerView
        recyclerView.apply {
            layoutManager = GridLayoutManager(context,4)
            adapter = recyclerViewAdapter
        }


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding=null
    }
}