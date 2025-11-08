package ru.yamibook.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AddCircle
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import ru.yamibook.R
import ru.yamibook.ui.theme.Pink

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RecipeListScreen(
    onOpenRecipe: () -> Unit,
    onAdd: () -> Unit,
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(stringResource(R.string.recipes)) },
                actions = {
                    IconButton(onClick = { /* do something */ }) {
                        Icon(
                            imageVector = Icons.Outlined.Search,
                            contentDescription = "Localized description"
                        )
                    }
                    IconButton(onClick = onAdd) {
                        Icon(
                            imageVector = Icons.Outlined.AddCircle,
                            contentDescription = "Localized description"
                        )
                    }
                },
                colors = topAppBarColors(
                    containerColor = Pink
                ),
            )
        },
        modifier = Modifier.fillMaxSize()
    ) { innerPadding ->
        Text(
            text = "recipe_list",
            modifier = Modifier.padding(innerPadding)
        )
    }
}

@Preview
@Composable
fun RecipeListScreenPreview() {
    RecipeListScreen(
        onOpenRecipe = {},
        onAdd = {}
    )
}