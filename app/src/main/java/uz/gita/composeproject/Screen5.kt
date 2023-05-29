package uz.gita.composeproject

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun Screen5Content() {
    Surface(color = MaterialTheme.colorScheme.background) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                "Activity",
                modifier = Modifier.padding(bottom = 32.dp),
                fontSize = 32.sp,
                fontWeight = FontWeight.ExtraBold,
                fontFamily = FontFamily.Serif
            )

            Row() {
                Text("VISITS", modifier = Modifier.padding(), fontSize = 18.sp, fontWeight = FontWeight.ExtraBold, fontFamily = FontFamily.Serif)
                Text(
                    "FOLLOWING",
                    modifier = Modifier.padding(start = 32.dp),
                    color = Color.Black,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.ExtraBold,
                    fontFamily = FontFamily.Serif
                )
                Text(
                    "YOU",
                    modifier = Modifier.padding(start = 32.dp),
                    color = Color.Black,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.ExtraBold,
                    fontFamily = FontFamily.Serif
                )

            }
            LazyColumn(modifier = Modifier.padding(top = 32.dp), content = {

                itemsIndexed(items5) { index, currentData ->
                    if (index == 0)
                        Text(
                            "YESTERDAY AT PRAGUE",
                            modifier = Modifier.padding(bottom = 32.dp),
                            color = Color.Black,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.ExtraBold,
                            fontFamily = FontFamily.Serif
                        )

                    Item(img = currentData.img, name = currentData.name, type = currentData.type)

                    if (index == 3) {
                        Text(
                            "SATURDAY AT NEW YORK",
                            modifier = Modifier.padding(top = 32.dp, bottom = 24.dp),
                            color = Color.Black,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.ExtraBold,
                            fontFamily = FontFamily.Serif
                        )
                    }
                    if (index != items5.size - 1)
                        Spacer(modifier = Modifier.size(16.dp))
                }

            })
        }
    }


}

val items5 = listOf(
    DataLayout5(R.drawable.pic1, "Amanda", "Bar"),
    DataLayout5(R.drawable.pic2, "Lorem", "Restourant"),
    DataLayout5(R.drawable.pic3, "Start", "Cafe"),
    DataLayout5(R.drawable.pic1, "Gelik", "BBar"),
    DataLayout5(R.drawable.pic2, "Sony", "Lr.PPsd"),
    DataLayout5(R.drawable.pic3, "Bacardi", "PlayStation"),
    DataLayout5(R.drawable.pic1, "Laprima", "Football"),
    DataLayout5(R.drawable.pic2, "Gera", "Bar"),
    DataLayout5(R.drawable.pic3, "Amanda", "Bar"),
    DataLayout5(R.drawable.pic1, "Posiwx", "Bar"),
)

@Preview
@Composable
fun Screen5Preview() {
    Screen5Content()
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun Screen5PreviewNight() {
    Screen5Content()
}