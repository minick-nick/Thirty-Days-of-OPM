package com.example.thirtydaysofopm

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.thirtydaysofopm.data.OPMSongsDataSource
import com.example.thirtydaysofopm.ui.theme.ThirtyDaysOfOPMTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ThirtyDaysOfOPMTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ThirtyDaysOfOPMApp()
                }
            }
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun ThirtyDaysOfOPMApp() {
        Scaffold(
            topBar = {
                TopAppBar()
            }
        ) {
            Surface(
                modifier = Modifier
                    .padding(it)
                    .fillMaxSize(),
                color = MaterialTheme.colorScheme.onPrimaryContainer
            ) {
                OPMSongsList(
                    opmSongs = OPMSongsDataSource.OPMSongs,
                    modifier = Modifier
                        .padding(
                            top = dimensionResource(R.dimen.list_vertical_padding),
                            bottom = dimensionResource(R.dimen.list_vertical_padding)
                        )
                )
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun OPMSongsPreview() {
        ThirtyDaysOfOPMTheme {
            ThirtyDaysOfOPMApp()
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun OPMSongsPreviewDarkTheme() {
        ThirtyDaysOfOPMTheme(darkTheme = true) {
            ThirtyDaysOfOPMApp()
        }
    }
}


