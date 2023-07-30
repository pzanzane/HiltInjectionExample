package com.example.hiltinjectionexample.repository

sealed interface RepositoryResult
class SuccessRepositoryResult<T>(val data: T): RepositoryResult
class ErrorRepositoryResult(val message: String?): RepositoryResult
