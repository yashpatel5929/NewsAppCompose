package com.example.newsapp.data.repositories

import com.example.newsapp.data.local.GetNewsListData
import com.example.newsapp.data.remote.dtos.NewList.NewsListResponse
import com.example.newsapp.data.remote.mapppers.NewsMapper
import com.example.newsapp.domain.model.NewsList
import com.example.newsapp.domain.repositories.NewsRepositories
import com.example.newsapp.utils.Resource

class NewsRepositoriesImpl(private val newsMapper: NewsMapper,private val newsListData: GetNewsListData) : NewsRepositories {
    override suspend fun getAllNews(): Resource<List<NewsList>> {
        val response : NewsListResponse =  newsListData.getNewList()
        return if(response.status.equals("ok",true)){
            Resource.Success(newsMapper.mapToDomainModel(response.articles))
        }else {
            Resource.Error(message = "Something went wrong")
        }

    }
}