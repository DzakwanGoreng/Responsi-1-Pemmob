package com.example.responsi1mobileh1d023094.data.repository

import com.example.responsi1mobileh1d023094.data.api.RetrofitClient
import com.example.responsi1mobileh1d023094.data.model.TeamResponse

class TeamRepository {
    private val apiService = RetrofitClient.instance

    private val apiToken = "49030eba420e4a39b34952ac707f11dd"
    private val qprTeamId = 69

    suspend fun getTeamData(): Result<TeamResponse> {
        return try {
            val response = apiService.getTeam(qprTeamId, apiToken)
            Result.success(response)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}