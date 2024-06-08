package com.example.newsapp.data.remote.dtos.NewList

import com.google.gson.annotations.SerializedName

data class NewsListResponse(
    @SerializedName("status") var status: String? = null,
    @SerializedName("totalResults") var totalResults: Int? = null,
    @SerializedName("articles") var articles: ArrayList<ArticlesDto> = arrayListOf()
)


data class ArticlesDto(

    @SerializedName("source") var source: SourceDto?,
    @SerializedName("author") var author: String? = null,
    @SerializedName("title") var title: String? = null,
    @SerializedName("description") var description: String? = null,
    @SerializedName("url") var url: String? = null,
    @SerializedName("urlToImage") var urlToImage: String? = null,
    @SerializedName("publishedAt") var publishedAt: String? = null,
    @SerializedName("content") var content: String? = null

)

data class SourceDto(
    @SerializedName("id") var id: String? = null,
    @SerializedName("name") var name: String? = null

)