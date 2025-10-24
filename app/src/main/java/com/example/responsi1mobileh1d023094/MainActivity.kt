package com.example.responsi1mobileh1d023094

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.lifecycleScope
import com.example.responsi1mobileh1d023094.data.model.TeamResponse
import com.example.responsi1mobileh1d023094.data.repository.TeamRepository
import com.example.responsi1mobileh1d023094.databinding.ActivityMainBinding
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val repository = TeamRepository()
    private var teamData: TeamResponse? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupUI()
        loadTeamData()
    }

    private fun setupUI() {
        binding.btnClubHistory.setOnClickListener {

            teamData?.let { data ->
                val intent = Intent(this, HistoryActivity::class.java)
                intent.putExtra("CLUB_NAME", data.name)
                intent.putExtra("CLUB_FOUNDED", data.founded)
                intent.putExtra("CLUB_VENUE", data.venue)
                startActivity(intent)
            }
        }

        binding.btnHeadCoach.setOnClickListener {
            teamData?.let { data ->
                val intent = Intent(this, CoachActivity::class.java)
                intent.putExtra("COACH_NAME", data.coach.name)
                intent.putExtra("COACH_DOB", data.coach.dateOfBirth)
                intent.putExtra("COACH_NATIONALITY", data.coach.nationality)
                startActivity(intent)
            }
        }

        binding.btnTeamSquad.setOnClickListener {
            val intent = Intent(this, TeamSquadActivity::class.java)
            startActivity(intent)
        }
    }

    private fun loadTeamData() {
        binding.progressBar.visibility = View.VISIBLE

        lifecycleScope.launch {
            repository.getTeamData()
                .onSuccess { data ->
                    teamData = data
                    updateUI(data)
                    binding.progressBar.visibility = View.GONE
                }
                .onFailure { error ->
                    binding.progressBar.visibility = View.GONE
                    Toast.makeText(
                        this@MainActivity,
                        "Error: ${error.message}",
                        Toast.LENGTH_LONG
                    ).show()
                }
        }
    }

    private fun updateUI(data: TeamResponse) {
        binding.tvClubName.text = data.name
        binding.tvClubInfo.text = buildString {
            append("${data.name}, also known as ${data.shortName}, ")
            append("is a professional football club based in ${data.address}. ")
            append("Founded in ${data.founded}, the club plays its home matches at ${data.venue}.")
        }
    }
}