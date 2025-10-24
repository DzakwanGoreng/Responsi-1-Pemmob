package com.example.responsi1mobileh1d023094.ui.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.responsi1mobileh1d023094.data.model.Player
import com.example.responsi1mobileh1d023094.databinding.ItemPlayerBinding

class PlayerAdapter(
    private val players: List<Player>,
    private val onPlayerClick: (Player) -> Unit
) : RecyclerView.Adapter<PlayerAdapter.PlayerViewHolder>() {

    inner class PlayerViewHolder(private val binding: ItemPlayerBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(player: Player) {
            binding.tvPlayerName.text = player.name
            binding.tvPlayerPosition.text = player.position

            // Set background color based on position
            val backgroundColor = when {
                player.position.contains("Goalkeeper", ignoreCase = true) ->
                    Color.parseColor("#FFEB3B") // Yellow
                player.position.contains("Defence", ignoreCase = true) ||
                        player.position.contains("Defender", ignoreCase = true) ->
                    Color.parseColor("#2196F3") // Blue
                player.position.contains("Midfield", ignoreCase = true) ->
                    Color.parseColor("#4CAF50") // Green
                player.position.contains("Offence", ignoreCase = true) ||
                        player.position.contains("Forward", ignoreCase = true) ||
                        player.position.contains("Attacker", ignoreCase = true) ->
                    Color.parseColor("#F44336") // Red
                else -> Color.parseColor("#9E9E9E") // Gray for unknown
            }

            binding.cardPlayer.setCardBackgroundColor(backgroundColor)

            // Set click listener
            binding.cardPlayer.setOnClickListener {
                onPlayerClick(player)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlayerViewHolder {
        val binding = ItemPlayerBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return PlayerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PlayerViewHolder, position: Int) {
        holder.bind(players[position])
    }

    override fun getItemCount() = players.size
}