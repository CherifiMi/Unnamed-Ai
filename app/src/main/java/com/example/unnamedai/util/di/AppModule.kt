package com.example.unnamedai.util.di

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.example.unnamedai.data.local.DatabaseRepositoryImp
import com.example.unnamedai.data.local.UnnamedAiDatabase
import com.example.unnamedai.domain.repository.DatabaseRepository
import com.example.unnamedai.domain.use_case.UseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideDatabaseRepository(dp: UnnamedAiDatabase): DatabaseRepository {
        return DatabaseRepositoryImp(dp.unnamedAiDao)
    }

    @Provides
    @Singleton
    fun provideBookDatabase(app: Application): UnnamedAiDatabase {
        return Room.databaseBuilder(
            app,
            UnnamedAiDatabase::class.java,
            UnnamedAiDatabase.Database_Name
        ).build()
    }

    @Provides
    @Singleton
    fun provideUseCases(
        databaseRepository: DatabaseRepository,
        @ApplicationContext context: Context
    ) = UseCases(
        x = 3
        //getDataStoreItem = GetDataStoreItem(dataStore),
    )
}