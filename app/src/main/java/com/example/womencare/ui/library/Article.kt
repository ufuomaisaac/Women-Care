package com.example.womencare.ui.library

import SignInTopAppBar
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun ArticleCard(article: ArticleData, onItemClicked : () -> Unit ) {
    Card(
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onItemClicked)
    ) {
        Row(
            modifier = Modifier.padding(12.dp),
            verticalAlignment = Alignment.Top
        ) {
            Image(
                painter = painterResource(id = article.imageRes),
                contentDescription = "Article Image",
                modifier = Modifier
                    .size(80.dp)
                    .clip(RoundedCornerShape(8.dp)),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.width(12.dp))

            Column(modifier = Modifier.weight(1f)) {
                Text(text = article.title, fontWeight = FontWeight.Bold, maxLines = 2)
                Text(text = article.description, style = androidx.compose.material3.MaterialTheme.typography.bodySmall, maxLines = 2)

                Spacer(modifier = Modifier.height(8.dp))

                    Text(text = "Posted: ${article.postDate}", style = androidx.compose.material3.MaterialTheme.typography.bodySmall)
            }
        }
    }
}


@Composable
fun ArticleItem(
    modifier: Modifier = Modifier,
    @DrawableRes imageIdRes: Int,
    @StringRes firstTextIdRes: Int,
    topic: String,
    navController: NavController
) {
    Column(modifier = modifier.fillMaxSize()) {
        SignInTopAppBar(
            topAppBarTitle = topic,
            NavUp = { navController.popBackStack() }
        )

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(androidx.compose.material3.MaterialTheme.colorScheme.background)
        ) {
            item {

                Image(
                    painter = painterResource(id = imageIdRes),
                    contentDescription = "Article Image",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(220.dp)
                        .clip(RoundedCornerShape(8.dp))
                        .padding(16.dp),
                    contentScale = ContentScale.Crop
                )

                Text(
                    text = topic,
                    modifier = Modifier.padding(horizontal = 16.dp),
                    style = androidx.compose.material3.MaterialTheme.typography.headlineSmall.copy(fontWeight = FontWeight.Bold)
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = stringResource(id = firstTextIdRes),
                    modifier = Modifier.padding(horizontal = 16.dp),
                    style = androidx.compose.material3.MaterialTheme.typography.bodyLarge.copy(lineHeight = 24.sp),
                    textAlign = TextAlign.Justify
                )

                Spacer(modifier = Modifier.height(32.dp))

                Surface(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                    color = Color.LightGray,
                    shape = RoundedCornerShape(6.dp)
                ) {
                    Text(
                        text = "yacohchuk/Getty Images",
                        style = androidx.compose.material3.MaterialTheme.typography.labelSmall.copy(color = Color.Black),
                        modifier = Modifier
                            .padding(8.dp)
                            .align(Alignment.CenterHorizontally)
                    )
                }

                Spacer(modifier = Modifier.height(32.dp))
            }
        }
    }
}







data class ArticleData(
    val title: String,
    val description: String,
    val imageRes: Int,  // Store image as a resource ID
    val postDate: String
)


