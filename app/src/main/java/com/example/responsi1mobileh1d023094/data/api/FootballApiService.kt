package com.example.responsi1mobileh1d023094.data.api

import com.example.responsi1mobileh1d023094.data.model.TeamResponse
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path

interface FootballApiService {
    @GET("teams/{id}")
    suspend fun getTeam(
        @Path("id") teamId: Int,
        @Header("X-Auth-Token") token: String
    ): TeamResponse
}