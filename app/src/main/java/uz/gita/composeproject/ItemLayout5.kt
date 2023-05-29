package uz.gita.composeproject

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Item(
    @DrawableRes
    img: Int,
    name: String,
    type: String,
) {

    Row(modifier = Modifier
        .fillMaxWidth()
        .height(100.dp)) {

        Card(
            modifier = Modifier
                .width(100.dp)
                .height(100.dp),
        shape = RoundedCornerShape(20.dp)
        ) {
            Image(
                painter = painterResource(id = img),
                contentDescription = "",
                contentScale = ContentScale.Crop
            )


        }

        Column(modifier = Modifier
            .padding(start = 16.dp).fillMaxHeight()
            , verticalArrangement = Arrangement.SpaceEvenly) {
            Text(text = name, fontWeight = FontWeight.Bold, fontSize = 20.sp)
            Text(text = type, fontSize = 16.sp)
        }
        Row(modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.End,
            verticalAlignment = Alignment.CenterVertically) {
            Icon(modifier = Modifier.size(50.dp), painter = painterResource(id = R.drawable.baseline_add_circle_24), contentDescription ="")

        }


    }

}

val data = DataLayout5(R.drawable.pic1, "Cobra", "Bar")

@Preview
@Composable
fun Preview() {
//    Item(img = uz.gita.composeproject.data.img, name = uz.gita.composeproject.data.name, type = uz.gita.composeproject.data.type)


}