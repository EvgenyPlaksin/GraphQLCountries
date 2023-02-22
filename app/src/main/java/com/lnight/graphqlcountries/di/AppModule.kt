package com.lnight.graphqlcountries.di

import com.apollographql.apollo3.ApolloClient
import com.lnight.graphqlcountries.data.ApolloCountryClient
import com.lnight.graphqlcountries.domain.CountryClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @IoDispatcher
    fun providesIoDispatcher(): CoroutineDispatcher = Dispatchers.IO

    @Provides
    @Singleton
    fun provideApolloClient(@IoDispatcher ioDispatcher: CoroutineDispatcher): ApolloClient {
        return ApolloClient.Builder()
            .serverUrl("https://countries.trevorblades.com/graphql")
            .dispatcher(ioDispatcher)
            .build()
    }

    @Provides
    @Singleton
    fun provideCountryClient(
        @IoDispatcher ioDispatcher: CoroutineDispatcher,
        apolloClient: ApolloClient
    ): CountryClient {
        return ApolloCountryClient(
            apolloClient = apolloClient,
            ioDispatcher = ioDispatcher
        )
    }

}