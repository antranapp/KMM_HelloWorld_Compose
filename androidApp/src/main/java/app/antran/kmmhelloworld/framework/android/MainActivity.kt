package app.antran.kmmhelloworld.framework.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.sp
import app.antran.kmmhelloworld.framework.Addition

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MaterialTheme {
                MainView()
            }
        }
    }
}

@Composable
fun MainView() {

    val addition = Addition()
    val xValue = remember { mutableStateOf(TextFieldValue()) }
    val yValue = remember { mutableStateOf(TextFieldValue()) }

    var result = remember { mutableStateOf(0) }

    Column(
        Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextField(
            value = xValue.value,
            onValueChange = { xValue.value = it },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        TextField(
            value = yValue.value,
            onValueChange = { yValue.value = it },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        
        Button(onClick = {
            result.value = addition.add(xValue.value.text.toInt(), yValue.value.text.toInt())
        }) {
            Text(text = "Calculate Addition")
        }
        
        Text(
            text = "Result = " + result.value,
            fontSize = 30.sp
        )
    }
}
