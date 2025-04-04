package com.example.womencare.ui.articles

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.womencare.R

@Composable
fun UserProfile(navController: NavController) {
    Column(){
        SearchBar()
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Articles",
            modifier = Modifier.padding(horizontal = 16.dp),
            style = MaterialTheme.typography.h5,
            color = Color.Black
        )

        Spacer(modifier = Modifier.height(32.dp))

        LazyColumn {
            items(1) {
                ClickableTextAndImage(textId = R.string.first_article_preview, imageId = R.drawable.ab3_stretching ,
                    onItemClicked = { navController.navigate(route = Articles.FirstArticle.name) }, topic = "Balancing Nutrients")
            }

            items(1) {
                ClickableTextAndImage(textId = R.string.second_article_preview, imageId = R.drawable.ab2_quick_yoga ,
                    onItemClicked = { navController.navigate(route = Articles.SecondArticle.name) }, topic = "Embracing Your Changing Body")
            }

            items(1) {
                ClickableTextAndImage(textId = R.string.third_article_preview, imageId = R.drawable.ab6_pre_natal_yoga ,
                    onItemClicked = { navController.navigate(route = Articles.ThirdArticle.name) }, topic = "Overcoming Pregnancy Depression")
            }

            items(1) {
                ClickableTextAndImage(textId = R.string.first_article_preview, imageId = R.drawable.ab3_stretching ,
                    onItemClicked = { navController.navigate(route = Articles.FourthArticle.name) }, topic = "Exercise")
            }

            items(1) {
                ClickableTextAndImage(textId = R.string.first_article_preview, imageId = R.drawable.ab3_stretching ,
                    onItemClicked = { navController.navigate(route = Articles.FifthArticle.name) }, topic = "Exercise")
            }

        }

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBar(
    modifier: Modifier = Modifier
){
    Column(modifier =
        modifier.padding(horizontal = 16.dp)) {
        TextField(
            value = " ",
            leadingIcon = {
                Icon(imageVector = Icons.Default.Search , contentDescription = "search" )
            },
            onValueChange = {},
            colors = TextFieldDefaults.colors(focusedContainerColor = Color.White
                , unfocusedContainerColor = Color.White),
            placeholder = {
                Text(text = "Search")
            },
            modifier = modifier
                .fillMaxWidth()
                .heightIn(min = 56.dp)
        )
    }
}

@Composable
fun ClickableTextAndImage(@StringRes textId : Int, @DrawableRes imageId: Int,
                          onItemClicked: () -> Unit, topic: String ) {

    Column(modifier = Modifier.padding(vertical = 16.dp)) {

        Text(text = topic,
            style = TextStyle(fontSize = 16.sp),
            modifier = Modifier.padding(start = 16.dp))

        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Image(
                painter = painterResource(id = imageId),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .clickable(onClick = onItemClicked),
                contentScale = ContentScale.FillBounds
            )

            Text(
                text = stringResource(id = textId),
                modifier = Modifier.clickable(onClick = onItemClicked)
            )
        }
    }
}

