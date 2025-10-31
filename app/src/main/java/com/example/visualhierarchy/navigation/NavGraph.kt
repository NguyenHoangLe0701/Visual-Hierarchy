package com.example.visualhierarchy.screens.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.visualhierarchy.screens.BadDesignScreen
import com.example.visualhierarchy.screens.GoodDesignScreen
import com.example.visualhierarchy.screens.BadCartScreen
import com.example.visualhierarchy.screens.GoodCartScreen
import com.example.visualhierarchy.screens.HomeScreen

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = "home"
    ) {
        // Màn hình chính (Home)
        composable("home") {
            HomeScreen(
                onBadDesignClick = { navController.navigate("bad_design") },
                onGoodDesignClick = { navController.navigate("good_design") },
                onBadCartClick = { navController.navigate("bad_cart") },
                onGoodCartClick = { navController.navigate("good_cart") }
            )
        }

        // Màn hình “Thiết kế xấu”
        composable("bad_design") {
            BadDesignScreen(onBackClick = { navController.popBackStack() })
        }

        // Màn hình “Thiết kế đẹp”
        composable("good_design") {
            GoodDesignScreen(onBackClick = { navController.popBackStack() })
        }

        // Màn hình “Giỏ hàng xấu”
        composable("bad_cart") {
            BadCartScreen(onBackClick = { navController.popBackStack() })
        }

        // Màn hình “Giỏ hàng đẹp”
        composable("good_cart") {
            GoodCartScreen(onBackClick = { navController.popBackStack() })
        }
    }
}
