package com.example.newsapp.data

interface DomainMapper<T, domainModel> {
    fun mapToDomainModel(data : T) : domainModel
}