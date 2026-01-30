package com.example.businesscardapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscardapp.ui.theme.BusinessCardAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BusinessCardAppTheme {
                BusinessCardApp()
            }
        }
    }
}

@Composable
fun BusinessCardApp(modifier: Modifier = Modifier) {
    val iconTint = Color(0xFF1E6F3C)
    val textColor = Color(0xFF081A0E)
    // NOTE: A Surface represents a Material Design Surface - basically
    // a background that the UI content sits on.
    // When it fills the screen, you can think of it as the screen background.
    // We could just use the Box and add a background color to it, but, Surface
    // is the Material-correct way and supports theming and elevation later
    // when we learn more about Material Design
    Surface(
        modifier = modifier.fillMaxSize(),
        color = Color(0xFFD2E8D4)
    ) {
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            // Profile Section
            ProfileSection(
                name = "Stephen Carter",
                title = "Instructor - Software Dev",
                logoResId = R.drawable.android_logo,
                modifier = Modifier
                    .align(Alignment.Center)
                    .padding(horizontal = 24.dp)
            )

            // Contact Section
            ContactSection(
                phone = "+1 (506) 555-1234",
                handle = "@stephencarter",
                email = "stephen.carter@nbcc.ca",
                iconTint = iconTint,
                textColor = textColor,
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(bottom = 48.dp)
            )
        }
    }
}

@Composable
fun ProfileSection(
    name: String,
    title: String,
    logoResId: Int,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = logoResId),
            contentDescription = "Android logo",
            modifier = Modifier
                .background(Color(0xFF0B3042))
                .padding(12.dp)
                .size(100.dp)
        )

        Spacer(modifier = Modifier.height(12.dp))

        Text(
            text = name,
            fontSize = 36.sp,
            color = Color(0xFF081A0E),
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(6.dp))

        Text(
            text = title,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF1E6F3C),
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun ContactSection(
    phone: String,
    handle: String,
    email: String,
    iconTint: Color,
    textColor: Color,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            // this makes column become width of widest row
            .width(IntrinsicSize.Max),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        ContactRow(
            icon = Icons.Filled.Phone,
            iconContentDesc = "Phone",
            text = phone,
            iconTint = iconTint,
            textColor = textColor
        )

        ContactRow(
            icon = Icons.Filled.Share,
            iconContentDesc = "Share",
            text = handle,
            iconTint = iconTint,
            textColor = textColor
        )

        ContactRow(
            icon = Icons.Filled.Email,
            iconContentDesc = "Email",
            text = email,
            iconTint = iconTint,
            textColor = textColor
        )
    }
}

@Composable
fun ContactRow(
    icon: ImageVector,
    iconContentDesc: String,
    text: String,
    iconTint: Color,
    textColor: Color,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = icon,
            contentDescription = iconContentDesc,
            tint = iconTint
        )

        Spacer(modifier = Modifier.width(16.dp))

        Text(
            text = text,
            color = textColor,
            fontSize = 16.sp
        )
    }
}

@Preview(showBackground = true)
@Composable
fun BusinessCardPreview() {
    BusinessCardApp()
}
