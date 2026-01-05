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
import androidx.compose.material3.MaterialTheme
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
import com.example.womencare.R


@Composable
fun ArticleCard(
    article: ArticleData,
    isYoruba: Boolean,
    onItemClicked: () -> Unit
) {
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
                contentDescription = null,
                modifier = Modifier
                    .size(80.dp)
                    .clip(RoundedCornerShape(8.dp)),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.width(12.dp))

            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = article.title(isYoruba),
                    fontWeight = FontWeight.Bold,
                    maxLines = 2
                )

                Text(
                    text = article.description(isYoruba),
                    style = MaterialTheme.typography.bodySmall,
                    maxLines = 2
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = if (isYoruba)
                        "Ọjọ́ ìkó: ${article.postDate}"
                    else
                        "Posted: ${article.postDate}",
                    style = MaterialTheme.typography.bodySmall
                )
            }
        }
    }
}



@Composable
fun Article(
    modifier: Modifier = Modifier,
    @DrawableRes imageIdRes: Int,
    @StringRes textEnRes: Int,
    @StringRes textYoRes: Int,
    topicEn: String,
    topicYo: String,
    isYoruba: Boolean,
    navController: NavController
) {
    val topic = if (isYoruba) topicYo else topicEn

    Column(modifier = modifier.fillMaxSize()) {
        SignInTopAppBar(
            topAppBarTitle = topic,
            NavUp = { navController.popBackStack() }
        )

        LazyColumn {
            item {
                Image(
                    painter = painterResource(id = imageIdRes),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(220.dp)
                        .padding(16.dp),
                    contentScale = ContentScale.Crop
                )

                Text(
                    text = topic,
                    modifier = Modifier.padding(horizontal = 16.dp),
                    style = MaterialTheme.typography.headlineSmall.copy(fontWeight = FontWeight.Bold)
                )

                Spacer(Modifier.height(8.dp))

                Text(
                    text = stringResource(
                        id = if (isYoruba) textYoRes else textEnRes
                    ),
                    modifier = Modifier.padding(horizontal = 16.dp),
                    style = MaterialTheme.typography.bodyLarge.copy(lineHeight = 24.sp),
                    textAlign = TextAlign.Justify
                )
            }
        }
    }
}


val articles = listOf(
    ArticleData(
        titleEn = "Early Signs & Screening",
        titleYo = "Ààmì Kíkàn àti Ìdánwò",
        descriptionEn = "What every woman should know",
        descriptionYo = "Ohun tí gbogbo obìnrin gbọ́dọ̀ mọ̀",
        imageRes = R.drawable.ab3_stretching,
        postDate = "23/12/2021"
    ),
    ArticleData(
        titleEn = "Burden & Prevention",
        titleYo = "Ẹrù Àrùn àti Ìdènà",
        descriptionEn = "Global overview of cervical cancer",
        descriptionYo = "Àgbáyé àkíyèsí àrùn ìgbẹ́yà",
        imageRes = R.drawable.ab6_pre_natal_yoga,
        postDate = "23/12/2021"
    )
)

data class ArticleData(
    val titleEn: String,
    val titleYo: String,
    val descriptionEn: String,
    val descriptionYo: String,
    val imageRes: Int,
    val postDate: String
) {
    fun title(isYoruba: Boolean): String =
        if (isYoruba) titleYo else titleEn

    fun description(isYoruba: Boolean): String =
        if (isYoruba) descriptionYo else descriptionEn
}


