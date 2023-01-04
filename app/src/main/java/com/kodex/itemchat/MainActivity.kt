package com.kodex.itemchat

import android.content.res.Configuration.UI_MODE_NIGHT_MASK
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.media.VolumeShaper.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kodex.itemchat.ui.theme.ChatBox

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ChatBox() {
                MessageBox()
            }
        }
    }
}


@Composable
fun MessageBox() {
    Row(modifier = Modifier.fillMaxWidth().padding(all = 8.dp)) {
        Image(painter = painterResource(id = R.drawable.girl4),
            contentDescription = "profile picture",
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .border(1.5.dp, MaterialTheme.colors.secondary, CircleShape)
        )

        Spacer(modifier = Modifier.width(8.dp))

        Column() {
            Text(text = "Маша",
            color = MaterialTheme.colors.secondary,
            style = MaterialTheme.typography.subtitle2)

        Spacer(modifier = Modifier.width(4.dp))

        Surface(shape = MaterialTheme.shapes.medium,
            elevation = 1.dp) {
            Text(text = "Шляпкина",
                style = MaterialTheme.typography.body1,
            modifier = Modifier.padding(all = 4.dp))
            }
        }
    }
}



@Preview(showBackground = true,
    name = "Dark Mode")
@Composable
fun PreviewMessageBox(){
    ChatBox() {
        MessageBox()
    }
}

@Preview(name = "Lite Mode")
@Composable
fun PreviewLiteMessageBox(){
    ChatBox() {
        MessageBox()
    }
}