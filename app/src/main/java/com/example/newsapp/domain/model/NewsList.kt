package com.example.newsapp.domain.model

data class NewsList(
    val source: Source?,
    val author : String?,
    val title : String?,
    val description : String?,
    val imageUrl : String?,
    val publishAt : String?
)

data class Source(
    val name : String?
)
