package com.example.happybirthday

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign

import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.happybirthday.ui.theme.HappyBirthdayTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HappyBirthdayTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    GreetingImage(
                        message = stringResource(R.string.happy_birthday_text),
                        from = stringResource(R.string.signature_text)
                    )
                }
            }
        }
    }
}

@Composable
fun GreetingText(message: String, from: String, modifier: Modifier = Modifier)  {
    Column (
        // 设置其子元素的垂直排列方式
        verticalArrangement = Arrangement.Center,
        modifier = modifier
    ) {
        Text(
            text = message,
            fontSize = 100.sp,
            lineHeight = 116.sp,
            textAlign = TextAlign.Center
        )
        Text(
            text = from,
            fontSize = 24.sp,
            modifier = Modifier
                .padding(16.dp)
                .align(Alignment.End)
        )
    }
}

// 每个可组合函数都应接受一个可选的 Modifier 形参。修饰符会指示界面元素如何在其父布局中放置、显示或表现。
@Composable
fun GreetingImage(message: String,from: String, modifier: Modifier = Modifier) {
    // painterResource() 函数会加载可绘制图片资源，并将资源 ID（在本例中为 R.drawable.androidparty）作为实参。
    val image = painterResource(id = R.drawable.androidparty)

    // Box 布局是 Compose 中的标准布局元素之一。使用 Box 布局可将元素堆叠在一起。
    // Box 布局还可用于配置它所包含的元素的特定对齐方式。
    Box {
        // 即时，可通过Image可组合函数来render图片资源
        Image(
            // 图片资源
            painter = image,
            // 无障碍文本描述
            contentDescription = null,
            // 图片适应模式
            contentScale = ContentScale.FillWidth,
            // 透明度
            alpha = 0.5F
        )
        GreetingText(
            message = message,
            from = from,
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    start = 10.dp,
                    top = 10.dp,
                    end = 10.dp,
                    bottom = 10.dp
                )
        )
    }
}

@Preview(
    name = "我的预览",
    showBackground = true,
    showSystemUi = true
)
@Composable
fun BirthdayCardPreview() {
    HappyBirthdayTheme {
        GreetingImage(
            message = stringResource(R.string.happy_birthday_text),
            from = stringResource(R.string.signature_text)
        )
    }
}

/**
 * 要点总结
 * 1.Jetpack Compose 是用于构建 Android 界面的新款工具包。它使用更少的代码、强大的工具和直观的 Kotlin API，可以帮助您简化并加快 Android 界面开发。
 * 2.应用的界面 (UI) 就是您在屏幕上所看到的内容，包括文本、图片、按钮和许多其他类型的元素。
 * 3.可组合函数是 Compose 的基本构建块。可组合函数是用于描述界面中某一部分的函数。
 * 4.可组合函数带有 @Composable 注解；此注解可告知 Compose 编译器：此函数用于将数据转换为界面。
 * 5.Compose 中的三个基本标准布局元素是 Column、Row, 和 Box。它们是接受可组合内容的可组合函数，因此您可以在其中放置项目。例如，Row 中的各个子项将彼此相邻地水平放置。
 */

/**
 * 要点总结
 * 1.Android Studio 中的 Resource Manager 标签页可帮助您添加和整理图片及其他资源。
 * 2.Image 可组合项是用于在应用中显示图片的界面元素。
 * 3.Image 可组合项应包含内容说明，以便提高应用的无障碍性。
 * 4.应将向用户显示的文本（例如生日祝福语）提取到字符串资源中，以便让应用更容易翻译成其他语言。
 */