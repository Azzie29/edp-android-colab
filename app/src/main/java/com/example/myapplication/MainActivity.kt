package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            MyApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    BusinessCard()
                }
            }
        }
    }
}

@Composable
fun BusinessCard() {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    listOf(
                        Color(0xFFF8F4EF),
                        Color(0xFFE9D8C8),
                        Color(0xFFD7C1AA)
                    )
                )
            )
    ) {

        // Background Decoration

        Box(
            modifier = Modifier
                .size(340.dp)
                .offset((-120).dp, (-120).dp)
                .clip(CircleShape)
                .background(Color.White.copy(alpha = .08f))
        )

        Box(
            modifier = Modifier
                .size(240.dp)
                .align(Alignment.BottomEnd)
                .offset(70.dp, 70.dp)
                .clip(CircleShape)
                .background(Color.White.copy(alpha = .08f))
        )

        Box(
            modifier = Modifier
                .size(120.dp)
                .align(Alignment.TopEnd)
                .offset(20.dp, (-25).dp)
                .clip(CircleShape)
                .background(Color.White.copy(alpha = .05f))
        )

        Card(
            modifier = Modifier
                .widthIn(max = 380.dp)
                .padding(16.dp)
                .align(Alignment.Center),
            shape = RoundedCornerShape(36.dp),
            border = BorderStroke(
                1.dp,
                Color(0xFFE5D5C8)
            ),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 16.dp
            ),
            colors = CardDefaults.cardColors(
                containerColor = Color.White.copy(alpha = .96f)
            )
        ) {

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(26.dp)
                    .verticalScroll(rememberScrollState()),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                // Luxury Header

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(180.dp)
                        .clip(RoundedCornerShape(28.dp))
                        .background(
                            Brush.linearGradient(
                                listOf(
                                    Color(0xFF5D4037),
                                    Color(0xFF8D6E63),
                                    Color(0xFFA1887F)
                                )
                            )
                        )
                ) {

                    Text(
                        text = "AU",
                        modifier = Modifier.align(Alignment.Center),
                        fontSize = 110.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = Color.White.copy(alpha = .10f)
                    )

                    Box(
                        modifier = Modifier
                            .size(120.dp)
                            .align(Alignment.TopStart)
                            .offset((-30).dp, (-30).dp)
                            .clip(CircleShape)
                            .background(Color.White.copy(alpha = .08f))
                    )

                    Box(
                        modifier = Modifier
                            .size(90.dp)
                            .align(Alignment.BottomEnd)
                            .offset(20.dp, 20.dp)
                            .clip(CircleShape)
                            .background(Color.White.copy(alpha = .08f))
                    )
                }

                Image(
                    painter = painterResource(R.drawable.picture),
                    contentDescription = "Profile Photo",
                    modifier = Modifier
                        .offset(y = (-75).dp)
                        .size(150.dp)
                        .shadow(20.dp, CircleShape)
                        .clip(CircleShape)
                        .border(
                            5.dp,
                            Color.White,
                            CircleShape
                        ),
                    contentScale = ContentScale.Crop
                )

                Spacer(modifier = Modifier.height((-65).dp))

                Text(
                    text = "Azzie Umbay",
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF4E342E)
                )

                Text(
                    text = "Cagayan de Oro City, Philippines",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color(0xFF8D6E63)
                )

                Spacer(modifier = Modifier.height(10.dp))

                Badge(
                    containerColor = Color(0xFFEADBC8),
                    contentColor = Color(0xFF5D4037)
                ) {
                    Text(
                        text = "BS Information Technology",
                        modifier = Modifier.padding(
                            horizontal = 14.dp,
                            vertical = 5.dp
                        )
                    )
                }

                Spacer(modifier = Modifier.height(14.dp))

                Text(
                    text = "Android Developer • UI Designer",
                    fontStyle = FontStyle.Italic,
                    color = Color(0xFF8D6E63),
                    fontSize = 16.sp
                )

                Spacer(modifier = Modifier.height(22.dp))

                HorizontalDivider()

                Spacer(modifier = Modifier.height(22.dp))

                ContactRow(
                    icon = Icons.Default.Phone,
                    title = "Phone",
                    text = "+63 912 345 6789"
                )

                Spacer(modifier = Modifier.height(14.dp))

                ContactRow(
                    icon = Icons.Default.Email,
                    title = "Email",
                    text = "azzie.umbay@email.com"
                )

                Spacer(modifier = Modifier.height(14.dp))

                ContactRow(
                    icon = Icons.Default.LocationOn,
                    title = "Location",
                    text = "Cagayan de Oro City"
                )

                Spacer(modifier = Modifier.height(28.dp))

                Text(
                    text = "Skills",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF5D4037)
                )

                Spacer(modifier = Modifier.height(14.dp))

                Row(
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {

                    SkillChip("Kotlin")
                    SkillChip("Compose")
                    SkillChip("UI Design")

                }

                Spacer(modifier = Modifier.height(26.dp))

                Text(
                    text = "Connect with Me",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF5D4037)
                )

                Spacer(modifier = Modifier.height(14.dp))

                Row(
                    horizontalArrangement = Arrangement.spacedBy(18.dp)
                ) {

                    SocialButton("GitHub")

                    SocialButton("LinkedIn")

                    SocialButton("Facebook")

                }

                Spacer(modifier = Modifier.height(28.dp))

                Card(
                    modifier = Modifier.fillMaxWidth(),
                    colors = CardDefaults.cardColors(
                        containerColor = Color(0xFFF8F3EE)
                    ),
                    shape = RoundedCornerShape(20.dp),
                    border = BorderStroke(
                        1.dp,
                        Color(0xFFE6D8CB)
                    )
                ) {

                    Column(
                        modifier = Modifier.padding(18.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {

                        Text(
                            text = "\"Design with purpose.\nDevelop with passion.\"",
                            fontStyle = FontStyle.Italic,
                            fontSize = 16.sp,
                            color = Color(0xFF6D4C41)
                        )

                        Spacer(modifier = Modifier.height(10.dp))

                        Text(
                            text = "Creating beautiful Android experiences.",
                            fontSize = 13.sp,
                            color = Color(0xFF8D6E63)
                        )

                    }

                }

                Spacer(modifier = Modifier.height(24.dp))
            }
        }
    }
}

@Composable
fun SkillChip(text: String) {

    Surface(
        shape = RoundedCornerShape(50.dp),
        color = Color(0xFFEBDCCD),
        border = BorderStroke(
            1.dp,
            Color(0xFFD7C2B2)
        ),
        shadowElevation = 2.dp
    ) {

        Text(
            text = text,
            modifier = Modifier.padding(
                horizontal = 18.dp,
                vertical = 8.dp
            ),
            color = Color(0xFF5D4037),
            fontWeight = FontWeight.SemiBold,
            fontSize = 14.sp
        )

    }

}

@Composable
fun SocialButton(name: String) {

    Card(
        modifier = Modifier.size(56.dp),
        shape = CircleShape,
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFFF3E8DE)
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 5.dp
        )
    ) {

        Box(
            modifier = Modifier
                .fillMaxSize()
                .clickable { },
            contentAlignment = Alignment.Center
        ) {

            Text(
                text = name.take(1),
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF6D4C41)
            )

        }

    }

}

@Composable
fun ContactRow(
    icon: androidx.compose.ui.graphics.vector.ImageVector,
    title: String,
    text: String
) {

    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(22.dp),
        border = BorderStroke(
            1.dp,
            Color(0xFFE6D8CB)
        ),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFFF8F3EE)
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 5.dp
        )
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clickable { }
                .padding(
                    horizontal = 16.dp,
                    vertical = 12.dp
                ),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Box(
                modifier = Modifier
                    .size(48.dp)
                    .clip(CircleShape)
                    .background(
                        Brush.linearGradient(
                            listOf(
                                Color(0xFFA1887F),
                                Color(0xFF795548)
                            )
                        )
                    ),
                contentAlignment = Alignment.Center
            ) {

                Icon(
                    imageVector = icon,
                    contentDescription = title,
                    tint = Color.White
                )

            }

            Spacer(modifier = Modifier.width(16.dp))

            Column {

                Text(
                    text = title,
                    color = Color(0xFF9E7E67),
                    fontSize = 12.sp
                )

                Spacer(modifier = Modifier.height(3.dp))

                Text(
                    text = text,
                    fontWeight = FontWeight.SemiBold,
                    color = Color(0xFF4E342E),
                    fontSize = 16.sp
                )

            }

        }

    }

}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun BusinessCardPreview() {

    MyApplicationTheme {

        BusinessCard()

    }

}
