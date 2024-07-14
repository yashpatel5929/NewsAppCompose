package com.example.newsapp.domain.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class NewsCategories(
    @StringRes val categoryName : Int?,
    val categoryId : Int?,
    @DrawableRes val categoryImage : Int?
)
