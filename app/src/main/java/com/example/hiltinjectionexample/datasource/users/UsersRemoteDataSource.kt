package com.example.hiltinjectionexample.datasource.users

import com.example.hiltinjectionexample.datasource.retrofit.UsersRestClient

class UsersRemoteDataSource(private val usersRestClient: UsersRestClient) {

    suspend fun userList(page: Int) {
        usersRestClient.userList(page)
    }
}