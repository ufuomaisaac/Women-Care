package com.example.womencare.ui.articles

import SignInTopAppBar
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Crop
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SegmentedButtonDefaults.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
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
fun ArticleItem(modifier: Modifier = Modifier, @DrawableRes imageIdRes: Int,
                @StringRes firstTextIdRes: Int, topic: String, navController: NavController){
    Column() {
        SignInTopAppBar(topAppBarTitle = topic, NavUp = {navController.popBackStack()})
        LazyColumn() {

            item {
                Image(
                    painter = painterResource(id = imageIdRes),
                    contentDescription = "Artical image",
                    modifier = Modifier.fillMaxWidth()
                )

                Text(
                    text = topic,
                    modifier.padding(16.dp),
                    fontSize = 24.sp,
                    //textAlign = TextAlign.Justify
                )
                /*
                            Text(
                                text = stringResource(id = R.string.first_text),
                                modifier.padding(16.dp),
                                textAlign = TextAlign.Justify
                            )
                */

                Text(
                    text = stringResource(id = firstTextIdRes),
                    modifier.padding(16.dp),
                    textAlign = TextAlign.Justify
                )

                Spacer(modifier = Modifier.height(64.dp))

                Text(text = "yacohchuk/Getty Images",
                    color = Color.Black,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(32.dp)
                        .background(Color.LightGray))

                Spacer(modifier = Modifier.height(64.dp))
            }
        }

    }
}


@Composable
fun ArticleCard(article: ArticleData) {
    Card(
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
        modifier = Modifier.fillMaxWidth()
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
                Text(text = article.description, style = MaterialTheme.typography.bodySmall, maxLines = 2)

                Spacer(modifier = Modifier.height(8.dp))

                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Row {
                        TextButton(onClick = { /* Handle Vote */ }) {
                           // Icon(Icons.Default.ThumbUp, contentDescription = "Like", tint = Color.Green)
                        }
                        TextButton(onClick = { /* Handle Dislike */ }) {
                           // Icon(Icons.Filled.Crop, contentDescription = "Dislike", tint = Color.Red)
                        }
                    }
                    Text(text = "Posted: ${article.postDate}", style = MaterialTheme.typography.bodySmall)
                }
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

