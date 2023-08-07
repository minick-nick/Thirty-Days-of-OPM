package com.example.thirtydaysofopm

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.thirtydaysofopm.data.OPMSongsDataSource
import com.example.thirtydaysofopm.model.OPMSong
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
            modifier = Modifier,
            topBar = {
                TopAppBar()
            }
        ) {
            OPMSongsList(
                opmSongs = OPMSongsDataSource.OPMSongs,
                modifier = Modifier.padding(it)
            )
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


