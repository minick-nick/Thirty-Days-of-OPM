package com.example.thirtydaysofopm.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class OPMSong(
    @StringRes val titleRes: Int,
    @StringRes val artistRes: Int,
    @StringRes val yearReleasedRes: Int,
    @StringRes val genreRes: Int,
    @StringRes val songCatchyPartRes: Int,
    @StringRes val additionalInfoRes: Int,
    @DrawableRes val coverPhotoRes: Int,
    var songPosition: Int = 0
)
