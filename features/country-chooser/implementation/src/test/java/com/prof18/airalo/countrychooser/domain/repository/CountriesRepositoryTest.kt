package com.prof18.airalo.countrychooser.domain.repository

import com.prof18.airalo.core.architecture.requireError
import com.prof18.airalo.core.architecture.requireSuccess
import com.prof18.airalo.countrychooser.fakes.CountriesRemoteDataSourceFake
import com.prof18.airalo.countrychooser.fixtures.defaultCountryDTO
import kotlinx.coroutines.test.runTest
import org.junit.Test
import kotlin.test.assertEquals

class CountriesRepositoryTest {

    private val repository: CountriesRepository = CountriesRepository(
        countriesRemoteDataSource = CountriesRemoteDataSourceFake,
    )

    @Test
    fun `When the remote data source returns an error, then the error will be propagated`() =
        runTest {
            val error = Throwable()

            CountriesRemoteDataSourceFake.countriesList = null
            CountriesRemoteDataSourceFake.error = error

            val result = repository.getPopularCountries()
            assertEquals(error, result.requireError())
        }

    @Test
    fun `When the remote data source returns a list of countries, then the countries are correctly mapped`() =
        runTest {
            CountriesRemoteDataSourceFake.countriesList = listOf(
                defaultCountryDTO,
            )

            val countries = repository.getPopularCountries().requireSuccess()
            val firstCountry = countries.first()

            assertEquals("italy", firstCountry.id)
            assertEquals("Italy", firstCountry.name)
            assertEquals("https://www.imageUrl.com", firstCountry.flagImageUrl.url)
        }
}
