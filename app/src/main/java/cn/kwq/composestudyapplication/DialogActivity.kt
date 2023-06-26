package cn.kwq.composestudyapplication

import androidx.compose.runtime.*
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.AlertDialog

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.window.Dialog
import cn.kwq.composestudyapplication.ui.theme.ComposeStudyApplicationTheme

class DialogActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeStudyApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting6("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting6(name: String, modifier: Modifier = Modifier) {
    var isShow by remember { mutableStateOf(true) }
    if (isShow){
    AlertDialog(onDismissRequest = { isShow = false },
        title = { Text(text = "标题") },
        text = { Text(text = "内容") },
        confirmButton = {
           TextButton(onClick = { isShow=false }) {
                Text(text = "确定")
           }
        },
        dismissButton = {
            TextButton(onClick = { isShow=false }) {
                Text(text = "取消")
            }
        })

    }
}



@Preview(showBackground = true, name = "DialogActivity")
@Composable
fun GreetingPreview2() {
    ComposeStudyApplicationTheme {
        Greeting6("Android")
    }
}