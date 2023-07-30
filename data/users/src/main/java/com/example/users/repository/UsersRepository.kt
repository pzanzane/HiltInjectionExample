package com.example.users.repository

import com.example.users.datasource.ErrorDataSourceResult
import com.example.users.datasource.IUsersRemoteDataSource
import com.example.users.datasource.SuccessDataSourceResult
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

class UsersRepository(private val remoteDataSource: IUsersRemoteDataSource,
                      private val ioDispatcher: CoroutineDispatcher) : IUsersRepository {

    override suspend fun userList(page: Int): RepositoryResult<List<User>> {

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