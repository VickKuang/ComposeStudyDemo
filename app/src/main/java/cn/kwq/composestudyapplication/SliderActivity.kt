package cn.kwq.composestudyapplication

import androidx.compose.runtime.*
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import cn.kwq.composestudyapplication.ui.theme.ComposeStudyApplicationTheme

class SliderActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeStudyApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    var pos by remember { mutableStateOf(0f) }
    Slider(
        value = pos,
        onValueChange = { pos = it },
        colors = SliderDefaults.colors(
            thumbColor = Color.White, // 滑块颜色
            activeTrackColor = Color(0xFF0079D3), // 滑块左侧颜色
            inactiveTrackColor = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.24f) // 滑块右侧颜色
        )
    )
}

@Preview(showBackground = true, name = "Slider")
@Composable
fun SliderPreview() {
    ComposeStudyApplicationTheme {
        Greeting("Android")
    }
}