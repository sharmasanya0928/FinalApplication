package com.example.finalapplication

import java.io.Serializable

// Entity class implementing Serializable to pass between activities
data class Entity(
    val property1: String,
    val property2: String,
    val description: String,
    val imageResId: Int // Resource ID for the drawable image
) : Serializable
