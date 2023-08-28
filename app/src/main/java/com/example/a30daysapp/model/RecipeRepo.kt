package com.example.a30daysapp.model

import com.example.a30daysapp.R

object RecipeRepo {
    fun recipes(): List<Recipe>{
        return listOf<Recipe>(
            Recipe(
                dayOfMonth = R.string.day1,
                recipeSummary = R.string.recipeDesTitle1,
                recipeDescriptionTitle = R.string.recipeDesTitle1,
                recipeDescriptionBody = R.string.recipeDesBdy1,
                imageRes = R.drawable.recipe1
            ),
            Recipe(
                dayOfMonth = R.string.day2,
            recipeSummary = R.string.recipeDesTitle1,
            recipeDescriptionTitle = R.string.recipeDesTitle1,
            recipeDescriptionBody = R.string.recipeDesBdy1,
            imageRes = R.drawable.recipe2
        ),
        Recipe(
            dayOfMonth = R.string.day3,
            recipeSummary = R.string.recipeDesTitle1,
            recipeDescriptionTitle = R.string.recipeDesTitle1,
            recipeDescriptionBody = R.string.recipeDesBdy1,
            imageRes = R.drawable.recipe3
        ),
        Recipe(
            dayOfMonth = R.string.day4,
            recipeSummary = R.string.recipeDesTitle1,
            recipeDescriptionTitle = R.string.recipeDesTitle1,
            recipeDescriptionBody = R.string.recipeDesBdy1,
            imageRes = R.drawable.recipe4
        ),
        Recipe(
            dayOfMonth = R.string.day5,
            recipeSummary = R.string.recipeDesTitle1,
            recipeDescriptionTitle = R.string.recipeDesTitle1,
            recipeDescriptionBody = R.string.recipeDesBdy1,
            imageRes = R.drawable.recipe1
        ),
        Recipe(
            dayOfMonth = R.string.day6,
            recipeSummary = R.string.recipeDesTitle1,
            recipeDescriptionTitle = R.string.recipeDesTitle1,
            recipeDescriptionBody = R.string.recipeDesBdy1,
            imageRes = R.drawable.recipe2
        ),
        Recipe(
            dayOfMonth = R.string.day7,
            recipeSummary = R.string.recipeDesTitle1,
            recipeDescriptionTitle = R.string.recipeDesTitle1,
            recipeDescriptionBody = R.string.recipeDesBdy1,
            imageRes = R.drawable.recipe3
        ),
        Recipe(
            dayOfMonth = R.string.day8,
            recipeSummary = R.string.recipeDesTitle4,
            recipeDescriptionTitle = R.string.recipeDesTitle4,
            recipeDescriptionBody = R.string.recipeDesBdy1,
            imageRes = R.drawable.recipe4
        )
        )
    }
}