package com.betclic.interview.ui

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import org.koin.androidx.viewmodel.ext.android.viewModel

//@AndroidEntryPoint(ComponentActivity::class)
class MainActivity : ComponentActivity() {

    private val viewModel: MainViewModel by viewModel()

    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MaterialTheme(
                colors = if (isSystemInDarkTheme()) darkColors() else lightColors()
            ) {
                Scaffold(
                    topBar = {
                        TopAppBar(
                            title = { Text("France national team") },
                            backgroundColor = MaterialTheme.colors.primary
                        )
                    }
                ) {
                    MainScreen(
                        viewModel = viewModel,
                    )
                }
            }
        }
    }
}