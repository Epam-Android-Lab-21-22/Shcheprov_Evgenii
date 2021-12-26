package com.example.shcheprov_homeworks

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.shcheprov_homeworks.databinding.FragmentRightItemBinding
import com.example.shcheprov_homeworks.entities.RightFragmentRecyclerViewItem


class RightFragmentRecyclerViewAdapter :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val items: MutableList<RightFragmentRecyclerViewItem> = mutableListOf()

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


    override fun getItemCount(): Int {
        return items.count()
    }
    fun addItem(item:RightFragmentRecyclerViewItem){
        items.add(item)
        notifyItemInserted(itemCount)

    }

    fun updateList(list: List<RightFragmentRecyclerViewItem>) {
        items.clear()
        items.addAll(list)
        notifyDataSetChanged()
    }

    inner class ViewHolder(private val binding: FragmentRightItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: RightFragmentRecyclerViewItem) {
            binding.apply {
                rightItemImageView.setImageDrawable(item.icon)
                rightItemTextView.text=item.text
            }
        }
    }

}