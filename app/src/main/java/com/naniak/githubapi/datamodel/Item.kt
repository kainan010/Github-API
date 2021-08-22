package com.naniak.githubapi.datamodel

data class Item(
    val forks: Int,
    val name: String,
    val owner: Owner,
    val stargazersCount: Int
)