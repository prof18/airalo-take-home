package com.prof18.airalo.countrychooser.presentation

import app.cash.turbine.test
import com.prof18.airalo.core.R
import com.prof18.airalo.core.model.CountryId
import com.prof18.airalo.core.model.ImageUrl
import com.prof18.airalo.countrychooser.CountriesModule
import com.prof18.airalo.countrychooser.data.remote.CountriesRemoteDataSource
import com.prof18.airalo.countrychooser.fakes.CountriesRemoteDataSourceFake
import com.prof18.airalo.countrychooser.fixtures.defaultCountryDTO
import com.prof18.airalo.countrychooser.presentation.state.CountriesState
import com.prof18.airalo.countrychooser.presentation.state.CountriesState.Content.CountryItem
import com.prof18.airalo.testsutils.BaseViewModelTest
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.koin.core.component.inject
import org.koin.ksp.generated.module
import kotlin.test.assertEquals
import kotlin.test.assertIs

class CountriesViewModelTest : BaseViewModelTest() {

    private val viewModel: CountriesViewModel by inject()

    @Before
    fun setup() {
        initKoin(CountriesModule().module) {
            factory<CountriesRemoteDataSource> { CountriesRemoteDataSourceFake }
        }
    }

    @After
    override fun tearDown() {
        super.tearDown()
        CountriesRemoteDataSourceFake.clear()
    }

    @Test
    fun `When the ViewModel is created, then the state is of type Loading`() {
        val state = viewModel.countriesState.value
        assertIs<CountriesState.Loading>(state)
    }

    @Test
    fun `When there is a network error, then the correct error message is emitted`() = runTest {
        CountriesRemoteDataSourceFake.countriesList = null
        val errorMessage = "error-message"
        resourceProviderFake.setValue(R.string.error_message, errorMessage)

        val retryButtonText = "retry-button-text"
        resourceProviderFake.setValue(R.string.retry_button, retryButtonText)

        viewModel.countriesState.test {
            viewModel.fetchCountries()

            awaitItem()

            val errorState = awaitItem() as CountriesState.Error

            assertEquals(errorMessage, errorState.content)
            assertEquals(retryButtonText, errorState.retryButtonText)
        }
    }

    @Test
    fun `When there is a network error, the retry button is clicked and a successful load is done, then a content state is emitted`() =
        runTest {
            CountriesRemoteDataSourceFake.countriesList = null

            viewModel.countriesState.test {
                viewModel.fetchCountries()

                awaitItem()

                val errorState = awaitItem() as CountriesState.Error

                CountriesRemoteDataSourceFake.countriesList = listOf(defaultCountryDTO)
                errorState.onRetryClick()

                assertIs<CountriesState.Loading>(awaitItem())
                assertIs<CountriesState.Content>(awaitItem())
            }
        }

    @Test
    fun `When no countries are returned, then the correct error message is emitted`() = runTest {
        CountriesRemoteDataSourceFake.countriesList = listOf()
        val errorMessage = "no-countries"
        resourceProviderFake.setValue(R.string.no_countries, errorMessage)

        val retryButtonText = "retry-button-text"
        resourceProviderFake.setValue(R.string.retry_button, retryButtonText)

        viewModel.countriesState.test {
            viewModel.fetchCountries()

            awaitItem()

            val errorState = awaitItem() as CountriesState.Error

            assertEquals(errorMessage, errorState.content)
            assertEquals(retryButtonText, errorState.retryButtonText)
        }
    }

    @Test
    fun `When the fetching of the countries is successfull, then a content state is emitted`() =
        runTest {
            CountriesRemoteDataSourceFake.countriesList = listOf(defaultCountryDTO)

            viewModel.countriesState.test {
                viewModel.fetchCountries()

                awaitItem()

                assertIs<CountriesState.Content>(awaitItem())
            }
        }

    @Test
    fun `When the fetching of the countries is successfull, then the country item is correctly generated`() =
        runTest {
            CountriesRemoteDataSourceFake.countriesList = listOf(
                defaultCountryDTO.copy(title = "Spain"),
                defaultCountryDTO,
            )

            viewModel.countriesState.test {
                viewModel.fetchCountries()

                awaitItem()

                val content = awaitItem() as CountriesState.Content

                val firstCountry = content.countryItems.first()
                val expectedCountryItem = CountryItem(
                    id = CountryId(
                        value = "italy",
                    ),
                    name = "Italy",
                    flagImageUrl = ImageUrl(url = "https://www.imageUrl.com"),
                )
                assertEquals(expectedCountryItem, firstCountry)
            }
        }

    @Test
    fun `When the fetching of the countries is successfull, then the headerTitle is correctly generated`() =
        runTest {
            CountriesRemoteDataSourceFake.countriesList = listOf(defaultCountryDTO)
            val expectedHeader = "header-title"
            resourceProviderFake.setValue(R.string.popular_countries_header, expectedHeader)

            viewModel.countriesState.test {
                viewModel.fetchCountries()

                awaitItem()

                val content = awaitItem() as CountriesState.Content
                assertEquals(expectedHeader, content.headerTitle)
            }
        }
}
