package ru.yamibook

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.List
import androidx.compose.material.icons.outlined.AddCircle
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ru.yamibook.ui.theme.Pink
import ru.yamibook.ui.theme.YamiBookTheme

sealed class MainTab(val route: String, val icon: ImageVector) {
    object RecipeList : MainTab("recipe_list", Icons.Outlined.Home)
    object Tab2 : MainTab("tab2", Icons.AutoMirrored.Outlined.List)
    object Tab3 : MainTab("tab3", Icons.Outlined.Menu)
    object Settings : MainTab("settings", Icons.Outlined.Settings)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun YamiBookApp() {
    val navController = rememberNavController()
    val mainTabList = listOf(MainTab.RecipeList, MainTab.Tab2, MainTab.Tab3, MainTab.Settings)
    var selectedMainTab by remember { mutableIntStateOf(0) }
    YamiBookTheme {
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
                        IconButton(onClick = { /* do something */ }) {
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
            bottomBar = {
                NavigationBar {
                    mainTabList.forEachIndexed { index, tab ->
                        NavigationBarItem(
                            selected = selectedMainTab == index,
                            onClick = {
                                selectedMainTab = index
                                navController.navigate(tab.route)
                            },
                            icon = {
                                Icon(
                                    imageVector = tab.icon,
                                    contentDescription = null
                                )
                            }
                        )
                    }
                }
            },
            modifier = Modifier.fillMaxSize()
        ) { innerPadding ->
            NavHost(
                navController = navController,
                startDestination = MainTab.RecipeList.route,
                modifier = Modifier.padding(innerPadding)
            ) {
                composable(MainTab.RecipeList.route) { Text("recipe_list") }
                composable(MainTab.Tab2.route) { Text("tab2") }
                composable(MainTab.Tab3.route) { Text("tab3") }
                composable(MainTab.Settings.route) { Text("settings") }
            }
        }
    }
}