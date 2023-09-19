package com.example.leaf.ui.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.leaf.ui.theme.LeafTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    
    override fun onCreate(savedInstanceState: Bundle?) {
        
        super.onCreate(savedInstanceState)
        setContent {
            LeafApp()
        }
    }
}

@Composable
fun LeafApp() {
    LeafTheme {
        Surface {
        
        }
    }
}

@Preview
@Composable
fun AppPreview() {
    LeafApp()
}