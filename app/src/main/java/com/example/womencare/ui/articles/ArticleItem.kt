package com.example.womencare.ui.articles

import SignInTopAppBar
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Crop
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SegmentedButtonDefaults.Icon
import androidx.compose.material3.Surface
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


/*@Composable
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
                *//*
                            Text(
                                text = stringResource(id = R.string.first_text),
                                modifier.padding(16.dp),
                                textAlign = TextAlign.Justify
                            )
                *//*

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
}*/

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
                .background(MaterialTheme.colorScheme.background)
        ) {
            item {
                // Article Image
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

                // Topic Title
                Text(
                    text = topic,
                    modifier = Modifier.padding(horizontal = 16.dp),
                    style = MaterialTheme.typography.headlineSmall.copy(fontWeight = FontWeight.Bold)
                )

                Spacer(modifier = Modifier.height(8.dp))

                // Body Text
                Text(
                    text = stringResource(id = firstTextIdRes),
                    modifier = Modifier.padding(horizontal = 16.dp),
                    style = MaterialTheme.typography.bodyLarge.copy(lineHeight = 24.sp),
                    textAlign = TextAlign.Justify
                )

                Spacer(modifier = Modifier.height(32.dp))

                // Image Credit Footer
                Surface(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                    color = Color.LightGray,
                    shape = RoundedCornerShape(6.dp)
                ) {
                    Text(
                        text = "yacohchuk/Getty Images",
                        style = MaterialTheme.typography.labelSmall.copy(color = Color.Black),
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





