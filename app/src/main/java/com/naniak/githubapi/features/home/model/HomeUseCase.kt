package com.naniak.githubapi.features.home.model

import ResponseApi
import com.naniak.githubapi.datamodel.GitResponseModel
import com.naniak.githubapi.datamodel.Item
import com.naniak.githubapi.features.home.repository.HomeRepository

class HomeUseCase {
    private val homeRepository = HomeRepository()

   /* suspend fun getRepositoryGithub(): ResponseApi {
        return when (val responseApi = homeRepository.getRepositoryGithub()) {
            is ResponseApi.Success -> {
                val data = responseApi.data as Item

                ResponseApi.Success(data)
            }
            is ResponseApi.Error -> {
                responseApi
            }

            else -> responseApi
        }
    }*/
    suspend fun getRepositoryGithub() =
        homeRepository.getRepositoryGithub()

}