package com.example.newsapp.data.remote.dtos.NewList

import com.google.gson.annotations.SerializedName

data class TopStoriesDtos(
    @SerializedName("meta" ) var meta : Meta?           = Meta(),
    @SerializedName("data" ) var data : ArrayList<Data> ?= arrayListOf()
)

data class Meta (

    @SerializedName("found"    ) var found    : Int? = null,
    @SerializedName("returned" ) var returned : Int? = null,
    @SerializedName("limit"    ) var limit    : Int? = null,
    @SerializedName("page"     ) var page     : Int? = null

)

data class Data (

    @SerializedName("uuid"            ) var uuid           : String?           = null,
    @SerializedName("title"           ) var title          : String?           = null,
    @SerializedName("description"     ) var description    : String?           = null,
    @SerializedName("keywords"        ) var keywords       : String?           = null,
    @SerializedName("snippet"         ) var snippet        : String?           = null,
    @SerializedName("url"             ) var url            : String?           = null,
    @SerializedName("image_url"       ) var imageUrl       : String?           = null,
    @SerializedName("language"        ) var language       : String?           = null,
    @SerializedName("published_at"    ) var publishedAt    : String?           = null,
    @SerializedName("source"          ) var source         : String?           = null,
    @SerializedName("categories"      ) var categories     : ArrayList<String> = arrayListOf(),
    @SerializedName("relevance_score" ) var relevanceScore : String?           = null,
    @SerializedName("locale"          ) var locale         : String?           = null

)
