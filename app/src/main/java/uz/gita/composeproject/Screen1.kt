package uz.gita.composeproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import uz.gita.composeproject.ui.theme.ComposeProjectTheme

class ScreenLogin : ComponentActivity() {
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginComponent() {
    val textFieldColors = TextFieldDefaults.textFieldColors(
        textColor = Color.White,
        cursorColor = Color.White,
        unfocusedLabelColor = Color.White,
        focusedLabelColor = Color.White,
        unfocusedIndicatorColor = Color.White,
        focusedIndicatorColor = Color.White,
        errorCursorColor = Color.White,
        errorTrailingIconColor = Color.White,
        containerColor = Color.Transparent
    )
    Surface(color = Color(0xFF2E3A55)) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Image(painter = painterResource(id = R.drawable.img_top), contentDescription = null, modifier = Modifier
                .padding(top = 80.dp)
                .size(150.dp, 150.dp))
            Text(text = "mygoals", color = Color.White, modifier = Modifier.padding(top = 20.dp), fontSize = 40.sp)
            Text(text = "Email", color = Color.White, modifier = Modifier
                .padding(top = 60.dp, start = 32.dp)
                .align(Alignment.Start))
            TextField(
                modifier = Modifier.padding(horizontal = 32.dp).fillMaxWidth(),
                value = "",
                onValueChange = { newText ->
                },
                colors = textFieldColors,
                placeholder = { Text(text = "Johndoe@gmail.com", color = Color.White) },
                textStyle = TextStyle().merge(TextStyle(textDecoration = TextDecoration.None))
            )
            Text(text = "Password", color = Color.White, modifier = Modifier
                .padding(top = 24.dp, start = 32.dp)
                .align(Alignment.Start))
            TextField(
                modifier = Modifier.padding(horizontal = 32.dp).fillMaxWidth(),
                value = "",
                onValueChange = { newText ->
                },
                colors = textFieldColors,
                placeholder = { Text(text = "******", color = Color.White) },
                textStyle = TextStyle().merge(TextStyle(textDecoration = TextDecoration.None))
            )
            Text(text = "Forgot password?", color = Color.White, modifier = Modifier.padding(top = 8.dp))
            Box(modifier = Modifier
                .padding(top = 50.dp)
                .background(Color(0xFF98EEB6), shape = RoundedCornerShape(25.dp))
                .size(200.dp, 50.dp),) {
                Text(text = "Log In", modifier = Modifier.align(Alignment.Center), fontSize = 18.sp)
            }

            Text(text ="Don't have an account?",modifier = Modifier.padding(top = 40.dp), color = Color.Gray)
            Text(text ="Create an Account",modifier = Modifier.padding(top = 4.dp), color = Color.White)
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun LoginPreview() {
    LoginComponent()
}

