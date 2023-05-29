package uz.gita.composeproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
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

class Screen2 : ComponentActivity() {
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

data class PaymentData(@DrawableRes val imageResId: Int, val paymentType: String, val cardNumber: String, val isSelected: Boolean = false)

@Composable
fun PaymentView() {
    Column(modifier = Modifier.fillMaxSize()) {
        LazyColumn {
            items(paymentList) {
                CardItem(data = it)
            }
        }
        Box(
            modifier = Modifier
                .padding(start = 16.dp, end = 16.dp, top = 32.dp)
                .fillMaxWidth()
                .background(Color(0xFFDCB043), shape = RoundedCornerShape(12.dp))
        ) {
            Row(
                modifier = Modifier
                    .size(0.dp, 60.dp)
                    .fillMaxWidth()
            ) {
                Image(painter = painterResource(id = R.drawable.ic_bookmark), contentDescription = null, modifier = Modifier.size(30.dp))
                Text(
                    text = "Promo code", modifier = Modifier
                        .size(0.dp)
                        .fillMaxHeight()
                        .weight(1f), color = Color.White
                )
                Box(
                    modifier = Modifier
                        .size(100.dp, 50.dp)
                        .background(Color(0xFF14121F), shape = RoundedCornerShape(12.dp))
                        .align(Alignment.CenterVertically),
                ) {
                    Text(text = "Apply", color = Color.White, fontSize = 18.sp)
                }
            }
        }
        LazyColumn(
            modifier = Modifier
                .padding(top = 20.dp)
                .background(Color.White)
        ) {
            items(costs) {
                CostsContent(cost = it)
            }
        }
        Spacer(modifier = Modifier.weight(1f))
        Column(verticalArrangement = Arrangement.Bottom) {
            Box(modifier = Modifier
                .padding(start = 16.dp, end = 16.dp, bottom = 16.dp)
                .fillMaxWidth()
                .size(0.dp, 60.dp)
                .background(Color(0xFF14121F), shape = RoundedCornerShape(12.dp))) {
                Text(text = "Pay", modifier = Modifier.align(Alignment.Center), color = Color.White,)
            }
        }
    }


}

@Preview(showSystemUi = true)
@Composable
fun PaymentPreview() {
    PaymentView()
}

val paymentList = listOf(
    PaymentData(R.drawable.img_master_card, "Credit Card", "+1 6006****24", true),
    PaymentData(R.drawable.img_paypal, "Paypal", "5221 **** 2465"),
    PaymentData(R.drawable.img_google, "Google Play", "4142 **** 7667")
)

@Composable
fun CardItem(data: PaymentData) {
    Surface(color = Color.White, modifier = Modifier.padding(top = 16.dp)) {
        Card(
            shape = RoundedCornerShape(8.dp), modifier = Modifier
                .padding(horizontal = 16.dp)
                .fillMaxWidth()
                .size(width = 0.dp, 90.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
            ) {
                Image(
                    painter = painterResource(id = data.imageResId), contentDescription = null, modifier = Modifier
                        .weight(1f)
                        .fillMaxHeight()
                        .padding(22.dp)
                )
                Column(
                    modifier = Modifier
                        .weight(3f)
                        .padding(start = 12.dp), verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Text(text = data.paymentType, fontWeight = FontWeight.Bold, fontSize = 18.sp, modifier = Modifier.padding(top = 16.dp))
                    Text(text = data.cardNumber, fontSize = 14.sp, color = Color.Gray)
                }
                RadioButton(selected = data.isSelected, modifier = Modifier
                    .weight(1f)
                    .align(Alignment.CenterVertically), onClick = {
                })
            }
        }
    }
}

@Composable
fun CostsContent(cost: CostData) {
    Row(
        modifier = Modifier
            .padding(top = 12.dp)
            .fillMaxWidth()
            .background(Color.White)
    ) {
        Text(
            text = cost.name, color = Color.Gray, modifier = Modifier
                .weight(1f)
                .padding(start = 16.dp)
        )
        Text(text = "$${cost.cost}", fontWeight = FontWeight.Bold, color = Color.Black, modifier = Modifier.padding(end = 16.dp))
    }
}

data class CostData(val name: String, val cost: String)


val costs = listOf<CostData>(
    CostData("Transfer Amount", "7.20"),
    CostData("Additional Cost", "0.5"),
    CostData("Total", "7.25"),
)

@Preview
@Composable
fun CostPreview() {
//    CostsContent()
}