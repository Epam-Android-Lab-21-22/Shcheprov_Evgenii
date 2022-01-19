package com.example.shcheprov_homeworks.districtScreen.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.shcheprov_homeworks.databinding.DistrictRecyclerviewItemBinding
import com.example.shcheprov_homeworks.districtScreen.entities.District


class DistrictRecyclerViewAdapter :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val items: MutableList<District> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ViewHolder(
            DistrictRecyclerviewItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is ViewHolder) {
            holder.bind(items[position])
        }
    }

    fun updateList(list: List<District>) {
        val diffResult = DiffUtil.calculateDiff(DistrictRecyclerViewDiffUtilCallBack(items, list))
        items.clear()
        items.addAll(list)
        diffResult.dispatchUpdatesTo(this)
    }

    override fun getItemCount(): Int {
        return items.count()
    }

    class ViewHolder(
        private val binding: DistrictRecyclerviewItemBinding,
    ) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: District) {
            binding.apply {
                districtImageView.setImageDrawable(
                    ResourcesCompat.getDrawable(
                        binding.root.resources,
                        item.iconId,
                        null
                    )
                )
                districtTextView.text = binding.root.context.getString(item.textId)
            }
        }
    }

}