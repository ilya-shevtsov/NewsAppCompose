package com.iliashevtsov.newsappcompose.di

import android.app.Application
import com.iliashevtsov.newsappcompose.data.manager.LocalUserManagerImpl
import com.iliashevtsov.newsappcompose.domain.manager.LocalUserManager
import com.iliashevtsov.newsappcompose.domain.usecases.AppEntryUseCases
import com.iliashevtsov.newsappcompose.domain.usecases.ReadAppEntry
import com.iliashevtsov.newsappcompose.domain.usecases.SaveAppEntry
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideLocalUserManager(
        application: Application
    ): LocalUserManager = LocalUserManagerImpl(application)

    @Provides
    @Singleton
    fun provideAppEntryUseCases(
        localUserManager: LocalUserManager
    ) = AppEntryUseCases(
        readAppEntry = ReadAppEntry(localUserManager),
        saveAppEntry = SaveAppEntry(localUserManager)
    )

}