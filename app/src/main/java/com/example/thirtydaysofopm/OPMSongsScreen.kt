package com.example.thirtydaysofopm

import androidx.annotation.StringRes
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.AnimationSpec
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.thirtydaysofopm.data.OPMSongsDataSource
import com.example.thirtydaysofopm.model.OPMSong
import com.example.thirtydaysofopm.ui.theme.ThirtyDaysOfOPMTheme


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBar(modifier: Modifier = Modifier) {
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = stringResource(R.string.app_name),
                style = MaterialTheme.typography.displayMedium
            )
        },
        modifier = modifier
    )
}

@Composable
fun OPMSongsList(opmSongs: List<OPMSong>, modifier: Modifier = Modifier) {
    LazyColumn(modifier = modifier) {
        itemsIndexed(opmSongs) { index, opmSong ->
            opmSong.songPosition = index + 1
            OPMSongListItem(
                opmSong = opmSong,
                modifier = Modifier.padding(
                    vertical = dimensionResource(R.dimen.small_padding),
                    horizontal = dimensionResource(R.dimen.large_padding)
                    )
            )
        }
    }
}

@Composable
fun OPMSongListItem(opmSong: OPMSong, modifier: Modifier = Modifier) {

    var expand by remember { mutableStateOf(false) }

    Card(
        modifier = modifier,
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        shape = MaterialTheme.shapes.extraSmall
    ) {
        Row(
            modifier = Modifier.padding(end = 8.dp)
        ) {
            Box(
                modifier = Modifier.sizeIn(maxWidth = 88.dp, maxHeight = 128.dp)
            ) {
                Image(
                    painter = painterResource(opmSong.coverPhotoRes),
                    contentDescription = null,
                    contentScale = ContentScale.Crop
                )
            }
            Spacer(modifier = Modifier.width(dimensionResource(R.dimen.small_padding)))
            Column(
                modifier = Modifier
                    .padding(vertical = dimensionResource(R.dimen.small_padding))
                    .animateContentSize(
                        animationSpec = spring(
                            dampingRatio = Spring.DampingRatioLowBouncy,
                            stiffness = Spring.StiffnessMedium
                        )
                    )
            ) {
                Text(
                    text = stringResource(R.string.day, opmSong.songPosition),
                    style = MaterialTheme.typography.displaySmall,
                    modifier = Modifier.padding(bottom = dimensionResource(R.dimen.extra_small_padding))
                )
                SongOverview(
                    titleRes = opmSong.titleRes,
                    artistRes = opmSong.artistRes,
                    genreRes = opmSong.genreRes,
                    yearReleasedRes = opmSong.yearReleasedRes)
                AdditionalInfoButton(expand = expand, onClick = { expand = !expand })
                if(expand) {
                    SongCatchyPartAndAdditionalInfo(
                        songCatchyPartRes = opmSong.songCatchyPartRes,
                        additionalInfoRes = opmSong.additionalInfoRes
                    )
                }
            }
        }
    }
}

@Composable
fun SongOverview(
    @StringRes titleRes: Int,
    @StringRes artistRes: Int,
    @StringRes genreRes: Int,
    @StringRes yearReleasedRes: Int,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Text(
            text = stringResource(titleRes),
            style = MaterialTheme.typography.titleLarge
        )
        Text(
            text = stringResource(artistRes),
            style = MaterialTheme.typography.titleSmall
        )
        Text(
            text = stringResource(R.string.genre, stringResource(genreRes)),
            style = MaterialTheme.typography.labelMedium,
            modifier = Modifier.padding(top = dimensionResource(R.dimen.extra_small_padding))
        )
        Text(
            text = stringResource(R.string.yr_released, stringResource(yearReleasedRes)),
            style = MaterialTheme.typography.labelMedium
        )
    }
}

@Composable
fun AdditionalInfoButton(expand: Boolean, onClick: () -> Unit, modifier: Modifier = Modifier) {
    IconButton(
        onClick = onClick,
        modifier = modifier
            .fillMaxWidth()
            .wrapContentWidth(Alignment.End)
    ) {
        Icon(
            painter = if(expand) painterResource(R.drawable.baseline_expand_less_24)
            else painterResource(R.drawable.baseline_expand_more_24),
            contentDescription = null
        )
    }
}

@Composable
fun SongCatchyPartAndAdditionalInfo(
    @StringRes songCatchyPartRes: Int,
    @StringRes additionalInfoRes: Int,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Text(
            text = stringResource(songCatchyPartRes),
            style = MaterialTheme.typography.bodySmall,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = dimensionResource(R.dimen.small_padding))
        )
        Text(
            text = stringResource(additionalInfoRes),
            style = MaterialTheme.typography.bodyMedium
        )
    }
}

@Preview
@Composable
fun OPMSongPreview() {
    ThirtyDaysOfOPMTheme() {
        OPMSongListItem(opmSong = OPMSongsDataSource.OPMSongs[0])
    }
}

