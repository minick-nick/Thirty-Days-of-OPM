package com.example.thirtydaysofopm.data

import com.example.thirtydaysofopm.R
import com.example.thirtydaysofopm.model.OPMSong

object OPMSongsDataSource {
    val OPMSongs = listOf(
        OPMSong(
            titleRes = R.string.song1_title,
            artistRes = R.string.song1_artist,
            yearReleasedRes = R.string.song1_yr_release,
            genreRes = R.string.song1_genre,
            songCatchyPartRes = R.string.song1_catchy_part,
            additionalInfoRes = R.string.song1_additional_info,
            coverPhotoRes = R.drawable.song1_cover_photo
        ),
        OPMSong(
            titleRes = R.string.song2_title,
            artistRes = R.string.song2_artist,
            yearReleasedRes = R.string.song2_yr_release,
            genreRes = R.string.song2_genre,
            songCatchyPartRes = R.string.song2_catchy_part,
            additionalInfoRes = R.string.song2_additional_info,
            coverPhotoRes = R.drawable.song2_cover_photo
        ),
        OPMSong(
            titleRes = R.string.song3_title,
            artistRes = R.string.song3_artist,
            yearReleasedRes = R.string.song3_yr_release,
            genreRes = R.string.song3_genre,
            songCatchyPartRes = R.string.song3_catchy_part,
            additionalInfoRes = R.string.song3_additional_info,
            coverPhotoRes = R.drawable.song3_cover_photo
        )
    )
}