package com.example.unnamedai

import android.content.Context
import android.widget.Toast
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.unnamedai.domain.model.Conversation
import com.example.unnamedai.domain.model.From
import com.example.unnamedai.domain.model.Msg
import com.example.unnamedai.domain.use_case.UseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject


sealed class MainEvents {
    object SwipeSplashScreen : MainEvents()

    object ClickWelcome : MainEvents()

    data class ClickChatSetter(val context: Context) : MainEvents()

    object PressDoneOnKeyboard : MainEvents()

    object ClickStartNewChat : MainEvents()
    object ClickGoToHistory : MainEvents()
    object ClickBacKFromHistory : MainEvents()
    data class DeleteConversationFromHistory(val id: Int) : MainEvents()
    data class SelectConversationFromHistory(val conversation: Conversation) : MainEvents()

    data class ChatTfChanged(val it: String) : MainEvents()

    data class YouTfChanged(val it: String) : MainEvents()
    data class YouWhoTfChanged(val it: String) : MainEvents()
    data class ThemTfChanged(val it: String) : MainEvents()
    data class ThemWhoTfChanged(val it: String) : MainEvents()
}

data class MainState(
    //main
    val showChatScreen: Boolean = false,
    val showHistoryScreen: Boolean = false,
    //start,
    var wlcVisibility: Boolean = false,
    var setterVisibility: Boolean = false,
    //text fields,
    var youTF: String = "",
    var youWhoTF: String = "",
    var themTF: String = "",
    var themWhoTF: String = "",
    //chat,
    var chatTF: String = "",
    //data
    val currentConversation: MutableList<Msg> = mutableListOf(),
    var history: List<Conversation> = listOf(),
)

@HiltViewModel
class MainViewModel @Inject constructor(
    private val useCases: UseCases
) : ViewModel() {

    private val _state = mutableStateOf(MainState())
    val state: State<MainState> = _state


    fun onEvent(event: MainEvents) {
        when (event) {
            MainEvents.SwipeSplashScreen -> _state.value = state.value.copy(wlcVisibility = true)

            MainEvents.ClickWelcome -> _state.value =
                state.value.copy(setterVisibility = true, wlcVisibility = false)

            is MainEvents.ClickChatSetter -> {
                if (
                    state.value.youTF.isBlank() &&
                    state.value.youWhoTF.isBlank() &&
                    state.value.themTF.isBlank() &&
                    state.value.themWhoTF.isBlank()
                ) {

                    Toast.makeText(
                        event.context,
                        "Please fill all the fields",
                        Toast.LENGTH_SHORT
                    ).show()

                    return
                }

                _state.value = state.value.copy(setterVisibility = false, showChatScreen = true)

            }

            MainEvents.PressDoneOnKeyboard -> {
                val content = state.value.chatTF

                _state.value =
                    state.value.copy(
                        currentConversation = state.value.currentConversation
                            .apply { this.add(Msg(From.You, content)) },
                        chatTF = ""
                    )


                viewModelScope.launch {

                    val aiRespond = useCases.askChatGBT(content)

                    delay(1000)

                    withContext(Dispatchers.Main) {
                        _state.value =
                            state.value.copy(
                                currentConversation = state.value.currentConversation
                                    .apply { add(Msg(From.YourAi, aiRespond)) },
                            )

                    }

                    // TODO: every time chatgpt responds, save convo to db

                }
            }

            MainEvents.ClickGoToHistory -> _state.value = state.value.copy(showHistoryScreen = true) //TODO: update history
            MainEvents.ClickBacKFromHistory -> _state.value = state.value.copy(showHistoryScreen = false)
            MainEvents.ClickStartNewChat -> _state.value = state.value.copy(
                setterVisibility = true,
                showHistoryScreen = false,
                showChatScreen = false,
                wlcVisibility = false,
                youTF = "",
                youWhoTF = "",
                themTF = "",
                themWhoTF = "",
                chatTF = "",
                currentConversation = mutableListOf(),
            )

            is MainEvents.DeleteConversationFromHistory -> useCases.deleteConversation(event.id) // TODO: update history
            is MainEvents.SelectConversationFromHistory -> _state.value = state.value.copy(
                currentConversation =
                mutableListOf<Msg>().apply {
                    addAll(
                        event.conversation.talk
                    )
                },
                showHistoryScreen = false
            )

            is MainEvents.ChatTfChanged -> _state.value = state.value.copy(chatTF = event.it)

            is MainEvents.YouTfChanged -> _state.value = state.value.copy(youTF = event.it)
            is MainEvents.YouWhoTfChanged -> _state.value = state.value.copy(youWhoTF = event.it)
            is MainEvents.ThemTfChanged -> _state.value = state.value.copy(themTF = event.it)
            is MainEvents.ThemWhoTfChanged -> _state.value = state.value.copy(themWhoTF = event.it)
        }
    }
}