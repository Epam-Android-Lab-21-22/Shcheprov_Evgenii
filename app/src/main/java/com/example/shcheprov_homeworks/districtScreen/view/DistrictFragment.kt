package com.example.shcheprov_homeworks.districtScreen.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.shcheprov_homeworks.databinding.FragmentDistrictsBinding

import com.example.shcheprov_homeworks.districtScreen.entities.District
import com.example.shcheprov_homeworks.districtScreen.presenters.DistrictPresenter
import com.example.shcheprov_homeworks.districtScreen.presenters.IDistrictView
import com.example.shcheprov_homeworks.common.MainApp


class DistrictFragment : Fragment(), IDistrictView {
    private var _binding: FragmentDistrictsBinding? = null
    private val binding get() = _binding!!
    private val recyclerViewAdapter = DistrictRecyclerViewAdapter()
    private val presenter = DistrictPresenter(this)
    private var recyclerView: RecyclerView? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDistrictsBinding.inflate(inflater, container, false)
        initRecyclerView()
        binding.addNewDistrictButton.setOnClickListener {
            presenter.onButtonAddClicked()
        }
        (activity?.application as MainApp).mainAppStorage.getDistrictData()
            ?.let { presenter.onViewRestored(it) }
        return binding.root

    }

    private fun initRecyclerView() {
        recyclerView = binding.rightFragmentRecyclerView
        recyclerView?.apply {
            layoutManager = GridLayoutManager(context, 3)
            adapter = recyclerViewAdapter
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        (activity?.application as MainApp).mainAppStorage.setDistrictData(presenter.onViewDestroyed())
        recyclerView=null
    }

    override fun update(list: List<District>) {
        recyclerViewAdapter.updateList(list)
        recyclerView?.scrollToPosition(recyclerViewAdapter.itemCount - 1)
        binding.updatingProgressBar.visibility = View.GONE
    }

    override fun startUpdating() {
        binding.updatingProgressBar.visibility = View.VISIBLE
    }
}