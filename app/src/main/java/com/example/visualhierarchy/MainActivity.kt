package com.example.visualhierarchy

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.example.visualhierarchy.screens.navigation.NavGraph
import com.example.visualhierarchy.ui.theme.VisualHierarchyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            VisualHierarchyApp()
        }
    }
}

@Composable
fun VisualHierarchyApp() {
    VisualHierarchyTheme {
        val navController = rememberNavController()
        Surface {
            NavGraph(navController = navController)
        }
    }
}
