package com.example.bottomnavigationjetpackcompose

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bottomnavigationjetpackcompose.Pages.HomePage
import com.example.bottomnavigationjetpackcompose.Pages.NotificationPage
import com.example.bottomnavigationjetpackcompose.Pages.SettingsPage
import com.example.bottomnavigationjetpackcompose.ui.theme.BottomNavigationJetpackComposeTheme

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun BottomNavigationMain() {

    val navItemList = listOf(
        NavItems("Home", Icons.Default.Home, 0),
        NavItems("Notification", Icons.Default.Notifications, 5),
        NavItems("Settings", Icons.Default.Settings, 0)

    )

    var selectedIndex by remember {
        mutableIntStateOf(0)
    }

    Scaffold(modifier = Modifier.fillMaxSize(), bottomBar = {
        NavigationBar {
            navItemList.forEachIndexed { index, navItems ->
                NavigationBarItem(selected = selectedIndex == index,
                    onClick = {
                        selectedIndex = index
                    },
                    icon = {
                        //Icon(imageVector = navItems.icon, contentDescription = "Icon")
                        BadgedBox(badge = {
                            if (navItems.badgeCount > 0) {
                                Badge {
                                    Text(text = navItems.badgeCount.toString())
                                }
                            }

                        }) {
                            Icon(imageVector = navItems.icon, contentDescription = "Icon")
                        }
                    },
                    label = {
                        Text(text = navItems.label)
                    })
            }
        }
    }) {
        ContentScreen(modifier = Modifier.padding(0.dp), selectedIndex)
    }

}

@Composable
fun ContentScreen(modifier: Modifier, selectedIndex: Int) {
    when (selectedIndex) {
        0 -> HomePage(modifier = modifier)
        1 -> NotificationPage(modifier = modifier)
        2 -> SettingsPage(modifier = modifier)
    }
}

@Composable
fun AppHeader() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.primary)
    ) {
        Text(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            text = "Bottom Navigation Jetpack Compose",
            color = Color.White,
            fontSize = 18.sp,
            textAlign = TextAlign.Center
        )
    }
}


@Preview(showSystemUi = true, showBackground = true)
@Composable
fun previewBottomNavigation() {
    BottomNavigationJetpackComposeTheme {
        BottomNavigationMain()
    }
}

