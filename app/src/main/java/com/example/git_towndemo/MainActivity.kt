package com.example.git_towndemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.git_towndemo.ui.theme.GitTownDemoTheme

enum class Screen {
    Main, Secondary
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var screen by rememberSaveable { mutableStateOf(Screen.Main) }
            GitTownDemoTheme {
                when (screen) {
                    Screen.Main -> Greeting(
                        name = "Christophe Pelé"
                    ) {
                        screen = Screen.Secondary
                    }
                    Screen.Secondary -> Farewell("Christophe Pelé")
                }
            }
        }
    }

    @Suppress("SameParameterValue")
    @Composable
    private fun Farewell(name: String) {
        Text("Good bye $name")
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier, goToSecondary: () -> Unit) {
    Column {
        Text(
            text = "Hello $name!",
            modifier = modifier
        )
        Button(onClick = {
            goToSecondary()
        }) {
            Text(text = "Go to 2nd screen!")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    GitTownDemoTheme {
        Greeting("Android") {}
    }
}