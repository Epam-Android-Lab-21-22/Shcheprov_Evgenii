package com.example.shcheprov_homeworks.rightscreen.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.shcheprov_homeworks.databinding.FragmentRightItemBinding
import com.example.shcheprov_homeworks.rightscreen.entities.RightScreenRecyclerViewItem


class RightScreenRecyclerViewAdapter :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val items: MutableList<RightScreenRecyclerViewItem> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ViewHolder(
            FragmentRightItemBinding.inflate(
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

    fun updateList(list: List<RightScreenRecyclerViewItem>) {
        val diffResult = DiffUtil.calculateDiff(RightScreenListDiffUtilCallBack(items, list))
        items.clear()
        items.addAll(list)
        diffResult.dispatchUpdatesTo(this)
    }

    override fun getItemCount(): Int {
        return items.count()
    }


    class ViewHolder(
        private val binding: FragmentRightItemBinding,
    ) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: RightScreenRecyclerViewItem) {
            binding.apply {
                rightItemImageView.setImageDrawable(
                    ResourcesCompat.getDrawable(
                        binding.root.resources,
                        item.iconId,
                        null
                    )
                )
                rightItemTextView.text = binding.root.context.getString(item.textId)

            }
        }
    }

}