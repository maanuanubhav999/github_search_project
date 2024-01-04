package com.asraven.speerAssessment.data.remote.di

import android.content.Context
import com.asraven.speerAssessment.data.remote.Hosts
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    var gson: Gson = GsonBuilder()
        .setLenient()
        .create()


    @Provides
    @Singleton
    @Named("GithubApi")
    fun providesGithubApiRetrofit(

        @ApplicationContext context: Context,
    ): Retrofit = buildRetrofit(
        Hosts.GITHUB,
        context
    )


    private fun buildRetrofit(
        baseUrl: String,
        @ApplicationContext context: Context,
    ): Retrofit {
        val client = OkHttpClient.Builder()
            .followRedirects(false)
            .build()

        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(client)
            .build()
    }
}