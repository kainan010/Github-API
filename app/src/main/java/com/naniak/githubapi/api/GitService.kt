package com.naniak.githubapi.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object GitService {

    val gitApi: GitApi = getGitApiClient().create(GitApi::class.java)

    const val URL = "https://api.github.com/search/"

    fun getGitApiClient(): Retrofit =
        Retrofit.Builder()
            .baseUrl(URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
}