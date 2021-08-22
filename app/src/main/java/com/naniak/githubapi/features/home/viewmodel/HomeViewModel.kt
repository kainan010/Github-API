package com.naniak.githubapi.features.home.viewmodel

import BaseViewModel
import ResponseApi
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.naniak.githubapi.datamodel.GitResponseModel
import com.naniak.githubapi.datamodel.Item
import com.naniak.githubapi.features.home.model.HomeUseCase
import kotlinx.coroutines.launch

class HomeViewModel():BaseViewModel() {
    private val homeUseCase = HomeUseCase()

    private val _onSuccessRepositoryGithub: MutableLiveData<GitResponseModel> =
        MutableLiveData()
    val onSuccessRepositoryGithub: LiveData<GitResponseModel>
        get() = _onSuccessRepositoryGithub

    private val _onErrorRepositoryGithub: MutableLiveData<Int> =
        MutableLiveData()
    val onErrorRepositoryGithub: LiveData<Int>
        get() = _onErrorRepositoryGithub

    fun getRepositoryGithub() {
        viewModelScope.launch {
            this@HomeViewModel.callApi(
                call = { homeUseCase.getRepositoryGithub()},
                onSuccess = { _onSuccessRepositoryGithub.postValue(it as GitResponseModel) }
            )
        }
    }
}