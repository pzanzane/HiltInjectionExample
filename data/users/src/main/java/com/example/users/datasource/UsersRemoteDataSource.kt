package com.example.users.datasource

import com.example.users.repository.User
import com.example.users.retrofit.UsersRestClient
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

class UsersRemoteDataSource(private val usersRestClient: UsersRestClient,
                            private val ioDispatcher: CoroutineDispatcher
) : IUsersRemoteDataSource {
    override suspend fun userList(page: Int): DataSourceResult<List<User>> {

        return withContext(ioDispatcher) {

            val responseUsers = usersRestClient.userList(page)
            if (responseUsers.isSuccessful) {
                responseUsers.body()?.let {
                    return@withContext SuccessDataSourceResult(it.data)
                } ?: SuccessDataSourceResult<List<User>>(emptyList())

            }
            return@withContext ErrorDataSourceResult(responseUsers.code())
        }
    }
}