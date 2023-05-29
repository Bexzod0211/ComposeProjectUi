package uz.gita.composeproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import uz.gita.composeproject.ui.theme.ComposeProjectTheme

class Screen1 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeProjectTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {

                }
            }
        }
    }
}


@Composable
fun CalendarWidget() {
    Surface(
        shape = RoundedCornerShape(24.dp),
        shadowElevation = 4.dp,
        modifier = Modifier.size(220.dp,250.dp),
        color = Color(0xFFFFFFFF)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = "9:23", fontWeight = FontWeight.Bold, fontSize = 48.sp, modifier = Modifier.padding(top = 20.dp))
            Text(text = "Monday", fontWeight = FontWeight.Bold, fontSize = 18.sp, modifier = Modifier.padding(top = 8.dp))
            Text(text = "10 January 2020", color = Color(0xFF939393),modifier = Modifier.padding(top = 4.dp))
            Row(horizontalArrangement = Arrangement.spacedBy(12.dp), modifier = Modifier.padding(top = 16.dp)) {
                Box(modifier = Modifier.background(Color(0xFFF1F2F6), shape = RoundedCornerShape(8.dp))) {
                    Image(painter = painterResource(id = R.drawable.ic_message), contentDescription = null,modifier = Modifier.padding(16.dp))

                }
                Box(modifier = Modifier.background(Color(0xFFF1F2F6),  shape = RoundedCornerShape(8.dp))) {
                    Image(painter = painterResource(id = R.drawable.ic_notification), contentDescription = null,modifier = Modifier.padding(16.dp))
                }
            }

            LazyRow(modifier = Modifier.padding(top = 12.dp), horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                items(3){
                    DotIndicator()
                }
            }
        }
    }
}

@Preview
@Composable
fun CalendarPreview() {
    CalendarWidget()
}

@Composable
fun DotIndicator(){
    Box(modifier = Modifier
        .size(6.dp)
        .clip(CircleShape)
        .background(Color(0xFF000000)))
}

/*@Preview
@Composable
fun DotsIndicatorPreview() {
    DotIndicator()
}*/
