package uz.gita.composeproject

import SampleData
import android.os.Bundle
import android.widget.ImageView.ScaleType
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import uz.gita.composeproject.ui.theme.ComposeProjectTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeProjectTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    Column {
                        Image(painter = painterResource(id = R.drawable.ic_launcher_foreground), contentDescription = null)

                    }
                }
            }
        }
    }
}


@Composable
fun viewMessage(message:Message) {
    Column {
        Image(painter = painterResource(id = R.drawable.ic_launcher_foreground), contentDescription = null, modifier = Modifier.size(40.dp,30.dp))
        Text(text = message.author)
        Text(text = message.body)
    }
}


@Composable
fun RecyclerView(messages:List<Message>) {
    LazyColumn{
        items(messages){
            viewMessage(message = it)
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun MessagePreview() {
    RecyclerView(messages = SampleData.conversationSample)
}