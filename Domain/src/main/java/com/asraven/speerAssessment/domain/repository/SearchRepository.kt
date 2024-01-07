package com.asraven.speerAssessment.domain.repository

import com.asraven.speerAssessment.data.remote.GithubApi
import com.asraven.speerAssessment.data.remote.model.GithubSearchResult
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

interface SearchRepository {

    suspend fun getSearchResults(userName: String): GithubSearchResult
}



class SearchRepositoryImplementation @Inject constructor(
    val githubApi: GithubApi
) : SearchRepository{
   override suspend fun getSearchResults(userName: String): GithubSearchResult {
       return githubApi.fetchGithubSearchResult(userName)
    }

}