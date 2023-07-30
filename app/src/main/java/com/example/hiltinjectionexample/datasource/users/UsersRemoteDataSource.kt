package com.example.hiltinjectionexample.datasource.users

import com.example.hiltinjectionexample.datasource.DataSourceResult
import com.example.hiltinjectionexample.datasource.ErrorDataSourceResult
import com.example.hiltinjectionexample.datasource.SuccessDataSourceResult
import com.example.hiltinjectionexample.datasource.retrofit.UsersRestClient
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

class UsersRemoteDataSource(private val usersRestClient: UsersRestClient,
                            val ioDispatcher: CoroutineDispatcher
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