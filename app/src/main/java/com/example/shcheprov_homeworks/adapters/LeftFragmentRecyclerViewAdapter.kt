package com.example.shcheprov_homeworks.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.shcheprov_homeworks.LeftFragmentRecyclerViewItem
import com.example.shcheprov_homeworks.databinding.FragmentLeftDefaultItemBinding
import com.example.shcheprov_homeworks.databinding.FragmentLeftRemovableItemBinding
import com.example.shcheprov_homeworks.databinding.FragmentLeftTitleItemBinding
import com.example.shcheprov_homeworks.entities.LeftViewHolder
import com.example.shcheprov_homeworks.entities.leftItemViewType


class LeftFragmentRecyclerViewAdapter :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val items: MutableList<LeftFragmentRecyclerViewItem> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when(viewType){
            leftItemViewType.TYPE_TITLE_ITEM.numberType-> TitleViewHolder(
                FragmentLeftTitleItemBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
           leftItemViewType.TYPE_DEFAULT_ITEM.numberType-> DefaultViewHolder(
               FragmentLeftDefaultItemBinding.inflate(
                   LayoutInflater.from(parent.context),
                   parent,
                   false
               )
           )
            leftItemViewType.TYPE_REMOVABLE_ITEM.numberType->RemovableViewHolder(
                FragmentLeftRemovableItemBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
            else -> throw IllegalStateException("WRONG VIEW TYPE")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if(holder is LeftViewHolder) holder.bind(items[position])
    }

    override fun getItemViewType(position: Int): Int {
        return items[position].viewType.numberType

    }

    override fun getItemCount(): Int {
       return items.count()
    }

    fun updateList(list: List<LeftFragmentRecyclerViewItem>) {
        items.clear()
        items.addAll(list)
        notifyDataSetChanged()
    }


    class TitleViewHolder(private val binding: FragmentLeftTitleItemBinding) :
        RecyclerView.ViewHolder(binding.root),LeftViewHolder {
        override fun bind(item: LeftFragmentRecyclerViewItem) {
            binding.titleTextView.text=item.text
        }
    }
    inner class RemovableViewHolder(private val binding: FragmentLeftRemovableItemBinding) :
        RecyclerView.ViewHolder(binding.root),LeftViewHolder {
        override fun bind(item: LeftFragmentRecyclerViewItem) {
            binding.apply {
                removableItemTextView.text=item.text
                buttonRemoveItem.setOnClickListener {
                    items.removeAt(adapterPosition)
                    notifyItemRemoved(adapterPosition)

                }
            }
        }
    }
    class DefaultViewHolder(private val binding: FragmentLeftDefaultItemBinding) :
        RecyclerView.ViewHolder(binding.root),LeftViewHolder {
        override fun bind(item: LeftFragmentRecyclerViewItem) {
            binding.defaultItemTextView.text=item.text
        }
    }
}