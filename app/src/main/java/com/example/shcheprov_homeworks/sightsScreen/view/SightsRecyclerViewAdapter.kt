package com.example.shcheprov_homeworks.sightsScreen.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.shcheprov_homeworks.databinding.*
import com.example.shcheprov_homeworks.sightsScreen.entities.Sight
import com.example.shcheprov_homeworks.sightsScreen.entities.SightsType

class SightsRecyclerViewAdapter(private val deleteItem: (Int) -> Unit) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val items: MutableList<Sight> = mutableListOf()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            SightsType.TYPE_TITLE.numberType-> TitleViewHolder(
                SightsRecyclerviewTitleItemBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
            SightsType.TYPE_REQUIRED.numberType -> DefaultViewHolder(
                SightsRecyclerviewDefaultItemBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
            SightsType.TYPE_OPTIONAL.numberType -> RemovableViewHolder(
                SightsRecyclerviewRemovableItemBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                ), deleteItem = deleteItem
            )
            else -> throw IllegalStateException("WRONG VIEW TYPE")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is ISightsViewHolder) holder.bind(items[position])
    }

    override fun getItemViewType(position: Int): Int {
        return items[position].type.numberType
    }

    override fun getItemCount(): Int {
        return items.count()
    }

    fun updateList(list: List<Sight>) {
        val diffResult = DiffUtil.calculateDiff(SightsRecyclerViewDiffUtilCallback(items, list))
        items.clear()
        items.addAll(list)
        diffResult.dispatchUpdatesTo(this)

    }

    class TitleViewHolder(private val binding: SightsRecyclerviewTitleItemBinding) :
        RecyclerView.ViewHolder(binding.root), ISightsViewHolder {
        override fun bind(item: Sight) {
            binding.titleTextView.text = item.text
        }
    }

    inner class RemovableViewHolder(
        private val binding: SightsRecyclerviewRemovableItemBinding,
        private val deleteItem: (Int) -> Unit
    ) :
        RecyclerView.ViewHolder(binding.root), ISightsViewHolder {
        override fun bind(item: Sight) {
            binding.apply {
                removableItemTextView.text = item.text
                buttonRemoveItem.setOnClickListener {
                    deleteItem(adapterPosition)
                }
            }
        }
    }

    class DefaultViewHolder(private val binding: SightsRecyclerviewDefaultItemBinding) :
        RecyclerView.ViewHolder(binding.root), ISightsViewHolder {
        override fun bind(item: Sight) {
            binding.defaultItemTextView.text = item.text
        }
    }
}