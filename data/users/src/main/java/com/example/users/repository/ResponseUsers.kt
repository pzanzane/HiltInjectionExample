package com.example.users.repository

data class ResponseUsers(val data: List<User>)

data class User(val id: Int, val email: String)