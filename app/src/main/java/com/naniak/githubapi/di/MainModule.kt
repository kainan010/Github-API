package com.naniak.githubapi.di


import com.naniak.githubapi.features.home.repository.HomeRepository
import com.naniak.githubapi.features.home.viewmodel.HomeViewModel
import org.koin.android.experimental.dsl.viewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module


val mainModule = module {

    viewModel{
        HomeViewModel( )
    }
}