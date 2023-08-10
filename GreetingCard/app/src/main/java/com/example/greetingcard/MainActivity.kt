package com.example.greetingcard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
// 导入颜色配置
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.greetingcard.ui.theme.GreetingCardTheme


class MainActivity : ComponentActivity() {
    // 应用程序的入口点
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // 通过可组合setContent函数定义布局
        setContent {
            // 通过GreetingCardTheme来应用主题
            GreetingCardTheme {
                // 使用Surface来创建一个容器，使用主题中定义的背景颜色并填充整个屏幕
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    // 函数内部调用Greeting函数来显示内部语
                    Greeting("Android")
                }
            }
        }
    }
}

// 定义了界面组件（没有返回值，因为它用于描述界面外观）
// 可组合函数可以接受参数，并使用这些参数来动态构建界面
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    // Surface是一个容器，代表界面的某一部分（可以通过传递参数来改变背景颜色或边框等样式）
    Surface (color = Color.Magenta) {
/*        Text(
            text = "Hello $name!",
            // modifier参数用于扩充或修饰可组合项，使用Modifier来修饰样式
            modifier = Modifier.padding(24.dp)
        )*/
    }

    // 行布局
    Column {
        Text(text = "Hello $name")
        Text(text = "Hello Kotlin")
    }
}

// 定义了预览函数
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    GreetingCardTheme {
        Greeting("kotlin")
    }
}

/**
 * 总结
 * - onCreate是程序的入口函数
 * - 通过@Composable注解的函数为可组合函数，可组合函数与常规函数类似，但存在以下区别：
 *  1.函数名称采用首字母大写形式，需在该函数前面添加 @Composable 注解
 *  2.函数无法返回任何内容。
 *  3.接受一些输入并生成屏幕上显示的内容。
 *  4.可能会发出多个界面元素。
 * - Modifier 用于扩充或修饰可组合项。
 */