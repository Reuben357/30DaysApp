package com.example.a30daysapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Share
import androidx.compose.material3.AssistChip
import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.RoundRect
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.a30daysapp.model.Recipe
import com.example.a30daysapp.model.RecipeRepo
import com.example.a30daysapp.ui.theme._30DaysAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            _30DaysAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    RecipeApp()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RecipeApp() {
Scaffold (
    modifier = Modifier.fillMaxSize(),
    topBar = {
        RecipeTopBar()
    }
){innerPadding ->
    Column (
        modifier = Modifier.padding(innerPadding)
    ){
        RecipeList(recipes = RecipeRepo.recipes())
    }

}

}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RecipeTopBar(modifier: Modifier = Modifier) {
    TopAppBar(
        title = {
            Text(
                text = "30 Days of Recipes",
                style = MaterialTheme.typography.displayLarge,
            )
        },
        modifier = modifier
    )
}

@Composable
fun RecipeList(
    recipes: List<Recipe>,
){
    LazyColumn(){
        items(recipes){ recipe ->
            RecipeCardItem(
                recipe = recipe,
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}

@OptIn(ExperimentalLayoutApi::class, ExperimentalMaterial3Api::class)
@Composable
fun RecipeCardItem(
    recipe: Recipe,
    modifier: Modifier = Modifier
){
    var expanded by remember { mutableStateOf(false) }
    Card (
        elevation = CardDefaults.cardElevation(
            defaultElevation = 2.dp
        ),
        modifier = Modifier
            .clickable { expanded = !expanded }
            .padding(6.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant,
        ),
        shape = RoundedCornerShape(8.dp),
        ) {
        Column (
            modifier = Modifier
                .animateContentSize(
                    animationSpec = spring(
                        dampingRatio = Spring.DampingRatioNoBouncy,
                        stiffness = Spring.StiffnessMedium
                    )
                )
                .padding(16.dp)
        ){
            Text(
                text = stringResource(recipe.dayOfMonth),
                style = MaterialTheme.typography.displaySmall
            )
            Text(
                text = stringResource(recipe.recipeSummary),
                style = MaterialTheme.typography.displayLarge
            )
            Image(
                painter = painterResource(recipe.imageRes),
                contentDescription = null,
                contentScale = ContentScale.Fit,
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = stringResource(recipe.recipeDescriptionTitle)
            )
            if (expanded){
                Text(
                    text = stringResource(recipe.recipeDescriptionBody)
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
            FlowRow(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ){
                AssistChip(
                    onClick = { /*TODO*/ },
                    colors = AssistChipDefaults.assistChipColors(
                        leadingIconContentColor = MaterialTheme.colorScheme.onSurfaceVariant
                    ),
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Outlined.FavoriteBorder,
                            contentDescription = null
                        )
                    },
                    label = {
                        Text(text = "Favorite")
                    }
                )
                AssistChip(
                    onClick = { /*TODO*/ },
                    colors = AssistChipDefaults.assistChipColors(
                        leadingIconContentColor = MaterialTheme.colorScheme.onSurfaceVariant
                    ),
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Outlined.Share,
                            contentDescription = null
                        )
                    },
                    label = {
                        Text(text = "Favorite")
                    }
                )
            }

        }
    }
}

@Preview(showBackground = true)
@Composable
fun RecipeAppPreview() {
    _30DaysAppTheme {
        RecipeApp()
    }
}