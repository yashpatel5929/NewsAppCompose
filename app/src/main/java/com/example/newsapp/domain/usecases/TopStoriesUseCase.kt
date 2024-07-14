package com.example.newsapp.domain.usecases

import com.example.newsapp.domain.model.TopStoriesModel
import com.example.newsapp.domain.repositories.TopStoriesRepositories
import com.example.newsapp.utils.Resource

class TopStoriesUseCase(
    val topStoriesRepositories: TopStoriesRepositories
) {
suspend operator fun invoke() : Resource<List<TopStoriesModel>> {
    return topStoriesRepositories.getTopStories()
}
}