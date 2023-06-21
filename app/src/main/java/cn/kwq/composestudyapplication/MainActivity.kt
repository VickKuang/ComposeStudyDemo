package cn.kwq.composestudyapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
            MessageCard(name = "Compose")
        }
    }
}

// Composable 函数一般用大写开头，为了和普通的函数作为区分
@Composable
fun MessageCard(name: String) {
    Row(modifier = Modifier.padding(all = 8.dp)) {
        Image(
            painterResource(id = R.drawable.test),
            contentDescription = "profile picture",
            modifier = Modifier
                .size(50.dp) // 改变 Image 元素的大小
                .clip(CircleShape) // 将图片裁剪成圆形
        )
        Spacer(Modifier.padding(horizontal = 8.dp)) // 添加一个空的控件用来填充水平间距，设置 padding 为 8.dp
        Column {
            Text(text = name)
            Spacer(Modifier.padding(horizontal = 4.dp))
            Text(text = "tessssssssssst")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeStudyApplicationTheme {
        MessageCard("test")
    }
}