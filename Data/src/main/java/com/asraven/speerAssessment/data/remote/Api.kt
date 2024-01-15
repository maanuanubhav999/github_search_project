package com.asraven.speerAssessment.data.remote

import com.asraven.speerAssessment.data.remote.model.GithubSearchResult
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface GithubApi {
    @GET(Endpoints.USER_SEARCH_URL)
    suspend fun fetchGithubSearchResult(
        @Query("q") userName: String
    ): GithubSearchResult

}