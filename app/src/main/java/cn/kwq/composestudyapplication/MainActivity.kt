package cn.kwq.composestudyapplication

import android.content.res.Configuration
import android.os.Bundle
import androidx.compose.runtime.*
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import cn.kwq.composestudyapplication.ui.theme.ComposeStudyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeStudyApplicationTheme {
                MessageCard(name = "Compose")
            }

        }
    }
}

// Composable 函数一般用大写开头，为了和普通的函数作为区分
@Composable
fun MessageCard(name: String) {
    var isExpanded by remember { mutableStateOf(false) }

    Surface(
        // Surface 是一个 Material Design 的元素，它可以将其他元素组合在一起
        // modifier = Modifier.fillMaxSize(),// 设置 Surface 的大小为最大
        modifier = Modifier
            .padding(all = 8.dp)
            .clickable { isExpanded=!isExpanded },
        shape = MaterialTheme.shapes.medium, // 设置 Surface 的形状为 Material 提供的默认形状
        shadowElevation = 5.dp // 设置 Surface 的阴影
    ) {
        Row(modifier = Modifier.padding(all = 8.dp)) {
            Image(
                painterResource(id = R.drawable.test),
                contentDescription = "profile picture",
                modifier = Modifier
                    .size(50.dp) // 改变 Image 元素的大小
                    .clip(CircleShape) // 将图片裁剪成圆形
                    .border(
                        1.5.dp,
                        MaterialTheme.colorScheme.secondary,
                        CircleShape
                    )// 添加一个边框 颜色为 Material提供
            )
            Spacer(Modifier.padding(horizontal = 8.dp)) // 添加一个空的控件用来填充水平间距，设置 padding 为 8.dp
            Column {
                Text(
                    text = name,
                    color = MaterialTheme.colorScheme.secondary,// 设置文字颜色
                    style = MaterialTheme.typography.titleLarge // 设置文字样式
                )
                Spacer(
                    Modifier.padding(horizontal = 4.dp)
                )
                Text(
                    // Composable 大小的动画效果
                    modifier = Modifier.animateContentSize(),
                    maxLines = if (!isExpanded){1}else{Int.MAX_VALUE},
                    text = "tessssssssssssjdshdiashdishdishdiasdhasidhsdjasbjcbxjcbsjcbsjdsjbjjcbcjct",
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
    }
}


@Composable
fun MsgCardList(list: List<String>) {
    LazyColumn{
        items(list.size){
            MessageCard(list[it])
        }
    }
}

@Preview(
    showBackground = true,
    name = "Light Mode"
)//普通模式
@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true,
    name = "Dark Mode"
)//黑夜模式
@Composable
fun GreetingPreview() {
    ComposeStudyApplicationTheme {
        MsgCardList(list = listOf<String>("test","test2","test3","test4","test5","test6"))
    }
}