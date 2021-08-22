package com.naniak.githubapi.features.home.model

import ResponseApi
import com.naniak.githubapi.datamodel.Item
import com.naniak.githubapi.features.home.repository.HomeRepository

class HomeUseCase {
    private val homeRepository = HomeRepository()

   /* suspend fun getRepositoryGithub(): ResponseApi {
        return when (val responseApi = homeRepository.getRepositoryGithub()) {
            is ResponseApi.Success -> {
                val data = responseApi.data as? Item
                val result = data.let {
                        it?.forks?.toString() = it?.forks
                  *//*  it.backdrop_path = it.backdrop_path.getFullImageUrl()
                    it.poster_path = it.poster_path.getFullImageUrl()
                    it*//*
                }
                ResponseApi.Success(result)
            }
            is ResponseApi.Error -> {
                responseApi
            }
        }
    }*/
    suspend fun getRepositoryGithub() =
        homeRepository.getRepositoryGithub()

}