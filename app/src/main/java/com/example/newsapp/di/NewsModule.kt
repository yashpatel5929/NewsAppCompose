package com.example.newsapp.di

import com.example.newsapp.data.local.GetNewsListData
import com.example.newsapp.data.remote.mapppers.NewsMapper
import com.example.newsapp.data.remote.mapppers.SourceMapper
import com.example.newsapp.data.repositories.NewsRepositoriesImpl
import com.example.newsapp.domain.repositories.NewsRepositories
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object NewsModule {


    @Provides
    @Singleton
    fun sourceMapper() : SourceMapper {
        return SourceMapper()
    }

    @Provides
    @Singleton
    fun provideNewMapper(sourceMapper: SourceMapper) : NewsMapper {
        return NewsMapper(sourceMapper)
    }

    @Provides
    @Singleton
    fun provideNewsListResponse() : GetNewsListData {
        return GetNewsListData()
    }


    @Provides
    @Singleton
    fun getNewsListRepositories(newsMapper: NewsMapper , newsListData: GetNewsListData) : NewsRepositories {
        return NewsRepositoriesImpl(newsMapper,newsListData)
    }
}