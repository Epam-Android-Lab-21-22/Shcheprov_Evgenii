package com.example.shcheprov_homeworks.favoritesongsscreen

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.models.SongPreview
import com.example.shcheprov_homeworks.databinding.SongPreviewRecyclerviewItemBinding
import com.squareup.picasso.Picasso

class FavoriteSongsRecyclerViewAdapter(private val itemOnClick: (String) -> Unit) :
    RecyclerView.Adapter<FavoriteSongsRecyclerViewAdapter.ViewHolder>() {
    private val items: MutableList<SongPreview> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            SongPreviewRecyclerviewItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ), itemOnClick
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int {
        return items.count()
    }

    fun updateList(list: List<SongPreview>) {
        val diffResult = DiffUtil.calculateDiff(SongsPreviewListDiffUtils(items, list))
        items.clear()
        items.addAll(list)
        diffResult.dispatchUpdatesTo(this)

    }


    class ViewHolder(
        private val binding: SongPreviewRecyclerviewItemBinding,
        val itemOnClick: (String) -> Unit
    ) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: SongPreview) {
            binding.coverItemImageView.clipToOutline = true
            binding.titleItemTextView.text = item.title
            binding.performerItemTextView.text = item.performer
            Picasso.get()
                .load(item.coverUrl)
                .into(binding.coverItemImageView)
            binding.root.setOnClickListener { itemOnClick(item.id) }
        }
    }


}