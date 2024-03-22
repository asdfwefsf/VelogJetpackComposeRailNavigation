package com.company.velogjetpackcomposerailnavigation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.Call
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.company.velogjetpackcomposerailnavigation.ui.theme.VelogJetpackComposeRailNavigationTheme

class MainActivity : ComponentActivity() {

    // 2.
    val items = listOf(
        RailNavItem(
            title = "Home",
            selectedIcon = Icons.Filled.Home,
            unselectedIcon = Icons.Outlined.Home,
            alarm = false
        ),
        RailNavItem(
            title = "Call",
            selectedIcon = Icons.Filled.Call,
            unselectedIcon = Icons.Outlined.Call,
            alarm = false,
            badgeCount = 77
        ),
        RailNavItem(
            title = "Settings",
            selectedIcon = Icons.Filled.Settings,
            unselectedIcon = Icons.Outlined.Settings,
            alarm = true
        )
    )

    @OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            VelogJetpackComposeRailNavigationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    //3.
                    val windowClass = calculateWindowSizeClass(activity = this)
                    val showNavigationRail =
                        windowClass.widthSizeClass != WindowWidthSizeClass.Compact


                }
            }
        }
    }
}

// 4.
@Composable
fun RailNavigation(
    items: List<RailNavItem>,
    selectedItemIndex: Int,
    onNavigate: (Int) -> Unit
) {
    // 4-1
    NavigationRail(
        header = {
            IconButton(onClick = {

            }) {
                Icon(
                    imageVector = Icons.Default.Menu,
                    contentDescription = "Menu"
                )
            }
            FloatingActionButton(
                onClick = {

                },
                elevation = FloatingActionButtonDefaults.bottomAppBarFabElevation()
                // elevation이 존재하면 안된다.
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Add"
                )
            }
        }
    ) {
        items.forEachIndexed { index, railNavItem ->
            NavigationRailItem(
                selected = selectedItemIndex == index,
                onClick = {
                    onNavigate(index)
                },
                icon = {
                    NavigationIcon(
                        item = railNavItem,
                        selected = selectedItemIndex == index
                    )
                },
                label = {
                    Text(text = railNavItem.title)
                })

        }
    }
}
// 5
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NavigationIcon(
    item: RailNavItem,
    selected: Boolean
) {
    BadgedBox(
        badge = {
            if (item.badgeCount != null) {
                Badge {
                    Text(text = item.badgeCount.toString())
                }
            } else if (item.alarm) {
                Badge()
            }
        }
    ) {
        Icon(
            imageVector = if (selected) item.selectedIcon else item.unselectedIcon,
            contentDescription = item.title
        )
    }
}

@Composable
fun BottomNav(showNavigationRail : Boolean) {
    Scaffold(
        bottomBar = {
            if(!showNavigationRail) {
                // NavigationBar()
            }
        },
        modifier = Modifier.fillMaxSize()
    ) {
        it
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        ) {
            items(100) {
                Text(text = "Item$it")
            }
        }
    }

    
}




















