package com.example.ejercicio1
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            MyComponent()
            
        }
    }
}



@Composable
fun MyComponent() {
    val textState = remember { mutableStateOf("") }
    val context = LocalContext.current // Contexto para el Toast

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Ingresa tu nombre:")

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = textState.value,
            onValueChange = { textState.value = it },
            label = { Text("Nombre") }
        )

        Spacer(modifier = Modifier.height(24.dp))

        Button(onClick = {
            // Función del botón con Toast
            if (textState.value.isNotEmpty()) {
                Toast.makeText(
                    context,
                    "Hola ${textState.value}!",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }) {
            Text("Saludar")
        }
    }
}