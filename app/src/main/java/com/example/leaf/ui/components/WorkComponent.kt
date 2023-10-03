package com.example.leaf.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.annotation.ExperimentalCoilApi
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.leaf.R
import com.example.leaf.domain.model.Work
import com.example.leaf.ui.theme.LeafTheme
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class, ExperimentalCoilApi::class)
@Composable
@ExperimentalMaterial3Api
fun WorkComponent(
    work: Work,
    modifier: Modifier = Modifier,
    onClick: (String) -> Unit = {}
) {
    
    val context = LocalContext.current
    val sheetState = rememberModalBottomSheetState()
    val scope = rememberCoroutineScope()
    var showBottomSheet by remember {
        mutableStateOf(false)
    }
    
    ElevatedCard(
        modifier
            .width(140.dp)
            .height(220.dp)
            .clickable(
                onClick = {
                    showBottomSheet = true
                    onClick(work.key)
                }
            ),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        shape = RoundedCornerShape(8.dp)
    ) {
        Column(
            modifier
                .fillMaxSize()
        ) {
            AsyncImage(
                model = ImageRequest.Builder(context)
                    .data(work.coverUrl)
                    .crossfade(true)
                    .build(),
                placeholder = painterResource(R.drawable.placeholderv),
                error = painterResource(R.drawable.placeholderv),
                fallback = painterResource(R.drawable.placeholderv),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxSize(),
                contentScale = ContentScale.Crop
            )
            if (showBottomSheet) {
                ModalBottomSheet(onDismissRequest = {
                    showBottomSheet = false
                },
                    sheetState = sheetState) {
                    Button(onClick = {
                        scope.launch { sheetState.hide() }
                    }) {
                        Text("Hide bottom sheet")
                    }
                }
            }
        }
    }
}

//@Preview(showBackground = true)
//@Composable
//private fun WorkPreview() {
//    LeafTheme {
//        Surface {
//            WorkComponent(
//                Work(
//                    key = "1",
//                    title = "Sample Book 1",
//                    editions = 3,
//                    publishedYear = 2022,
//                    coverUrl = "https://covers.openlibrary.org/b/id/14321120-L.jpg",
//                    authorName = "Author 1"
//                )
//            )
//        }
//    }
//}

//var expanded by remember { mutableStateOf (false) }

//if (expanded) {
//    Column(
//        Modifier
//            .height(50.dp)
//            .fillMaxWidth()
//    ) {
//        Text(
//            text = work.title,
//            fontSize = 14.sp,
//            fontWeight = FontWeight(300),
//            maxLines = 1,
//            overflow = TextOverflow.Ellipsis
//        )
//        Row(
//            Modifier
//                .fillMaxWidth()
//        ) {
//            Column {
//                Text(
//                    text = work.authorName,
//                    fontSize = 14.sp,
//                    fontWeight = FontWeight(300)
//                )
////                            Text(
////                                text = work.subjects.toString(),
////                                fontSize = 14.sp,
////                                fontWeight = FontWeight(300)
////                            )
//
//            }
//            Text(
//                text = work.title,
//                fontSize = 14.sp,
//                fontWeight = FontWeight(300)
//            )
//
//        }
//    }
//}
//}