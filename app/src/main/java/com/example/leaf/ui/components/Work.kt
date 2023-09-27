package com.example.leaf.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.annotation.ExperimentalCoilApi
import coil.compose.AsyncImage
import com.example.leaf.core.loadBookCover
import com.example.leaf.domain.model.TrendingWork
import com.example.leaf.ui.theme.LeafTheme

@OptIn(ExperimentalMaterial3Api::class, ExperimentalCoilApi::class)
@Composable
fun Work(
    trendingWork: TrendingWork,
    modifier: Modifier = Modifier
) {
    
    val context = LocalContext.current
    
    ElevatedCard(
        modifier
            .fillMaxWidth()
            .padding(4.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        shape = RoundedCornerShape(8.dp)
    ) {
        Column(
            modifier
        ) {
            AsyncImage(
                model = loadBookCover(context, trendingWork.coverUrl),
                contentDescription = null,
                Modifier
                    .size(100.dp)
                    .fillMaxWidth()
            
            )
        }
        
        
    }
}

@Preview(showBackground = true)
@Composable
private fun WorkPreview() {
    LeafTheme {
        Surface {
            Work(
                TrendingWork(
                    key = "1",
                    title = "Sample Book 1",
                    editions = 3,
                    publishedYear = 2022,
                    coverUrl = "https://covers.openlibrary.org/b/id/14321120-L.jpg",
                    authorName = "Author 1",
                    subjects = listOf("Subject A", "Subject B")
                )
            )
        }
    }
}