package com.kodex.itemchat

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.content.res.Configuration.UI_MODE_TYPE_NORMAL
import android.media.VolumeShaper.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kodex.itemchat.MessageData.MessageList
import com.kodex.itemchat.ui.theme.ChatBox

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ChatBox() {
               Convertation(MessageList)
            }
        }
    }
}

data class Message(val sender: String, val body: String)

@Composable
fun Convertation(messageList : List<Message>){
    LazyColumn{
        items(MessageList){
                message -> MessageBox(message)
        }
    }
}


@Composable
fun MessageBox(msg:Message) {
    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(all = 8.dp)) {
        Image(painter = painterResource(id = R.drawable.girl4),
            contentDescription = "profile picture",
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .border(1.5.dp, MaterialTheme.colors.secondary, CircleShape)
        )

        Spacer(modifier = Modifier.width(8.dp))

        var msgExpanded by remember { mutableStateOf(false) }
        val surfaceColorChange : Color by animateColorAsState(
            if(msgExpanded) MaterialTheme.colors.primary else
                 MaterialTheme.colors.surface
        )

        Column(modifier = Modifier.clickable { msgExpanded = !msgExpanded }) {
            Text(text = msg.sender,
            color = MaterialTheme.colors.secondary,
            style = MaterialTheme.typography.subtitle2)

        Spacer(modifier = Modifier.width(4.dp))

        Surface(shape = MaterialTheme.shapes.medium,
            elevation = 1.dp,
        color = surfaceColorChange,
        modifier = Modifier.animateContentSize().padding(1.dp)) {
            Text(text = msg.body,
                style = MaterialTheme.typography.body1,
            modifier = Modifier.padding(all = 4.dp),
            maxLines = if (msgExpanded)Int.MAX_VALUE else 1)

            }
        }
    }
}




@Preview(showBackground = true,
    name = "Dark Mode")
@Composable
fun PreviewMessageBox(){
    ChatBox() {
        Convertation(MessageList)
    }
}

@Preview(name = "Lite Mode")
@Composable
fun PreviewLiteMessageBox(){
    ChatBox() {
        Convertation(MessageList)
    }
}
