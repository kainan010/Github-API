package com.naniak.githubapi.api

import com.naniak.githubapi.datamodel.GitResponseModel
import retrofit2.Response
import retrofit2.http.GET

interface GitApi {
    @GET("repositories?q=language:kotlin&sort=stars&page=1")
    suspend fun getRepositoryGithub(): Response<GitResponseModel>
}