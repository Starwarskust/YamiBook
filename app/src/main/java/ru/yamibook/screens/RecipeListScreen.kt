package ru.yamibook.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AddCircle
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ListItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.yamibook.R
import ru.yamibook.ui.theme.Pink

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RecipeListScreen(
    onOpenRecipe: (String) -> Unit,
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
                            contentDescription = null
                        )
                    }
                    IconButton(onClick = onAdd) {
                        Icon(
                            imageVector = Icons.Outlined.AddCircle,
                            contentDescription = null
                        )
                    }
                },
                colors = topAppBarColors(
                    containerColor = Pink
                ),
            )
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier.padding(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            contentPadding = innerPadding
        ) {
            items(20) { index ->
                RecipeCard(
                    onClick = { onOpenRecipe("1") },
                    title = "Рецепт $index"
                )
            }
        }
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

@Composable
fun RecipeCard(
    onClick: () -> Unit,
    title: String
) {
    Card(
        modifier = Modifier.clickable(onClick = onClick),
        shape = RoundedCornerShape(8.dp)
    ) {
        ListItem(
            headlineContent = { Text(title) }
        )
    }
}