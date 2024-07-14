package com.example.newsapp.data.repositories

import com.example.newsapp.R
import com.example.newsapp.data.local.GetNewsListData
import com.example.newsapp.data.remote.dtos.NewList.NewsListResponse
import com.example.newsapp.data.remote.mapppers.NewsMapper
import com.example.newsapp.domain.model.NewsCategories
import com.example.newsapp.domain.model.NewsList
import com.example.newsapp.domain.repositories.NewsRepositories
import com.example.newsapp.utils.Resource

class NewsRepositoriesImpl(private val newsMapper: NewsMapper,private val newsListData: GetNewsListData) : NewsRepositories {
    override suspend fun getAllNews(): Resource<List<NewsList>> {
        val response : NewsListResponse =  newsListData.getNewList()
        return if(response.status.equals("ok",true)){
            Resource.Success(newsMapper.mapToDomainModel(response.articles))
        }else {
            Resource.Error(errorMessage = R.string.error_something_went_wrong)
        }

    }

    override suspend fun getNewCategories(): Resource<List<NewsCategories>> {
        val categoriesList = listOf(
            NewsCategories(categoryName = R.string.category_sports , categoryId = 1 , categoryImage = R.drawable.baseline_sports_cricket_24),
            NewsCategories(categoryName = R.string.category_entertainment , categoryId = 1 , categoryImage = R.drawable.baseline_theater_comedy_24),
            NewsCategories(categoryName = R.string.category_technology , categoryId = 1 , categoryImage = R.drawable.baseline_computer_24),
            NewsCategories(categoryName = R.string.category_health , categoryId = 1 , categoryImage = R.drawable.baseline_health_and_safety_24),
            NewsCategories(categoryName = R.string.category_business , categoryId = 1 , categoryImage = R.drawable.baseline_business_24),
            NewsCategories(categoryName = R.string.category_science , categoryId = 1 , categoryImage = R.drawable.baseline_science_24),
            NewsCategories(categoryName = R.string.category_world , categoryId = 1 , categoryImage = R.drawable.baseline_travel_explore_24),
            NewsCategories(categoryName = R.string.category_politics , categoryId = 1 , categoryImage = R.drawable.baseline_local_fire_department_24),
            NewsCategories(categoryName = R.string.category_travel , categoryId = 1 , categoryImage = R.drawable.baseline_travel_explore_24),
            NewsCategories(categoryName = R.string.category_food , categoryId = 1 , categoryImage = R.drawable.baseline_fastfood_24),
            NewsCategories(categoryName = R.string.category_lifestyle , categoryId = 1 , categoryImage = R.drawable.baseline_library_music_24),
        )

        return Resource.Success(categoriesList)
    }
}