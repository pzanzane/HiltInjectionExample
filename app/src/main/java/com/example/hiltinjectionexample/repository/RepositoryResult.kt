package com.example.hiltinjectionexample.repository

sealed interface RepositoryResult<T>
class SuccessRepositoryResult<T>(val data: T): RepositoryResult<T>
class ErrorRepositoryResult<T>(val message: String?): RepositoryResult<T>
