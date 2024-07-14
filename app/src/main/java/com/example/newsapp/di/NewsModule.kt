package com.example.newsapp.di

import com.example.newsapp.BuildConfig
import com.example.newsapp.data.local.GetNewsListData
import com.example.newsapp.data.remote.NewsAPI
import com.example.newsapp.data.remote.interceptors.AuthHeaderInterceptor
import com.example.newsapp.data.remote.mapppers.NewsMapper
import com.example.newsapp.data.remote.mapppers.SourceMapper
import com.example.newsapp.data.remote.mapppers.TopStoriesMapper
import com.example.newsapp.data.repositories.NewsRepositoriesImpl
import com.example.newsapp.data.repositories.TopStoriesRepositoriesImplementation
import com.example.newsapp.domain.repositories.NewsRepositories
import com.example.newsapp.domain.repositories.TopStoriesRepositories
import com.example.newsapp.domain.usecases.TopStoriesUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
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

    @Provides
    @Singleton
    fun provideHttpLoggingInterceptor() = HttpLoggingInterceptor()
        .apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

    @Provides
    @Singleton
    fun provideOkHttpClient(
        httpLoggingInterceptor: HttpLoggingInterceptor,
        authHeaderInterceptor : AuthHeaderInterceptor
    ): OkHttpClient {
        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(authHeaderInterceptor)
        if (BuildConfig.DEBUG) {
            okHttpClient.addInterceptor(httpLoggingInterceptor)
        }
        return okHttpClient.build()
    }

    @Provides
    @Singleton
    fun provideAuthInterceptor() = AuthHeaderInterceptor()


    @Provides
    @Singleton
    fun provideRetrofitInstance(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideConduitApi(retrofit: Retrofit): NewsAPI {
        return retrofit.create(NewsAPI::class.java)
    }

    @Provides
    @Singleton
    fun provideNewsMapper() = TopStoriesMapper()


    @Provides
    @Singleton
    fun provideTopStoriesRepositories(
        newsAPI: NewsAPI,
        topStoriesMapper: TopStoriesMapper
    ) : TopStoriesRepositories = TopStoriesRepositoriesImplementation(
        newsAPI = newsAPI,
        topStoriesMapper = topStoriesMapper
    )


    @Provides
    @Singleton
    fun provideTopStoriesUseCase(
        topStoriesRepositories: TopStoriesRepositories
    ) = TopStoriesUseCase(
        topStoriesRepositories = topStoriesRepositories
    )
}