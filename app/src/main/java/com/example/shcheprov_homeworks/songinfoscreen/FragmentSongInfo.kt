package com.example.shcheprov_homeworks.songinfoscreen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.domain.models.SongInfo
import com.example.shcheprov_homeworks.Keys
import com.example.shcheprov_homeworks.R
import com.example.shcheprov_homeworks.databinding.FragmentSongInfoBinding
import com.squareup.picasso.Picasso

class FragmentSongInfo : Fragment() {
    private val viewModel: SongInfoViewModel by viewModels()
    private var _binding: FragmentSongInfoBinding? = null
    private val binding get() = _binding!!
    private val songInfoObserver = Observer<SongInfo> {
        if (it != null) {
            binding.collapsingToolbarLayout.title = it.songPreview.title
            Picasso.get()
                .load(it.songPreview.coverUrl)
                .into(binding.coverImageView)
            binding.perforemerTextView.text =
                getString(R.string.performer) + it.songPreview.performer
            binding.albumTextView.text = getString(R.string.album) + it.album
            binding.releaseTextView.text = getString(R.string.release) + it.release
            binding.genreTextView.text = getString(R.string.genre) + it.genre
            binding.songTextTextView.text = getString(R.string.text) + it.text
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentSongInfoBinding.inflate(inflater, container, false)
        val str = arguments?.getString(Keys.idBundleKey, getString(R.string.idDefaultValue))
        str?.let { viewModel.getSongInfo(it) }
        viewModel.songInfoListLiveData.observe(viewLifecycleOwner, songInfoObserver)
        return binding.root


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding=null
    }

}