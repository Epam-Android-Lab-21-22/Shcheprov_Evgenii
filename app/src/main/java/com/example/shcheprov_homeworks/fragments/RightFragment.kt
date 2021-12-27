package com.example.shcheprov_homeworks.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.shcheprov_homeworks.R
import com.example.shcheprov_homeworks.adapters.RightFragmentRecyclerViewAdapter
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
        val recyclerView = binding.rightFragmentRecyclerView
        recyclerView.apply {
            layoutManager = GridLayoutManager(context, 4)
            adapter = recyclerViewAdapter
        }
        initRecyclerView(recyclerView)
        return binding.root
    }

    private fun initRecyclerView(recyclerView: RecyclerView) {
        binding.addNewItemButton.setOnClickListener {
            val icons = requireContext().resources.obtainTypedArray(R.array.icons)
            val strings = requireContext().resources.getStringArray(R.array.phrases)
            val item = icons.getDrawable(Random.nextInt(icons.length()))?.let {
                RightFragmentRecyclerViewItem(
                    it, strings[Random.nextInt(strings.size)]
                )
            }
            item?.let {
                recyclerViewAdapter.addItem(it)
            }
            recyclerView.scrollToPosition(recyclerViewAdapter.itemCount - 1)
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}