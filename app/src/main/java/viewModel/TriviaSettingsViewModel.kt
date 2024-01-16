package viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class TriviaSettingsViewModel: ViewModel() {
    var selectedTopic:String by mutableStateOf("History")
        private set
    fun modifyTopic (newTopic: String) {
        selectedTopic = newTopic
    }
}