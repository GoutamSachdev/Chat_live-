package com.example.chat_live

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.chat_live.Screens.ChatScreenList
import com.example.chat_live.Screens.LoginScreen
import com.example.chat_live.Screens.Profile
import com.example.chat_live.Screens.SignupScreen
import com.example.chat_live.Screens.SingleChatScreen
import com.example.chat_live.Screens.SingleStatus
import com.example.chat_live.Screens.StatusScreen
import com.example.chat_live.ui.theme.ChatLiveTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay

sealed class DestinationScreen(var route :String){
    object Signup:DestinationScreen("signup")
    object Login:DestinationScreen("login")
    object Profile:DestinationScreen("profile")
    object ChatList:DestinationScreen("chatlist")
    object SingleChat:DestinationScreen("singlechat/{chatId}"){
        fun createRoute(id:String)="singlechat/$id"
    }
    object StatusList:DestinationScreen("statusList")
    object SingleStatus:DestinationScreen("singleStatus/{userId}"){
        fun createRoute(userid:String)="singleStatus/$userid"
    }


}
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ChatLiveTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ChatAppNavigation()
                }
            }
        }
    }
    @Composable
    fun ChatAppNavigation(){
        val navController= rememberNavController()
        var vm=hiltViewModel<CLViewModel>()
        NavHost(navController = navController,startDestination = "SplashScreen"){
            composable("SplashScreen") {
                SplashScreen(navController = navController,onSignUpClick = {
                    navController.navigate("SplashScreen")
                })
            }
            composable(DestinationScreen.Signup.route){
                SignupScreen(navController,vm)
            }
            composable(DestinationScreen.Login.route){
                LoginScreen(navController,vm)
            }
            composable(DestinationScreen.ChatList.route){
                ChatScreenList(navController,vm)
            }
            composable(DestinationScreen.Profile.route){
                Profile(navController,vm)
            }
            composable(DestinationScreen.StatusList.route){
                StatusScreen(navController,vm)
            }
            composable(DestinationScreen.SingleStatus.route){

                 val userId=it.arguments?.getString("userId")
                userId?.let {
                    SingleStatus(navController,vm,userId= userId)
                }

            }
            composable(DestinationScreen.SingleChat.route){
                val chatId=it.arguments?.getString("chatId")
                Log.e("Chat-Live Application",chatId.toString())
                chatId?.let{
                    SingleChatScreen(navController, vm,chatId=chatId)
                }
                }


        }


    }

}
@Composable
fun SplashScreen(navController: NavController, onSignUpClick: () -> Unit){
    LaunchedEffect(Unit) {

        delay(1000) // Wait for 3 seconds

        navController.navigate(DestinationScreen.Login.route)

    }

        Image(
            painter = painterResource(id = R.drawable.splashscreen),
            contentDescription = null,
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth()
        )


}

