package uz.gita.composeproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import uz.gita.composeproject.ui.theme.ComposeProjectTheme
import uz.gita.composeproject.ui.theme.Green

class Screen4 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeProjectTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    Screen4Content()
                }
            }
        }
    }
}

@Composable
fun Screen4Content(){
    Surface {
        Column(modifier = Modifier.fillMaxSize()) {
            Text(text = "Messages", color = Color.Black, fontWeight = FontWeight.Bold, fontSize = 24.sp, modifier = Modifier.padding(top = 16.dp, start = 16.dp))
            LazyRow(modifier = Modifier.padding(top = 8.dp))     {
                items(tabs) {
                    TabsItem(tab = it)
                }
            }
            LazyColumn(modifier = Modifier.padding(top = 16.dp)) {
                items(messages){
                    MessageItem(it)
                }

            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun Screen4Preview() {
    Screen4Content()
}

@Composable
fun TabsItem(tab:TabsData) {
    Box(modifier = Modifier
        .padding(start = 16.dp)
        .wrapContentSize()
        .background(color = colorResource(id = tab.background), shape = RoundedCornerShape(8.dp))){
        Text(text = tab.name, color = tab.textColor, modifier = Modifier.padding(horizontal = 24.dp, vertical = 4.dp), fontSize = 18.sp)
    }

}

/*
@Preview
@Composable
fun TabsItemPreview() {
    TabsItem(TabsData("All Chats",R.color.green,Color.White))
}*/

val tabs = listOf(
    TabsData("All Chats",R.color.green,Color.White),
    TabsData("Personal"),
    TabsData("Work")
)

data class TabsData(val name:String,val background:Int = R.color.white,val textColor:Color = Color.Black)

@Composable
fun MessageItem(message:MessageData) {
    Row(modifier = Modifier
        .heightIn(min = 80.dp)
        .fillMaxWidth()) {
        Box(modifier = Modifier.background(color = Color.White, shape = RoundedCornerShape(30.dp))) {
            Image(painter = painterResource(id = R.drawable.man), contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .padding(vertical = 10.dp, horizontal = 16.dp)
                    .size(60.dp)
                    .clip(CircleShape))
        }
        Column(modifier = Modifier
            .weight(1f)
            .padding(start = 10.dp, top = 10.dp)) {
            Text(text = message.name, color = Color.Black,fontSize = 20.sp, fontWeight = FontWeight.Bold)
            Text(text = message.message, color = Color.Gray, modifier = Modifier.padding(top = 8.dp))
        }
        Text(text = message.time, modifier = Modifier
            .padding(end = 16.dp)
            .align(Alignment.CenterVertically))
    }
}

@Preview
@Composable
fun MessageItemPreview() {
//    MessageItem()
}

data class MessageData(
    val name:String,
    val message:String,
    val time:String = "just now"
)

val messages = listOf(
    MessageData("Tyra Dhillon","Yes, that's gonna work, hopefully","15:12"),
    MessageData("Krishna Barbe","Hello guys, we have discussed about..."),
    MessageData("Eshan Terrel","Thanks dude","10:17"),
    MessageData("Beck Bowes","You can use new method ...","Yesterday"),
    MessageData("Cameron Williamson","Voice message","Yesterday"),
    MessageData("Eleanor Pena","Voice message","2 Days Ago")
)