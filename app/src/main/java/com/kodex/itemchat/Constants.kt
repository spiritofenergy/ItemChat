package com.kodex.itemchat

import android.widget.TextView
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.text.HtmlCompat
//import com.kodex.chatwithfirebase.DatabaseRepository

const val TYPE_DATABASE = "type_database"
const val TYPE_ROOM = "type_room"
const val TYPE_FIREBASE = "type_firebase"
const val FIREBASE_ID = "firebaseId"


//lateinit var REPOSITORY: DatabaseRepository

lateinit  var PASSWORD: String
lateinit var LOGIN: String
var DB_TYPE = mutableStateOf("")

object Constants {
    object Screens {
        const val LOGIN_SCREEN = "login_screen"
        const val CHAT_SCREEN = "chat_screen"
        const val SPLASH_SCREEN = "splash_screen"
        const val MAIN_SCREEN = "main_screen"
        const val SIGNIN_SCREEN = "signin_screen"
        const val HOME_SCREEN = "home_screen"
        const val FOOD_SCREEN = "food_screen"
        const val MUSIC_SCREEN = "music_screen"
        const val DETAIL_SCREEN = "detail_screen"
        const val MOVIES_SCREEN = "movies_screen"
        const val START_SCREEN = "start_screen"
        const val ADD_SCREEN = "add_screen"
        const val NOTE_SCREEN = "note_screen"


    }

    object Keys {
        const val ENTER_LOG_IN = "Введите Email и Пароль"
        const val NOTES_DATABASE = "notes_database"
        const val NOTES_TABLE = "notes_table"
        const val NOTE_TITLE = "Заметка"
        const val NOTE_SUBTITLE = "Подробнее"
        const val ADD_NOTE = "Новое дело"
        const val SAFE_NOTE = "Сохранить дело"
        const val TITLE = "title"
        const val NAME = "name"
        const val MESSAGE = "message"
        const val WAT_WELL_WE_YSE = "Сохранить"
        const val ROOM_DATABASE = "Room_database"
        const val FIREBASE_DATABASE = "Firebase_database"
        const val ID = "Id"
        const val NOTE = "note"
        const val UPDATE_NOTE = "Изменить"
        const val DELETE = "Удалить"
        const val NAV_BECK = "Назад"
        const val EDIT_NOTE = "Изменить"
        const val LOG_IN = "Log in"
        const val EMPTY = ""
        const val SAFE_ROOM = "Room"
        const val SAFE_FIREBASE = "Firebase"
        const val SING_IN = "Регистрация"
        const val LOGIN_TEXT = "Email"
        const val PASSWORD_TEX = "Пароль"
        const val ADD_BUSINESS = "Добавить бизнес"
        const val ACTIVITY = "Вид деятельности"
        const val ADD = "Добавить"
        const val IS_REGISTERED = "Вы зарегистрированы        "
        const val NOT_REGISTERED = "Вы не зарегистрированы       "
    }

}
@Composable
fun HtmlText(html: String, modifier : Modifier = Modifier){
    AndroidView(
        modifier = Modifier,
        factory = { context -> TextView(context) },
        update = { it.text = HtmlCompat.fromHtml(html, HtmlCompat.FROM_HTML_MODE_COMPACT) }
    )

}