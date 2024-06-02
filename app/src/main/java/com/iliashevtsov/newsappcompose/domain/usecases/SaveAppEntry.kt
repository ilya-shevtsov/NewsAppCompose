package com.iliashevtsov.newsappcompose.domain.usecases

import com.iliashevtsov.newsappcompose.domain.manager.LocalUserManager

class SaveAppEntry(
    private val localUserManager: LocalUserManager
) {
    suspend operator fun invoke(){
        localUserManager.saveAppEntry()
    }
}