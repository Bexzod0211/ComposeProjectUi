package uz.gita.composeproject

import SampleData
import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import uz.gita.composeproject.ui.theme.ComposeProjectTheme

class MainActivity2 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeProjectTheme() {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    Message(Message(author = "Olmos JT", "Hey! How's going!"))
                }
            }
        }
    }
}

data class Message(val author: String, val body: String)
data class Message2(val text: String)

@Composable
fun Message(msg: Message) {
    Row(
        modifier = Modifier.padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = null,
            modifier = Modifier
                .size(64.dp)
                .clip(CircleShape)
        )

        Spacer(modifier = Modifier.padding(4.dp))

        Column() {
            Text(
                text = msg.author,
                color = MaterialTheme.colorScheme.primary,
                style = MaterialTheme.typography.titleSmall
            )
            Text(
                text = msg.body,
                style = MaterialTheme.typography.bodySmall
            )
        }
    }
}

@Preview(
    name = "Message show",
    group = "Components",
    showSystemUi = false,
    showBackground = true,
    device = Devices.PIXEL_4,
    uiMode = Configuration.UI_MODE_NIGHT_NO
)
@Composable
fun MessagePreviewLight() {
    ComposeProjectTheme() {
        Surface() {
            Message(msg = Message("John Doe", "What we call someone withouht body and nose? Nobody knows!"))
        }
    }
}

@Composable
fun Conversation(messages : List<Message>) {
    LazyColumn() {
        items(messages) {
            when(it) {
                is Message -> Message(it)
            }

        }
    }
}

@Preview
@Composable
fun ConversationPreview() {
    ComposeProjectTheme() {
        Conversation(messages = SampleData.conversationSample)
    }
}


@Preview(
    name = "Message show",
    group = "Components",
    showSystemUi = false,
    showBackground = true,
    device = Devices.PIXEL_4,
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Composable
fun MessagePreviewDark() {
    ComposeProjectTheme() {
        Surface() {
            Message(msg = Message("John Doe", "What we call someone withouht body and nose? Nobody knows!"))
        }
    }
}