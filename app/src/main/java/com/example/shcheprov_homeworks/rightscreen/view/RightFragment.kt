package com.example.shcheprov_homeworks.rightscreen.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.shcheprov_homeworks.databinding.FragmentRightBinding
import com.example.shcheprov_homeworks.rightscreen.entities.RightScreenRecyclerViewItem
import com.example.shcheprov_homeworks.rightscreen.presenters.RightScreenContract
import com.example.shcheprov_homeworks.rightscreen.presenters.RightScreenPresenter

class RightFragment : Fragment(), RightScreenContract {
    private var _binding: FragmentRightBinding? = null
    private val binding get() = _binding!!
    private val recyclerViewAdapter = RightScreenRecyclerViewAdapter()
    private val presenter = RightScreenPresenter(this)
    private var recyclerView: RecyclerView? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRightBinding.inflate(inflater, container, false)

        initRecyclerView()
        binding.addNewItemButton.setOnClickListener {
            presenter.onButtonAddClicked()
        }
        presenter.onViewCreated(this)
        return binding.root
    }

    private fun initRecyclerView() {
        recyclerView = binding.rightFragmentRecyclerView
        recyclerView?.apply {
            layoutManager = GridLayoutManager(context, 4)
            adapter = recyclerViewAdapter
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        presenter.onViewDestroyed()
        _binding = null
        recyclerView = null
    }

    override fun updateRecyclerView(list: List<RightScreenRecyclerViewItem>) {
        recyclerViewAdapter.updateList(list)
        recyclerView?.scrollToPosition(recyclerViewAdapter.itemCount - 1)
        binding.updatingProgressBar.visibility = View.GONE
    }

    override fun showProgressBar() {
        binding.updatingProgressBar.visibility = View.VISIBLE
    }

}