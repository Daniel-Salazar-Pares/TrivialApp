package View

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
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
import viewModel.TriviaSettingsViewModel
import kotlin.math.roundToInt


@Composable
fun SettingsScreen(navController: NavController, settingsViewModel: TriviaSettingsViewModel) {
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
            Text(
                text = "Difficulty", modifier = Modifier
                    .fillMaxWidth(0.4f)
                    .padding(start = 10.dp),
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )

            var expanded by remember { mutableStateOf(false) }


            Box(
                modifier = Modifier
                    .fillMaxWidth(0.9f)
                    .clickable { expanded = true }
                    .background(color = Color.Gray)
            ) {
                Text(
                    text = settingsViewModel.difficulty,
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
                                settingsViewModel.modifyDifficulty(difficulty)
                            })
                    }
                }
            }
        }
        Spacer(modifier = Modifier.fillMaxHeight(0.025f))
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Rounds", modifier = Modifier
                    .fillMaxWidth(0.4f)
                    .padding(start = 10.dp),
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )

            Text(text = "5")
            RadioButton(
                selected = settingsViewModel.rounds == 5,
                onClick = { settingsViewModel.modifyRounds(5) },
                colors = RadioButtonDefaults.colors(
                    selectedColor = Color.Gray,
                    unselectedColor = Color.White
                )
            )
            Text(text = "10")

            RadioButton(
                selected = settingsViewModel.rounds == 10,
                onClick = { settingsViewModel.modifyRounds(10) },
                colors = RadioButtonDefaults.colors(
                    selectedColor = Color.Gray,
                    unselectedColor = Color.White
                )
            )

            Text(text = "15")

            RadioButton(
                selected = settingsViewModel.rounds == 15,
                onClick = { settingsViewModel.modifyRounds(15) },
                colors = RadioButtonDefaults.colors(
                    selectedColor = Color.Gray,
                    unselectedColor = Color.White
                )
            )

        }
        Spacer(modifier = Modifier.fillMaxHeight(0.025f))
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Time (${settingsViewModel.time.roundToInt()}s)", modifier = Modifier
                    .fillMaxWidth(0.4f)
                    .padding(start = 10.dp),
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
            Box(
                modifier = Modifier
                    .fillMaxWidth(0.9f)
            ) {

                Slider(
                    value =  settingsViewModel.time,
                    onValueChange = { newValue ->
                        settingsViewModel.modifyTime(newValue)
                    },
                    valueRange = 5f..15f,
                    colors = SliderDefaults.colors(
                        thumbColor = Color.Gray,
                        activeTrackColor = Color.LightGray,
                        inactiveTrackColor = Color.White
                    )
                )
            }
        }
        Spacer(modifier = Modifier.fillMaxHeight(0.025f))
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Dark mode", modifier = Modifier
                    .fillMaxWidth(0.4f)
                    .padding(start = 10.dp),
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
            Box(
                modifier = Modifier
                    .fillMaxWidth(0.9f)
            ) {
                Switch(
                    checked = settingsViewModel.darkMode,
                    onCheckedChange = { settingsViewModel.modifyDarkMode(!settingsViewModel.darkMode) },
                    colors = SwitchDefaults.colors(
                        uncheckedThumbColor = Color.LightGray,
                        checkedThumbColor = Color.Gray,
                        uncheckedTrackColor = Color.White,
                        checkedTrackColor = Color.DarkGray
                    )
                )
            }
        }
        Spacer(modifier = Modifier.fillMaxHeight(0.05f))
        Button(onClick = { navController.navigate(Routes.MenuScreen.route) },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Gray,
                contentColor = Color.White),
            modifier = Modifier
                .fillMaxWidth(0.9f)
                .height(50.dp),) {
            Text(text = "Back to menu")

        }
    }
}



