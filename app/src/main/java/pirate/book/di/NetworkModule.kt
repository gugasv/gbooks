package pirate.book.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import pirate.book.data.GoogleBooksAPIService
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class NetworkModule {

    @Singleton
    @Provides
    fun provideGoogleBooksAPIService():GoogleBooksAPIService {
        return GoogleBooksAPIService.create()
    }

}