package com.example.hiltinjectionexample.datasource.users

data class ResponseUsers(val data: List<User>)

data class User(val id: Int, val email: String)