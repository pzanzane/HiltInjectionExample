package com.example.hiltinjectionexample.repository

import com.example.hiltinjectionexample.datasource.ErrorDataSourceResult
import com.example.hiltinjectionexample.datasource.SuccessDataSourceResult
import com.example.hiltinjectionexample.datasource.users.IUsersRemoteDataSource
import com.example.hiltinjectionexample.datasource.users.User
import com.example.hiltinjectionexample.datasource.users.UsersRemoteDataSource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

class UsersRepository(val remoteDataSource: IUsersRemoteDataSource,
val ioDispatcher: CoroutineDispatcher) {

    suspend fun userList(page: Int): RepositoryResult<List<User>> {

        return withContext(ioDispatcher) {
            val datasourceResult = remoteDataSource.userList(page)

            if (datasourceResult is SuccessDataSourceResult) {
                return@withContext SuccessRepositoryResult<List<User>>(datasourceResult.data)
            }

            val errorResult = datasourceResult as ErrorDataSourceResult
            return@withContext ErrorRepositoryResult(errorResult.message)
        }
    }
}