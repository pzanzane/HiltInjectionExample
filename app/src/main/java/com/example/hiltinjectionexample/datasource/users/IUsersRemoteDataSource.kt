package com.example.hiltinjectionexample.datasource.users

import com.example.hiltinjectionexample.datasource.DataSourceResult

interface IUsersRemoteDataSource {
    suspend fun userList(page: Int): DataSourceResult<List<User>>
}