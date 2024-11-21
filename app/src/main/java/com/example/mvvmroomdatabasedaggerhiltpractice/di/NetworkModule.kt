package com.example.mvvmroomdatabasedaggerhiltpractice.di

import android.app.Application
import com.example.mvvmroomdatabasedaggerhiltpractice.BuildConfig
import com.example.mvvmroomdatabasedaggerhiltpractice.networking.ApiService
import com.example.mvvmroomdatabasedaggerhiltpractice.networking.CustomInterceptor
import com.example.mvvmroomdatabasedaggerhiltpractice.utils.ApiConstants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideBaseUrl() = ApiConstants.BASE_URL

    @Provides
    @Singleton
    fun provideInterceptor(application: Application): CustomInterceptor {
        return CustomInterceptor(application)
    }

    @Provides
    @Singleton
    fun provideOkhttp(customInterceptor: CustomInterceptor): OkHttpClient {
        val logging = HttpLoggingInterceptor().apply {
            if (BuildConfig.DEBUG) {
                this.level = HttpLoggingInterceptor.Level.BODY
            } else {
                this.level = HttpLoggingInterceptor.Level.NONE
            }
        }
        return OkHttpClient.Builder()
            .addInterceptor(customInterceptor)
            .addInterceptor(logging)
            .readTimeout(60L, TimeUnit.SECONDS)
            .writeTimeout(60L, TimeUnit.SECONDS)
            .connectTimeout(60L, TimeUnit.SECONDS)
            .build()


    }

    @Provides
    @Singleton
    fun provideGsonConverterFactory(): GsonConverterFactory = GsonConverterFactory.create()

    @Provides
    @Singleton
    fun provideRetrofit(
        baseUrl: String,
        client: OkHttpClient,
        gsonConverterFactory: GsonConverterFactory
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(client)
            .addConverterFactory(gsonConverterFactory)
            .build()
    }

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }


}
