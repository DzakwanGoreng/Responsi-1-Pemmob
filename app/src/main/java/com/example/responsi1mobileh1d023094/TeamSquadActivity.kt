package com.example.responsi1mobileh1d023094

import android.app.Dialog
import android.os.Bundle
import android.view.View
import android.view.Window
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.responsi1mobileh1d023094.data.model.Player
import com.example.responsi1mobileh1d023094.data.repository.TeamRepository
import com.example.responsi1mobileh1d023094.databinding.ActivityTeamSquadBinding
import com.example.responsi1mobileh1d023094.ui.adapter.PlayerAdapter
import kotlinx.coroutines.launch

class TeamSquadActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTeamSquadBinding
    private val repository = TeamRepository()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTeamSquadBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnBack.setOnClickListener {
            finish()
        }

        loadPlayers()
    }

    private fun loadPlayers() {
        binding.progressBar.visibility = View.VISIBLE

        lifecycleScope.launch {
            repository.getTeamData()
                .onSuccess { data ->
                    binding.progressBar.visibility = View.GONE
                    val adapter = PlayerAdapter(data.squad) { player -> showPlayerDialog(player)
                    }
                    binding.rvPlayers.layoutManager = LinearLayoutManager(this@TeamSquadActivity)
                    binding.rvPlayers.adapter = adapter
                }
                .onFailure { error ->
                    binding.progressBar.visibility = View.GONE
                    Toast.makeText(
                        this@TeamSquadActivity,
                        "Error: ${error.message}",
                        Toast.LENGTH_LONG
                    ).show()
                }
        }
    }

    private fun showPlayerDialog(player: Player) {
        val dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(R.layout.dialog_player_detail)
        dialog.window?.setBackgroundDrawableResource(android.R.color.white)

        val tvPlayerName = dialog.findViewById<TextView>(R.id.tvDialogPlayerName)
        val tvPlayerDob = dialog.findViewById<TextView>(R.id.tvDialogPlayerDob)
        val tvPlayerCountry = dialog.findViewById<TextView>(R.id.tvDialogPlayerCountry)
        val tvPlayerPosition = dialog.findViewById<TextView>(R.id.tvDialogPlayerPosition)

        tvPlayerName.text = player.name
        tvPlayerDob.text = player.dateOfBirth
        tvPlayerCountry.text = player.nationality
        tvPlayerPosition.text = player.position

        dialog.show()
    }
}