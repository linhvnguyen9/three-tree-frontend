package com.e17cn2.threetree.android.presentation.room

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.e17cn2.threetree.android.databinding.ItemPlayerRoundBinding
import com.e17cn2.threetree.android.databinding.ItemRoomBinding
import com.e17cn2.threetree.entity.PlayerRound
import com.e17cn2.threetree.entity.Room

class PlayerRoundsAdapter() : ListAdapter<PlayerRound, PlayerRoundsAdapter.PlayerRoundsViewHolder>(PlayerRoundsDiffUtil()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlayerRoundsViewHolder =
        PlayerRoundsViewHolder.from(parent)

    override fun onBindViewHolder(holder: PlayerRoundsViewHolder, position: Int) {
        val item = getItem(position)
        if (item != null) {
            holder.bind(item)
        }
    }

    class PlayerRoundsViewHolder(private val binding: ItemPlayerRoundBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: PlayerRound) {
            binding.item = item
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): PlayerRoundsViewHolder {
                val inflater = LayoutInflater.from(parent.context)
                val binding = ItemPlayerRoundBinding.inflate(inflater, parent, false)
                return PlayerRoundsViewHolder(binding)
            }
        }
    }
}

class PlayerRoundsDiffUtil : DiffUtil.ItemCallback<PlayerRound>() {
    override fun areItemsTheSame(oldItem: PlayerRound, newItem: PlayerRound) = oldItem.hashCode() == newItem.hashCode()

    override fun areContentsTheSame(oldItem: PlayerRound, newItem: PlayerRound) = oldItem == newItem
}