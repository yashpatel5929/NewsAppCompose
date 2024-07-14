package com.example.newsapp.data.repositories

import android.os.Build
import com.example.newsapp.BuildConfig
import com.example.newsapp.R
import com.example.newsapp.data.remote.NewsAPI
import com.example.newsapp.data.remote.mapppers.TopStoriesMapper
import com.example.newsapp.domain.model.TopStoriesModel
import com.example.newsapp.domain.repositories.TopStoriesRepositories
import com.example.newsapp.utils.Resource
import retrofit2.HttpException
import java.io.IOException

class TopStoriesRepositoriesImplementation(
    private val newsAPI: NewsAPI,
    private val topStoriesMapper: TopStoriesMapper,

) : TopStoriesRepositories {
    override suspend fun getTopStories(): Resource<List<TopStoriesModel>> {
        return try {
            val response =
               newsAPI.getTopStories(BuildConfig.ACCESS_TOKEN , 5)
            if (response.isSuccessful) {
                val responseBody = response.body()
                if (responseBody?.data != null) {
                    val topSories = topStoriesMapper.mapToDomainModel(responseBody.data ?: emptyList())
                    Resource.Success(data = topSories)
                } else {
                    Resource.Error(errorMessage = R.string.error_something_went_wrong)
                }
            } else {
                Resource.Error(errorMessage = R.string.error_something_went_wrong)
            }
        } catch (exception: Exception) {
            return when (exception) {
                is IOException -> Resource.Error(errorMessage = R.string.error_no_internet_connection)
                is HttpException -> Resource.Error(errorMessage = R.string.error_something_went_wrong)
                else -> Resource.Error(errorMessage = R.string.error_something_went_wrong)
            }
        }
    }
}