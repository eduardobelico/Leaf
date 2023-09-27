package com.example.leaf.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.leaf.domain.model.Work
import com.example.leaf.ui.theme.LeafTheme

@Composable
fun BookSection(
    title: String,
    workList: List<Work>,
    modifier: Modifier = Modifier
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
        ) {
        
        }
        
    }
    
}

@Preview(showBackground = true)
@Composable
fun BookSectionPreview() {
    LeafTheme {
        Surface {
            BookSection(
                "Trending",
                listOf(
                    Work(
                        title = "Book 1",
                        coverUrl = "https://example.com/cover1.jpg",
                        description = "Description for Book 1",
                        subjects = listOf("Subject A", "Subject B"),
                        authorName = "Author 1"
                    ),
                    Work(
                        title = "Book 2",
                        coverUrl = "https://example.com/cover2.jpg",
                        description = "Description for Book 2",
                        subjects = listOf("Subject C", "Subject D"),
                        authorName = "Author 2"
                    )
                )
            )
        }
    }
}