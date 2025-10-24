package com.example.responsi1mobileh1d023094

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.responsi1mobileh1d023094.databinding.ActivityCoachBinding

class CoachActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCoachBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCoachBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val coachName = intent.getStringExtra("COACH_NAME") ?: ""
        val coachDob = intent.getStringExtra("COACH_DOB") ?: ""
        val coachNationality = intent.getStringExtra("COACH_NATIONALITY") ?: ""

        binding.tvCoachName.text = coachName
        binding.tvCoachDob.text = coachDob
        binding.tvCoachNationality.text = coachNationality

        binding.btnBack.setOnClickListener {
            finish()
        }
    }
}