package com.example.womencare.ui.articles

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ThumbDown
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.womencare.R
import com.example.womencare.theme.Typography

/*
@Composable
fun ArticleApp() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "article_list") {
        composable("article_list") {
            ArticleScreen(navController)
        }
        composable(
            route = "article_detail/{title}/{description}/{imageRes}/{date}",
            arguments = listOf(
                navArgument("title") { type = NavType.StringType },
                navArgument("description") { type = NavType.StringType },
                navArgument("imageRes") { type = NavType.IntType },
                navArgument("date") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val title = backStackEntry.arguments?.getString("title") ?: ""
            val description = backStackEntry.arguments?.getString("description") ?: ""
            val imageRes = backStackEntry.arguments?.getInt("imageRes") ?: R.drawable.ab3_stretching
            val date = backStackEntry.arguments?.getString("date") ?: ""

            ArticleDetailScreen(title, description, imageRes, date)
        }
    }
}*/


@Composable
fun ArticleScreen(navController: NavController) {
    val articles = listOf(
        ArticleData(
            title = "How Exercise helps to get going",
            description = "In today's world, we live from a time where we derived happiness from exercise.",
            imageRes = R.drawable.ab3_stretching,
            postDate = "23/12/2021"
        ),
        ArticleData(
            title = "How Exercise helps to get going",
            description = "In today's world, we live from a time where we derived happiness from exercise.",
            imageRes = R.drawable.ab6_pre_natal_yoga,
            postDate = "23/12/2021"
        ),
        ArticleData(
            title = "How Exercise helps to get going",
            description = "In today's world, we live from a time where we derived happiness from exercise.",
            imageRes = R.drawable.img,
            postDate = "23/12/2021"
        )
    )

    LazyColumn(
        modifier = Modifier.padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
       /* item(articles) { articles ->
            ArticleCard(articles, navController)
        }*/

        items(1) {
            ArticleCard(
                article = articles[0], onItemClicked = { navController.navigate(route = Articles.FirstArticle.name) }
            )
        }

        items(1) {
            ArticleCard(
                article = articles[1], onItemClicked = { navController.navigate(route = Articles.FirstArticle.name) }
            )
        }
        items(1) {
            ArticleCard(
                article = articles[0], onItemClicked = { navController.navigate(route = Articles.FirstArticle.name) }
            )
        }

        items(1) {
            ArticleCard(
                article = articles[0], onItemClicked = { navController.navigate(route = Articles.FirstArticle.name) }
            )
        }
        items(1) {
            ArticleCard(
                article = articles[2], onItemClicked = { navController.navigate(route = Articles.FirstArticle.name) }
            )
        }

        items(1) {
            ArticleCard(
                article = articles[0], onItemClicked = { navController.navigate(route = Articles.FirstArticle.name) }
            )
        }
    }
}


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

data class ArticleData(
    val title: String,
    val description: String,
    val imageRes: Int,  // Store image as a resource ID
    val postDate: String
)


@Composable
fun ArticleDetailScreen(title: String, description: String, imageRes: Int, date: String) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Image(
            painter = painterResource(id = imageRes),
            contentDescription = "Article Image",
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .clip(RoundedCornerShape(12.dp)),
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = title, style = Typography.headlineLarge, fontWeight = FontWeight.Bold)

        Text(text = "Posted: $date", style = Typography.bodySmall, color = Color.Gray)

        Spacer(modifier = Modifier.height(12.dp))

        Text(text = description, style = Typography.bodyLarge)
    }
}