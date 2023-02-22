package com.lnight.graphqlcountries.data

import com.apollographql.apollo3.ApolloClient
import com.lnight.graphqlcountries.CountriesQuery
import com.lnight.graphqlcountries.CountryQuery
import com.lnight.graphqlcountries.di.IoDispatcher
import com.lnight.graphqlcountries.domain.CountryClient
import com.lnight.graphqlcountries.domain.DetailedCountry
import com.lnight.graphqlcountries.domain.SimpleCountry
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

class ApolloCountryClient(
    private val apolloClient: ApolloClient,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher
): CountryClient {

    override suspend fun getCountries(): List<SimpleCountry> = withContext(ioDispatcher)  {
        return@withContext apolloClient
            .query(CountriesQuery())
            .execute()
            .data
            ?.countries
            ?.map { it.toSimpleCountry() }
            ?: emptyList()
    }

    override suspend fun getCountry(code: String): DetailedCountry? = withContext(ioDispatcher) {
        return@withContext apolloClient
            .query(CountryQuery(code))
            .execute()
            .data
            ?.country
            ?.toDetailedCountry()
    }

}