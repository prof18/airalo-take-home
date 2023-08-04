package com.prof18.airalo.countrychooser.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.prof18.airalo.designsystem.components.ErrorView
import com.prof18.airalo.designsystem.components.FullScreenLoader
import com.prof18.airalo.designsystem.theme.AiraloTheme
import com.prof18.airalo.countrychooser.presentation.state.HomeState
import org.koin.androidx.viewmodel.ext.android.viewModel

internal class HomeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val viewModel: HomeViewModel by viewModel()

        setContent {
            val state by viewModel.homeState.collectAsStateWithLifecycle()

            AiraloTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background,
                ) {
                    when (state) {
                        HomeState.Loading -> FullScreenLoader()

                        is HomeState.Error -> {
                            val errorState = state as HomeState.Error
                            ErrorView(
                                title = errorState.content,
                                buttonText = errorState.buttonText,
                                onRetryClick = errorState.onRetryClick,
                            )
                        }

                        is HomeState.Content -> {
                            val content = state as HomeState.Content
                            Greeting(content.toString())
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier,
    )
}

@Preview(showBackground = true)
@Composable
private fun GreetingPreview() {
    AiraloTheme {
        Greeting("Android")
    }
}
