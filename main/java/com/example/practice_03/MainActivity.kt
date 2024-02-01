package com.example.practice_03

import android.graphics.drawable.Icon
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.practice_03.ui.theme.Practice_03Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Practice_03Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BackgroundImage()
                    Logo(name = "Atharv Mahajan", role = "Android Developer Extraordinaire")
                    footer(phoneNumber = "+1 (587) 555-5555", socialMediaHandle = "@Atharv.ca", emailID ="Atharv@Android.com" )
                }
            }
        }
    }
}
@Composable
fun BackgroundImage() {
    val backgroundImage = painterResource(id = R.drawable.istockphoto_1296077003_612x612)
    Image(
        painter = backgroundImage,
        contentDescription = null,
        modifier = Modifier.fillMaxSize(),
        alpha = 0.6f, // Optional: adjust the alpha/transparency of the background image
                contentScale = ContentScale.FillBounds
    )
}
@Composable
fun TextToBeAdded(name: String, role: String, modifier: Modifier=Modifier){
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = name,
            style = TextStyle(fontSize = 40.sp)

        )
        Text(text = role,
            modifier=modifier.padding(0.dp, 8.dp, 0.dp, 0.dp),
            style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 16.sp,color = Color(0xFF3ddc84))

            )

    }
}

@Composable
fun Logo(name : String, role:String, modifier:Modifier=Modifier){
    val image = painterResource(id = R.drawable.android_logo)
    Box(contentAlignment = Alignment.Center,
        modifier = modifier.padding(bottom = 115.dp)) {


        Column(horizontalAlignment = Alignment.CenterHorizontally) {

            Image(
                painter = image, contentDescription = "Logo",
                Modifier
                    .background(color = Color.Black)
                    .width(130.dp)
                    .height(130.dp)

            )
            TextToBeAdded(name = name, role = role)
        }
    }
}
@Composable
fun footer(phoneNumber:String, socialMediaHandle: String, emailID:String, modifier: Modifier=Modifier){
    Box(contentAlignment = Alignment.BottomCenter, modifier = modifier) {
        Column(horizontalAlignment = Alignment.Start, modifier = Modifier.padding(bottom = 50.dp))
        {
            IconText(icon = Icons.Default.Phone, text = phoneNumber, tint = Color(0xFF3ddc84))
            IconText(icon = Icons.Default.Share, text = socialMediaHandle, tint = Color(0xFF3ddc84))
            IconText(icon = Icons.Default.Email, text = emailID, tint=Color(0xFF3ddc84))

        }
    }
}
@Composable
fun IconText(icon:ImageVector, text:String, modifier: Modifier=Modifier, tint:Color){
    Row(verticalAlignment = Alignment.CenterVertically) {
        Icon(icon, contentDescription = null, tint = tint)
        Spacer(modifier = Modifier.width(20.dp))
        Text(text = text, modifier = Modifier.padding(bottom = 10.dp))

    }


}




@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Practice_03Theme {
      Logo(name = "Atharv Mahajan", role = "Android Developer Extraordinaire")
        footer(phoneNumber = "123", socialMediaHandle = "abc", emailID = "xyz")
        BackgroundImage()

    }
}

