package com.marcsedev.moviedb.core.di

import com.marcsedev.moviedb.core.data.MovieApi
import com.marcsedev.moviedb.core.data.remote.MovieRepositoryImpl
import com.marcsedev.moviedb.core.data.remote.intercpetor.ApiKeyInterceptor
import com.marcsedev.moviedb.core.domain.repository.MovieRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object CoreModule {

    @Provides
    @Singleton
    fun providerApi(): MovieApi {
        val client =
            OkHttpClient.Builder().addInterceptor(ApiKeyInterceptor())
                .addInterceptor(
                    HttpLoggingInterceptor().apply {
                        level = HttpLoggingInterceptor.Level.BODY
                    }
                ).build()
        return Retrofit.Builder().baseUrl(MovieApi.BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .client(client).build().create()
    }

    @Singleton
    @Provides
    fun provideRepository(api: MovieApi): MovieRepository {
        return MovieRepositoryImpl(api)
    }
}
