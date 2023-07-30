package com.example.hiltinjectionexample.datasource.retrofit

import com.example.hiltinjectionexample.constants.API_USERS_LIST
import com.example.hiltinjectionexample.constants.QUERY_PARAM
import com.example.hiltinjectionexample.datasource.users.ResponseUsers
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query


interface UsersRestClient {

    @GET(API_USERS_LIST)
    suspend fun userList(@Query(QUERY_PARAM) page: Int): Response<ResponseUsers>
}