package com.naniak.githubapi.features.home.viewmodel

import BaseViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.naniak.githubapi.datamodel.GitResponseModel
import com.naniak.githubapi.datamodel.Item
import com.naniak.githubapi.features.home.model.HomeUseCase
import kotlinx.coroutines.launch

class HomeViewModel():BaseViewModel() {
    private val homeUseCase = HomeUseCase()

    private val _onSuccessRepositoryGithub: MutableLiveData<List<GitResponseModel>> =
        MutableLiveData()
    val onSuccessRepositoryGithub: LiveData<List<GitResponseModel>>
        get() = _onSuccessRepositoryGithub

    private val _onErrorRepositoryGithub: MutableLiveData<Int> =
        MutableLiveData()
    val onErrorRepositoryGithub: LiveData<Int>
        get() = _onErrorRepositoryGithub

    fun getRepositoryGithub() {
        viewModelScope.launch {
           this@HomeViewModel.callApi(
                suspend { homeUseCase.getRepositoryGithub() },
                onSuccess = {
                    _onSuccessRepositoryGithub.postValue(
                        it as List<GitResponseModel>
                    )
                }
            )
        }
    }
}