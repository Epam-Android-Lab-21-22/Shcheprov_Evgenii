package com.example.shcheprov_homeworks.sightsScreen.view


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.shcheprov_homeworks.common.MainApp
import com.example.shcheprov_homeworks.R
import com.example.shcheprov_homeworks.databinding.FragmentSightsBinding
import com.example.shcheprov_homeworks.sightsScreen.entities.Sight
import com.example.shcheprov_homeworks.sightsScreen.presenters.ISightsView
import com.example.shcheprov_homeworks.sightsScreen.presenters.SightsPresenter


class SightsFragment : Fragment(R.layout.fragment_sights), ISightsView {
    private var _binding: FragmentSightsBinding? = null
    private val binding get() = _binding!!
    private val presenter = SightsPresenter(this)
    private val recyclerViewAdapter: SightsRecyclerViewAdapter =
        SightsRecyclerViewAdapter { position: Int -> presenter.onButtonDeleteClicked(position) }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentSightsBinding.inflate(inflater, container, false)
        initRecyclerView()

        (activity?.application as MainApp).mainAppStorage.getSightsData()
            ?.let { presenter.onViewRestored(it) }
        return binding.root
    }


    private fun initRecyclerView() {
        binding.sightsRecyclerView.apply {
            layoutManager =
                LinearLayoutManager(this.context, LinearLayoutManager.VERTICAL, false)
            adapter = recyclerViewAdapter
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
        (activity?.application as MainApp).mainAppStorage.setSightsData(presenter.onViewDestroyed())
    }

    override fun update(list: List<Sight>) {
        recyclerViewAdapter.updateList(list)
        binding.updatingProgressBar.visibility = View.GONE
    }

    override fun showProgressBar() {
        binding.updatingProgressBar.visibility = View.VISIBLE
    }
}