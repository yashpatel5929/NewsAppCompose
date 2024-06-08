package com.example.newsapp.domain.repositories

import com.example.newsapp.domain.model.NewsList
import com.example.newsapp.utils.Resource

interface NewsRepositories {
    suspend fun getAllNews() : Resource<List<NewsList>>
}