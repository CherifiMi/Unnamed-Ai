package com.example.unnamedai

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.ViewModel
import com.example.unnamedai.domain.model.Conversation
import com.example.unnamedai.domain.model.Msg
import com.example.unnamedai.domain.use_case.UseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject




//delete from history **
// convorsation from history **


sealed class MainEvents {
    object SwipeSplachScreen : MainEvents()

    object ClickWelcome : MainEvents()

    object ClickChatSetter : MainEvents()

    object PressDoneOnKeyboard : MainEvents()

    object ClickStartNewChat : MainEvents()
    object ClickGoToHistory : MainEvents()
    object ClickBacFromHistory : MainEvents()
    data class DeleteConversationFromHistory(val id: Int): MainEvents()
    data class SelectConversationFromHistory(val id: Int): MainEvents()
}

data class MainState(
    //main
    val showChatScreen: MutableState<Boolean> = mutableStateOf(false),
    val showHistoryScreen: MutableState<Boolean> = mutableStateOf(false),
    //start,
    var wlcVisibility: MutableState<Boolean> = mutableStateOf(false),
    var setterVisibility: MutableState<Boolean> = mutableStateOf(false),
    //text fields,
    var youTF: MutableState<String> = mutableStateOf(""),
    var youWhoTF: MutableState<String> = mutableStateOf(""),
    var themTF: MutableState<String> = mutableStateOf(""),
    var themWhoTF: MutableState<String> = mutableStateOf(""),
    //chat,
    var chatTF: MutableState<String> = mutableStateOf(""),
    //data
    val currentConversation: SnapshotStateList<Msg> = mutableStateListOf(),
    var history: List<Conversation> = listOf(),
)

@HiltViewModel
class MainViewModel @Inject constructor(
    private val useCases: UseCases
) : ViewModel() {
    private val _state = mutableStateOf(MainState())
    val state: State<MainState> = _state

    //_state.value = state.value.copy

    fun onEvent(event: MainEvents) {
        when (event) {
            else -> {
                event
            }
        }
    }
}