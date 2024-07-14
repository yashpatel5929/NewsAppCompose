package com.example.newsapp.data.remote.mapppers

import com.example.newsapp.data.DomainMapper
import com.example.newsapp.data.remote.dtos.NewList.Data
import com.example.newsapp.data.remote.dtos.NewList.TopStoriesDtos
import com.example.newsapp.domain.model.TopStoriesModel

class TopStoriesMapper : DomainMapper<List<Data> , List<TopStoriesModel>> {
    override fun mapToDomainModel(data: List<Data>): List<TopStoriesModel> {
        return data.map {topStories ->
            TopStoriesModel(
                source = topStories.source,
                title = topStories.title,
                description =  topStories.description,
                imageUrl = topStories.imageUrl,
                publishAt = topStories.publishedAt
            )

        }
    }
}