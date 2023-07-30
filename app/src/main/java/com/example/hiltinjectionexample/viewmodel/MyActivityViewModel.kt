package com.example.hiltinjectionexample.viewmodel

import androidx.lifecycle.ViewModel
import com.example.users.repository.IUsersRepository
import com.example.users.repository.UsersRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

class MyActivityViewModel(private val usersRepository: IUsersRepository,
private val iosDispatcher: CoroutineDispatcher): ViewModel() {

    suspend fun fetchUsers(page: Int) {

        withContext(iosDispatcher) {
            usersRepository.userList(page)
        }
    }
}