package com.asraven.speerAssessment.domain.di

import com.asraven.speerAssessment.domain.repository.SearchRepository
import com.asraven.speerAssessment.domain.repository.SearchRepositoryImplementation
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
interface Domain {

    @Binds
    fun bindsSearchRepository(
        feedsRepository: SearchRepositoryImplementation
    ): SearchRepository

}
