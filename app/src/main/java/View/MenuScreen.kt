package View

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
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
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.trivialapp.R
import viewModel.TriviaSettingsViewModel


@Composable
fun MenuScreen(navController: NavController, settingsViewModel: TriviaSettingsViewModel) {
    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.menu_background),
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.matchParentSize()
        )
    }

    Column (
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Image(painter = painterResource(id = R.drawable.trivia_logo), contentDescription = "Logo")
        Spacer(modifier = Modifier.height(15.dp))

        var expanded by remember { mutableStateOf(false) }
        Box(
            modifier = Modifier
                .fillMaxWidth(0.9f)
                .clickable { expanded = true }
                .background(color = Color.Gray)
        ) {
            Text(
                text = settingsViewModel.selectedTopic,
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
                listOf("History", "Tecnology", "Cinema and Games", "Mitology", "All").forEach { topic ->
                    DropdownMenuItem(text = { Text(text = topic, color = Color.White,) }, onClick = {
                        expanded = false
                        settingsViewModel.modifyTopic(topic)
                    })
                }
            }
        }
        Spacer(modifier = Modifier.fillMaxHeight(0.02f))
        Button(onClick = { /*TODO*/ },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Gray,
                contentColor = Color.White),
            modifier = Modifier
                .fillMaxWidth(0.9f)
                .height(50.dp),) {
            Text(text = "New game")

        }
        Spacer(modifier = Modifier.fillMaxHeight(0.02f))
        Button(onClick = { navController.navigate(Routes.SettingsScreen.route) },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Gray,
                contentColor = Color.White),
            modifier = Modifier
                .fillMaxWidth(0.9f)
                .height(50.dp),) {
            Text(text = "Settings")

        }
    }
}