package com.example.users.retrofit

import com.example.users.constants.API_USERS_LIST
import com.example.users.constants.QUERY_PARAM
import com.example.users.repository.ResponseUsers
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface UsersRestClient {

    @GET(API_USERS_LIST)
    suspend fun userList(@Query(QUERY_PARAM) page: Int): Response<ResponseUsers>
}