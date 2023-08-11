package com.example.article

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.article.ui.theme.ArticleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArticleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column {
                        GreetingImage(R.drawable.bg_compose_background, dsc = "banner图")
                        Column {
                            GreetingTitle(stringResource(R.string.blog_title))
                            GreetingText(stringResource(R.string.blog_content1))
                            GreetingText(stringResource(R.string.blog_content2))
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun GreetingImage(sourceId: Int,dsc: String, modifier: Modifier = Modifier) {
    Image (
        painter = painterResource(sourceId),
        contentDescription = dsc,
        contentScale = ContentScale.FillWidth,
        alignment = Alignment.TopCenter,
        modifier = modifier
    )
}

@Composable
fun GreetingTitle(text: String) {
    Text(text = text, fontSize = 26.sp,modifier = Modifier.padding(10.dp))
}

@Composable
fun GreetingText(text: String) {
    Text(text = text, fontSize = 16.sp,modifier = Modifier.padding(10.dp))
}

@Preview(showBackground = true, showSystemUi = true, name = "我的预览")
@Composable
fun GreetingPreview() {
    ArticleTheme {
        Column {
            GreetingImage(R.drawable.bg_compose_background, dsc = "banner图")
            Column {
                GreetingTitle(stringResource(R.string.blog_title))
                GreetingText(stringResource(R.string.blog_content1))
                GreetingText(stringResource(R.string.blog_content2))
            }
        }
    }
}