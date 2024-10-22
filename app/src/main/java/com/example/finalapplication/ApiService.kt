package com.example.finalapplication

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ApiService {
    // Login endpoint
    @POST("/sydney/auth")  // Removed extra space
    fun login(@Body loginRequest: LoginRequest): Call<LoginResponse>

    // Dashboard endpoint
    @GET("/dashboard/{keypass}")
    fun getDashboard(@Path("keypass") keypass: String): Call<DashboardResponse>
}
