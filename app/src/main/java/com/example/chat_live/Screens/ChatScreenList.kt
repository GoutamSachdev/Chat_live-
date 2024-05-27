package com.example.chat_live.Screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.chat_live.CLViewModel
import com.example.chat_live.CommonDivider
import com.example.chat_live.CommonProgressBar
import com.example.chat_live.CommonRow
import com.example.chat_live.DestinationScreen
import com.example.chat_live.TitleText
import com.example.chat_live.navigateTo

@Composable
fun ChatScreenList(navController: NavController, vm: CLViewModel) {

    val inprogress = vm.inProcessChats

    if (inprogress.value) {
        CommonProgressBar()
    } else {
        val chats = vm.chats.value
        val userData = vm.userData
        val showDialog = remember {
            mutableStateOf(false)
        }
        val onFabClick: () -> Unit = { showDialog.value = true }
        val onDismiss: () -> Unit = { showDialog.value = false }
        val onAddChat: (String) -> Unit = {
            vm.onAddChat(it)
            showDialog.value = false

        }

        Scaffold(
            topBar = {
                TitleText(txt = "Chats")
                CommonDivider()
            },
            bottomBar = {
                BottomAppBar(
                    modifier = Modifier
                        .height(50.dp) // Adjust the height as needed
                        .background(color = Color.White)

                        .fillMaxWidth()

                ) {
                    NavigationBottom(
                        SelectedItem = BottomNavigationItem.CHATlIST,
                        navController = navController
                    )
                }
            },
            floatingActionButton = {
                FAB(
                    showDialog = showDialog.value,
                    onFabClick = onFabClick,
                    onDismiss = onDismiss,
                    onAddChat = onAddChat

                )

            },
            floatingActionButtonPosition = FabPosition.End,// Ensures FAB is docked to bottom app bar
            content = { innerPadding ->


                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(innerPadding)
                ) {
                    if (chats.isEmpty()) {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .weight(1f),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ) {
                            Text(text = "NO Chat Available")
                        }
                    } else {
                        LazyColumn(modifier = Modifier.weight(1f)) {
                            items(chats) { chat ->
                                val chatUser = if (chat.user1.userId == userData.value?.userId) {
                                    chat.user2
                                } else {
                                    chat.user1
                                }
                                CommonRow(imageUrl = chatUser.imageUrl, name = chatUser.name) {


                                    chat.chatId?.let {
                                        navigateTo(
                                            navController,
                                            DestinationScreen.SingleChat.createRoute(id = it)
                                        )
                                    }

                                }
                                Spacer(modifier=Modifier.padding(2.dp))
                            }

                        }
                    }

                }
            }
        )

    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FAB(
    showDialog: Boolean,
    onFabClick: () -> Unit,
    onDismiss: () -> Unit,
    onAddChat: (String) -> Unit
) {

    val addChatMember = remember {
        mutableStateOf("")
    }

    if (showDialog) {
        AlertDialog(onDismissRequest = {
            onDismiss.invoke()
            addChatMember.value = ""
        },
            confirmButton = {
                Button(onClick = { onAddChat(addChatMember.value) }) {
                    Text(text = "Add chat")

                }


            },
            title = { Text(text = "Add Chat") },
            text = {
                OutlinedTextField(
                    value = addChatMember.value,
                    onValueChange = { addChatMember.value = it },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                )
            }
        )


    }
    FloatingActionButton(
        onClick = {
            onFabClick.invoke()
        }, containerColor = MaterialTheme.colorScheme.secondary,
        shape = CircleShape,
        modifier = Modifier.padding(bottom = 40.dp)

    ) {
        Icon(
            imageVector = Icons.Filled.Add,
            contentDescription = "Add", tint = Color.White
        )
    }

}

