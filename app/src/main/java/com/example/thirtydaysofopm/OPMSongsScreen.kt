package com.example.thirtydaysofopm

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.rememberScrollableState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
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
                style = MaterialTheme.typography.displaySmall,
                modifier = Modifier.fillMaxWidth()
            )
        },
        modifier = modifier.padding(horizontal = dimensionResource(R.dimen.large_padding))
    )
}

@Composable
fun OPMSongsList(opmSongs: List<OPMSong>, modifier: Modifier = Modifier) {
    LazyRow(modifier = modifier) {
        itemsIndexed(opmSongs) { index, opmSong ->
            opmSong.songPosition = index + 1
            OPMSongListItem(
                opmSong = opmSong,
                modifier = Modifier.padding(horizontal = dimensionResource(R.dimen.medium_padding))
            )
        }
    }
}

@Composable
fun OPMSongListItem(opmSong: OPMSong, modifier: Modifier = Modifier) {

    var expand by remember { mutableStateOf(false) }

    Box(
        modifier = modifier
    ) {
        Card(
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
            shape = MaterialTheme.shapes.extraSmall,
            modifier = Modifier.padding(top = 30.dp)
        ) {
            Column(
                modifier = Modifier
                    .sizeIn(maxWidth = 331.dp)
                    .padding(top = 30.dp, start = 32.dp, end = 32.dp)
                    .fillMaxHeight()
            ) {
                SongCoverPhoto(
                    coverPhotoRes = opmSong.coverPhotoRes
                )
                SongOverview(
                    titleRes = opmSong.titleRes,
                    artistRes = opmSong.artistRes,
                    genreRes = opmSong.genreRes,
                    yearReleasedRes = opmSong.yearReleasedRes
                )
                SongCatchyPartAndAdditionalInfo(
                    songCatchyPartRes = opmSong.songCatchyPartRes,
                    additionalInfoRes = opmSong.additionalInfoRes
                )
                /*
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

                                AdditionalInfoButton(expand = expand, onClick = { expand = !expand })
                                if(expand) {
                                    SongCatchyPartAndAdditionalInfo(
                                        songCatchyPartRes = opmSong.songCatchyPartRes,
                                        additionalInfoRes = opmSong.additionalInfoRes
                                    )
                                }
                            }*/
            }
        }
        DayLabel(
            songPositionRes = opmSong.songPosition,
            modifier = Modifier.align(Alignment.TopCenter)
        )
    }
}

@Composable
fun DayLabel(@StringRes songPositionRes: Int, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .size(60.dp)
            .clip(CircleShape)
            .background(Color(0xFFE19E35))
    ) {
        Text(
            modifier = Modifier
                .fillMaxSize()
                .wrapContentSize(Alignment.Center),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.labelLarge ,
            text = stringResource(R.string.day, songPositionRes)
        )
    }
}

@Composable
fun SongCoverPhoto(@DrawableRes coverPhotoRes: Int, modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxWidth()
            .height(160.dp)
            .width(248.dp)
            .padding(top = 30.dp)
            .clip(MaterialTheme.shapes.extraSmall)
            .background(MaterialTheme.colorScheme.onPrimaryContainer)
    ) {
        Image(
            painter = painterResource(coverPhotoRes),
            contentDescription = null,
            modifier = Modifier
                .sizeIn(maxHeight = 104.dp)
                .clip(MaterialTheme.shapes.extraSmall),
            contentScale = ContentScale.FillHeight
        )
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
    Column(
        modifier = modifier
            .padding(top = 20.dp, bottom = dimensionResource(R.dimen.large_padding))
    ) {
        Text(
            text = stringResource(titleRes),
            style = MaterialTheme.typography.headlineSmall
        )
        Text(
            text = stringResource(artistRes),
            style = MaterialTheme.typography.titleMedium
        )
        Text(
            text = stringResource(R.string.genre, stringResource(genreRes)),
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(top = dimensionResource(R.dimen.medium_padding))
        )
        Text(
            text = stringResource(R.string.yr_released, stringResource(yearReleasedRes)),
            style = MaterialTheme.typography.bodyMedium
        )
    }
}

@Composable
fun SongCatchyPartAndAdditionalInfo(
    @StringRes songCatchyPartRes: Int,
    @StringRes additionalInfoRes: Int,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .verticalScroll(rememberScrollState())
    ) {
        Text(
            text = stringResource(songCatchyPartRes),
            style = MaterialTheme.typography.bodySmall,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    //top = dimensionResource(R.dimen.large_padding),
                    bottom = dimensionResource(R.dimen.medium_padding)
                )
        )
        Text(
            text = stringResource(additionalInfoRes),
            textAlign = TextAlign.Justify,
            style = MaterialTheme.typography.bodyMedium
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

@Preview
@Composable
fun OPMSongPreview() {
    ThirtyDaysOfOPMTheme() {
        OPMSongListItem(opmSong = OPMSongsDataSource.OPMSongs[0])
    }
}

