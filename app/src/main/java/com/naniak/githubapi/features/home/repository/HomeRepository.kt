package com.naniak.githubapi.features.home.repository

import BaseRepository
import ResponseApi
import com.naniak.githubapi.api.GitService

class HomeRepository : BaseRepository()  {

    suspend fun getRepositoryGithub(page : Int): ResponseApi {
        return safeApiCall {
            GitService.gitApi.getRepositoryGithub(page)
        }
    }

}