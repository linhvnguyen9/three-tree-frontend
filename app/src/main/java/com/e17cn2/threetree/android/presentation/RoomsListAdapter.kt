package com.e17cn2.threetree.android.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.e17cn2.threetree.android.databinding.ItemRoomBinding
import com.e17cn2.threetree.entity.Room

class RoomsListAdapter : ListAdapter<Room, RoomsListAdapter.RoomViewHolder>(RoomListDiffUtil()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RoomViewHolder =
        RoomViewHolder.from(parent)

    override fun onBindViewHolder(holder: RoomViewHolder, position: Int) {
        val item = getItem(position)
        if (item != null) {
            holder.bind(item)
        }
    }

    class RoomViewHolder(private val binding: ItemRoomBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Room) {
            binding.item = item
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): RoomViewHolder {
                val inflater = LayoutInflater.from(parent.context)
                val binding = ItemRoomBinding.inflate(inflater, parent, false)
                return RoomViewHolder(binding)
            }
        }
    }
}

class RoomListDiffUtil : DiffUtil.ItemCallback<Room>() {
    override fun areItemsTheSame(oldItem: Room, newItem: Room) = oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: Room, newItem: Room) = oldItem == newItem
}