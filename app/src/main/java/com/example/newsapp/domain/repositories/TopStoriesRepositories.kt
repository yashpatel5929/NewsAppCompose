package com.example.newsapp.domain.repositories

import com.example.newsapp.domain.model.TopStoriesModel
import com.example.newsapp.utils.Resource

interface TopStoriesRepositories {
    suspend fun getTopStories() : Resource<List<TopStoriesModel>>
}