package com.example.taskmanage

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.Alignment
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.taskmanage.ui.theme.TaskManageTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TaskManageTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column {
                        GreetingImage(R.drawable.ic_task_completed)
                        GreetingTitle(stringResource(R.string.completed_title))
                        GreetingText(stringResource(R.string.completed_text))
                    }
                }
            }
        }
    }
}

@Composable
fun GreetingImage(sourceId: Int, modifier: Modifier = Modifier) {
    Image(
        painter = painterResource(sourceId),
        contentDescription = "success img",
        contentScale = ContentScale.Crop,
        modifier = modifier
    )
}

@Composable
fun GreetingTitle(text: String) {
    Text(
        text,
        fontSize = 24.sp,
        fontWeight = FontWeight.Bold,
        modifier = Modifier.padding(top = 24.dp, bottom = 8.dp)
    )
}

@Composable
fun GreetingText(text: String) {
    Text(text, fontSize = 16.sp)
}

@Preview(showBackground = true, name = "我的预览", showSystemUi = true)
@Composable
fun GreetingPreview() {
    TaskManageTheme {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            GreetingImage(R.drawable.ic_task_completed)
            GreetingTitle(stringResource(R.string.completed_title))
            GreetingText(stringResource(R.string.completed_text))
        }
    }
}