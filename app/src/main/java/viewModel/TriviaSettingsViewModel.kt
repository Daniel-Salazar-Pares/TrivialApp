package viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class TriviaSettingsViewModel: ViewModel() {
    var selectedTopic: String by mutableStateOf("History")
        private set

    fun modifyTopic(newTopic: String) {
        selectedTopic = newTopic
    }

    var difficulty: String by mutableStateOf("Easy")
        private set

    fun modifyDifficulty(newDifficulty: String) {
        difficulty = newDifficulty
    }

    var rounds: Int by mutableIntStateOf(5)
        private set

    fun modifyRounds(newRounds: Int) {
        rounds = newRounds
    }

    var time: Float by mutableFloatStateOf(10f)
        private set

    fun modifyTime(newTime: Float) {
        time = newTime
    }

    var darkMode: Boolean by mutableStateOf(false)
        private set

    fun modifyDarkMode(newMode:Boolean) {
        darkMode = newMode
    }
}