package View

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.trivialapp.R


@Composable
fun SettingsScreen(navController: NavController) {
    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.background_settings),
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.matchParentSize()
        )
    }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = "Difficulty", modifier = Modifier
                .fillMaxWidth(0.4f)
                .padding(start = 10.dp),
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )

            var selectedDifficulty by remember { mutableStateOf("Easy") }
            var expanded by remember { mutableStateOf(false) }

            Box(
                modifier = Modifier
                    .fillMaxWidth(0.9f)
                    .clickable { expanded = true }
                    .background(color = Color.Gray)
            ) {
                Text(
                    text = selectedDifficulty,
                    color = Color.White,
                    modifier = Modifier
                        .padding(16.dp)
                        .align(Alignment.CenterStart)
                )
                Icon(
                    Icons.Default.ArrowDropDown, "Dropdown Icon", Modifier
                        .padding(16.dp)
                        .align(Alignment.CenterEnd), Color.White

                )

                DropdownMenu(
                    expanded = expanded,
                    onDismissRequest = { expanded = false },
                    modifier = Modifier
                        .fillMaxWidth(0.9f)
                        .background(color = Color.LightGray)

                ) {
                    listOf("Easy", "Medium", "Hard").forEach { difficulty ->
                        DropdownMenuItem(
                            text = { Text(text = difficulty, color = Color.White) },
                            onClick = {
                                expanded = false
                                selectedDifficulty = difficulty
                            })
                    }
                }
            }
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = "Rounds", modifier = Modifier
                .fillMaxWidth(0.4f)
                .padding(start = 10.dp),
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )

            var selectedOption by rememberSaveable { mutableStateOf("5") } // Valor inicial
            Text(text = "5")
            RadioButton(
                selected = selectedOption == "5", 
                onClick = { selectedOption = "5" }, 
                colors = RadioButtonDefaults.colors(
                    selectedColor = Color.Gray, 
                    unselectedColor = Color.White 
                )
            )
            Text(text = "10")

            RadioButton(
                selected = selectedOption == "10",
                onClick = { selectedOption = "10" },
                colors = RadioButtonDefaults.colors(
                    selectedColor = Color.Gray,
                    unselectedColor = Color.White
                )
            )

            Text(text = "15")

            RadioButton(
                selected = selectedOption == "15",
                onClick = { selectedOption = "15" },
                colors = RadioButtonDefaults.colors(
                    selectedColor = Color.Gray,
                    unselectedColor = Color.White
                )
            )

        }
    }
}



