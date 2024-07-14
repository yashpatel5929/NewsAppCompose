package com.example.newsapp.domain.usecases

import com.example.newsapp.domain.model.NewsCategories
import com.example.newsapp.domain.model.NewsList
import com.example.newsapp.domain.repositories.NewsRepositories
import com.example.newsapp.utils.Resource

class NewsUseCase(
    val newsRepositories: NewsRepositories
) {

    suspend operator fun invoke(): Resource<List<NewsList>> {
        return newsRepositories.getAllNews()
    }

    suspend fun getNewsCategories() : Resource<List<NewsCategories>> {
        return newsRepositories.getNewCategories()
    }

}