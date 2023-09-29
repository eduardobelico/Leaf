package com.example.leaf.ui.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.leaf.ui.screens.HomeScreen
import com.example.leaf.ui.theme.LeafTheme
import com.example.leaf.ui.viewModels.HomeScreenViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    
    override fun onCreate(savedInstanceState: Bundle?) {
        
        super.onCreate(savedInstanceState)
        setContent {
            LeafApp {
                val viewModel by viewModels<HomeScreenViewModel>()
                HomeScreen(viewModel)
            }
        }
    }
}

@Composable
fun LeafApp(
    content: @Composable () -> Unit = {}
) {
    LeafTheme {
        Surface(modifier = Modifier.padding(4.dp)){
                content()
        }
    }
}

@Preview
@Composable
fun AppPreview() {
    LeafApp()
}