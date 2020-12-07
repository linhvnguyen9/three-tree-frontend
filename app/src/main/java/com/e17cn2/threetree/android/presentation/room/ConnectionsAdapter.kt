package com.e17cn2.threetree.android.presentation.room

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.e17cn2.threetree.android.databinding.ItemPlayerBinding
import com.e17cn2.threetree.android.databinding.ItemPlayerRoundBinding
import com.e17cn2.threetree.android.databinding.ItemRoomBinding
import com.e17cn2.threetree.entity.Connection
import com.e17cn2.threetree.entity.PlayerRound
import com.e17cn2.threetree.entity.Room

class ConnectionsAdapter() : ListAdapter<Connection, ConnectionsAdapter.ConnectionViewHolder>(ConnectionDiffUtil()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ConnectionViewHolder =
        ConnectionViewHolder.from(parent)

    override fun onBindViewHolder(holder: ConnectionViewHolder, position: Int) {
        val item = getItem(position)
        if (item != null) {
            holder.bind(item)
        }
    }

    class ConnectionViewHolder(private val binding: ItemPlayerBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Connection) {
            binding.item = item
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): ConnectionViewHolder {
                val inflater = LayoutInflater.from(parent.context)
                val binding = ItemPlayerBinding.inflate(inflater, parent, false)
                return ConnectionViewHolder(binding)
            }
        }
    }
}

class ConnectionDiffUtil : DiffUtil.ItemCallback<Connection>() {
    override fun areItemsTheSame(oldItem: Connection, newItem: Connection) = oldItem.playerId == newItem.playerId

    override fun areContentsTheSame(oldItem: Connection, newItem: Connection) = oldItem == newItem
}