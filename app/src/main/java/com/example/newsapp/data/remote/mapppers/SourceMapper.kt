package com.example.newsapp.data.remote.mapppers

import com.example.newsapp.data.DomainMapper
import com.example.newsapp.data.remote.dtos.NewList.SourceDto
import com.example.newsapp.domain.model.Source

class SourceMapper : DomainMapper<SourceDto? , Source> {
    override fun mapToDomainModel(data: SourceDto?): Source {
        return Source(
            name = data?.name
        )
    }
}