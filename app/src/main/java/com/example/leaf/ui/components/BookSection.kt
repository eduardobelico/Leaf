package com.example.leaf.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.leaf.domain.model.TrendingWork

@Composable
fun BookSection(
    title: String,
    trendingWorkList: List<TrendingWork>,
    modifier: Modifier = Modifier,
    onClick: (String) -> Unit = {}
) {
    
    
    Column(modifier) {
        Text(
            text = title,
            Modifier.padding(start = 16.dp, end = 16.dp),
            fontSize = 20.sp,
            fontWeight = FontWeight(400)
        )
        LazyRow(
            Modifier
                .padding(
                    top = 8.dp
                )
                .fillMaxWidth()
                .height(200.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            contentPadding = PaddingValues(bottom = 16.dp)
        ) {
            items(trendingWorkList) { trendingWork ->
                WorkComponent(
                    trendingWork = trendingWork,
                    onClick = onClick
                )
            }
        }
        
    }
    
}


