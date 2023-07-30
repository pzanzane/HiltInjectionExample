package com.example.users.datasource

import com.example.users.repository.User

interface IUsersRemoteDataSource {
    suspend fun userList(page: Int): DataSourceResult<List<User>>
}