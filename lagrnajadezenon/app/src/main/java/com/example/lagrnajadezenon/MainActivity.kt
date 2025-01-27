package com.example.lagrnajadezenon

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lagrnajadezenon.ui.theme.MyAppTheme
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyAppTheme {
                RegistroProduccionScreen()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegistroProduccionScreen() {
    var fecha by remember { mutableStateOf(getFechaActual()) }
    var numeroJaula by remember { mutableStateOf("") }
    var cantidadHuevos by remember { mutableStateOf("") }
    val registros = remember { mutableStateListOf<String>() } // Lista para guardar los registros.

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "Registro de Producción",
            style = MaterialTheme.typography.titleLarge
        )

        // Campo para la fecha (bloqueado para edición).
        OutlinedTextField(
            value = fecha,
            onValueChange = { fecha = it },
            label = { Text("Fecha") },
            readOnly = true,
            modifier = Modifier.fillMaxWidth()
        )

        // Campo para el número de jaula.
        OutlinedTextField(
            value = numeroJaula,
            onValueChange = { numeroJaula = it },
            label = { Text("Número de Jaula") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )

        // Campo para la cantidad de huevos.
        OutlinedTextField(
            value = cantidadHuevos,
            onValueChange = { cantidadHuevos = it },
            label = { Text("Cantidad de Huevos") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )

        // Botón para guardar los datos.
        Button(
            onClick = {
                if (numeroJaula.isNotEmpty() && cantidadHuevos.isNotEmpty()) {
                    val registro = "Fecha: $fecha, Jaula: $numeroJaula, Huevos: $cantidadHuevos"
                    registros.add(registro)
                    numeroJaula = ""
                    cantidadHuevos = ""
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Guardar Registro")
        }

        // Mostrar registros guardados.
        Text(
            text = "Registros Guardados:",
            style = MaterialTheme.typography.titleMedium
        )

        registros.forEach { registro ->
            Text(text = registro, style = MaterialTheme.typography.bodyLarge)
        }
    }
}

// Función para obtener la fecha actual.
fun getFechaActual(): String {
    val dateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
    return dateFormat.format(Date())
}

@Preview(showBackground = true)
@Composable
fun RegistroProduccionPreview() {
    MyAppTheme {
        RegistroProduccionScreen()
    }
}
