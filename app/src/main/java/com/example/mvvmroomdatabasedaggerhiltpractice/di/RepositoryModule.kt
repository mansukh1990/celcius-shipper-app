package com.example.mvvmroomdatabasedaggerhiltpractice.di

import com.example.mvvmroomdatabasedaggerhiltpractice.networking.ApiService
import com.example.mvvmroomdatabasedaggerhiltpractice.repository.MainRepository
import com.example.mvvmroomdatabasedaggerhiltpractice.utils.SharedPrefManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import javax.inject.Singleton

@Module
@InstallIn(ActivityComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideRepository(
        apiService: ApiService,
        sharedPrefManager: SharedPrefManager
    ): MainRepository {
        return MainRepository(apiService, sharedPrefManager)
    }
}