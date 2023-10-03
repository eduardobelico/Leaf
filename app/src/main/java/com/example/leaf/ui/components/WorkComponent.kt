package com.example.leaf.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
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
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.annotation.ExperimentalCoilApi
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.leaf.R
import com.example.leaf.domain.model.Work
import com.example.leaf.domain.model.WorkDetails
import kotlinx.coroutines.launch
import javax.security.auth.Subject

@OptIn(ExperimentalMaterial3Api::class, ExperimentalCoilApi::class)
@Composable
@ExperimentalMaterial3Api
fun WorkComponent(
    work: Work,
    subjects: List<String>,
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
                ModalBottomSheet(
                    onDismissRequest = {
                        showBottomSheet = false
                    },
                    sheetState = sheetState,
                ) {
                    Row(
                        Modifier
                            .fillMaxWidth()
                            .padding(16.dp)
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
                                .height(260.dp)
                                .width(180.dp)
                                .padding(8.dp),
                            contentScale = ContentScale.Crop
                        )
                        Column(
                            Modifier
                                .fillMaxWidth()
                                .padding(8.dp),
                            verticalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            Text(
                                text = work.title,
                                fontSize = 18.sp,
                                fontWeight = FontWeight(800),
                                maxLines = 3,
                                overflow = TextOverflow.Ellipsis
                            )
                            Text(
                                text = work.authorName,
                                fontSize = 18.sp,
                                fontWeight = FontWeight(600)
                            )
                            Text(
                                text = subjects.take(2).joinToString(", "),
                                fontSize = 14.sp,
                                fontWeight = FontWeight(300)
                            )
                        }
                        
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

//}