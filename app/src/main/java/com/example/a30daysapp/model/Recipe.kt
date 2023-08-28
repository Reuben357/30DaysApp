package com.example.a30daysapp.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Recipe(
    @StringRes val dayOfMonth: Int,
    @StringRes val recipeSummary: Int,
    @DrawableRes val imageRes: Int,
    @StringRes val recipeDescriptionTitle: Int,
    @StringRes val recipeDescriptionBody: Int,
)
