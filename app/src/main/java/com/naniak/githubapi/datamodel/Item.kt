package com.naniak.githubapi.datamodel

import com.google.gson.annotations.SerializedName

data class Item(
    val forks: Int,
    val name: String,
    val owner: Owner,
    @SerializedName(value = "stargazers_count")
    val stargazersCount: Int
)