package com.example.newsapp.data.remote.mapppers

import com.example.newsapp.data.DomainMapper
import com.example.newsapp.data.remote.dtos.NewList.ArticlesDto
import com.example.newsapp.domain.model.NewsList

class NewsMapper(private val sourceMapper: SourceMapper) :
    DomainMapper<List<ArticlesDto>, List<NewsList>> {
    override fun mapToDomainModel(data: List<ArticlesDto>): List<NewsList> {
        return data.map { articleDto ->
            NewsList(
                source = sourceMapper.mapToDomainModel(articleDto.source),
                author = articleDto.author,
                title = articleDto.title,
                description = articleDto.description,
                imageUrl = articleDto.urlToImage,
                publishAt = articleDto.publishedAt
            )
        }
    }

}