package com.example.shcheprov_homeworks.leftscreen.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.shcheprov_homeworks.R
import com.example.shcheprov_homeworks.databinding.FragmentLeftBinding
import com.example.shcheprov_homeworks.leftscreen.entities.LeftFragmentRecyclerViewItem
import com.example.shcheprov_homeworks.leftscreen.presenters.LeftScreenContract
import com.example.shcheprov_homeworks.leftscreen.presenters.LeftScreenPresenter


class LeftFragment : Fragment(R.layout.fragment_left), LeftScreenContract {
    private var _binding: FragmentLeftBinding? = null
    private val binding get() = _binding!!
    private val presenter = LeftScreenPresenter(this)
    private val recyclerViewAdapter: LeftScreenRecyclerViewAdapter =
        LeftScreenRecyclerViewAdapter { position: Int -> presenter.onButtonDeleteClicked(position) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentLeftBinding.inflate(inflater, container, false)
        initRecyclerView()
        presenter.onViewCreated(this)
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
        presenter.onViewDestroyed()
    }

    override fun updateRecyclerView(list: List<LeftFragmentRecyclerViewItem>) {
        recyclerViewAdapter.updateList(list)
        binding.updatingProgressBar.visibility = View.GONE
    }

    override fun showProgressBar() {
        binding.updatingProgressBar.visibility = View.VISIBLE
    }
}