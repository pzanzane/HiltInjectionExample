package com.example.hiltinjectionexample.datasource

sealed interface DataSourceResult<T>
class SuccessDataSourceResult<T>(val data: T) : DataSourceResult<T>
class ErrorDataSourceResult<T>(val errorCode: kotlin.Int, val message: String? = null) :
    DataSourceResult<T>

