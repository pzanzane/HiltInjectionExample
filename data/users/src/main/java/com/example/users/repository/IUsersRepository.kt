package com.example.users.repository

interface IUsersRepository {
    suspend fun userList(page: Int): RepositoryResult<List<User>>
}