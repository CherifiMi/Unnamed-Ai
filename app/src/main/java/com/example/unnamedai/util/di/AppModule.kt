package com.example.unnamedai.util.di

import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    /*@Provides
    @Singleton
    fun providePreferencesDataStore(@ApplicationContext appContext: Context): DataStore<Preferences> =
        PreferenceDataStoreFactory.create(
            produceFile = {
                appContext.preferencesDataStoreFile("settings")
            }
        )

    @Provides
    @Singleton
    fun provideBookDatabase(app: Application): BookDatabase {
        return Room.databaseBuilder(
            app,
            BookDatabase::class.java,
            BookDatabase.Database_Name
        ).build()
    }

    @Provides
    @Singleton
    fun provideUseCases(
        dataStore: DataStore<Preferences>,
        repository: Repository,
        @ApplicationContext context: Context
    ) = UseCases(
        getDataStoreItem = GetDataStoreItem(dataStore),
        setDataStoreItem = SetDataStoreItem(dataStore),
        updateAndGetBooks = UpdateAndGetBooks(repository, dataStore, context),
        getAllBooks = GetAllBooks(repository),
        getBookById = GetBookById(repository),
        updateBookById = UpdateBookById(repository)
    )

    @Provides
    @Singleton
    fun provideRepository(dp: BookDatabase): Repository {
        return RepositoryImp(dp.bookDao)
    }

    @Singleton
    @Provides
    fun provideMusicServiceConnection(
        @ApplicationContext context: Context
    ) = MusicServiceConnection(
        context
    )
    @Singleton
    @Provides
    fun provideGlideInstance(
        @ApplicationContext context: Context
    ) = Glide.with(context).setDefaultRequestOptions(
        RequestOptions()
            .placeholder(R.drawable.ic_image)
            .error(R.drawable.ic_image)
            .diskCacheStrategy(DiskCacheStrategy.DATA)
    )*/
}