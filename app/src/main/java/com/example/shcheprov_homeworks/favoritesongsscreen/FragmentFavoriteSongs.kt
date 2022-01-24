package com.example.shcheprov_homeworks.favoritesongsscreen

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.domain.models.SongPreview
import com.example.shcheprov_homeworks.Keys
import com.example.shcheprov_homeworks.R
import com.example.shcheprov_homeworks.databinding.FragmentFavoriteSongsBinding

class FragmentFavoriteSongs : Fragment() {
    private var _binding: FragmentFavoriteSongsBinding? = null
    private val binding get() = _binding!!

    private val viewModel: FavoriteSongsViewModel by viewModels()
    private val recyclerViewAdapter = FavoriteSongsRecyclerViewAdapter(::loadSongInfo)

    private val favoriteSongPreviewListObserver = Observer<List<SongPreview>> {
        if (it != null)
            recyclerViewAdapter.updateList(it)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.getSongPreviewList()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFavoriteSongsBinding.inflate(inflater, container, false)
        val recyclerView = binding.favoriteSongsRecyclerView
        recyclerView.layoutManager =
            LinearLayoutManager(this.context, LinearLayoutManager.VERTICAL, false)
        recyclerView.adapter = recyclerViewAdapter

        viewModel.songPreviewListLiveData.observe(
            viewLifecycleOwner,
            favoriteSongPreviewListObserver
        )
        return binding.root
    }

    private fun loadSongInfo(id: String) {
        val bundle = Bundle()
        bundle.putString(Keys.idBundleKey,id)
        findNavController().navigate(R.id.action_fragmentFavoriteSongs_to_fragmentSongInfo,bundle)
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding=null
    }
}