package cn.kwq.composestudyapplication

import androidx.compose.runtime.*
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import cn.kwq.composestudyapplication.ui.theme.ComposeStudyApplicationTheme

class TextfiledActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeStudyApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting2("Android")
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Greeting2(name: String, modifier: Modifier = Modifier) {
    var text by remember { mutableStateOf("") }
    Column(Modifier.fillMaxSize()){
        TextField(
            modifier = Modifier.fillMaxWidth(),
            value = text,
            onValueChange = { text = it },
            label = { Text("邮箱") }, // 标签动画效果
            singleLine = true, // 单行
            trailingIcon = { Text("@163.com") }, // 尾部图标
        )
        TextField(
            modifier = Modifier.align(Alignment.CenterHorizontally),
            value = text,
            onValueChange = { text = it },
            label = { Text("邮箱") }, // 标签动画效果
            singleLine = true, // 单行
            trailingIcon = { Text("@163.com") }, // 尾部图标
        )
    }

}

@Preview(showBackground = true, name = "Text field")
@Composable
fun TextFiledPreview() {
    ComposeStudyApplicationTheme {
        Greeting2("Android")
    }
}