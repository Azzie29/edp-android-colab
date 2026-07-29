package com.example.myapplication

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DarkMode
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.LightMode
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.School
import androidx.compose.material.icons.filled.Tag
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.ui.theme.MyApplicationTheme


@Composable
fun ProfileScreen(
    darkTheme: Boolean,
    onThemeChange: () -> Unit
) {

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp)
        ) {

            IconButton(
                onClick = onThemeChange,
                modifier = Modifier.align(Alignment.TopEnd)
            ) {

                Icon(
                    imageVector = if (darkTheme)
                        Icons.Default.LightMode
                    else
                        Icons.Default.DarkMode,

                    contentDescription = "Toggle Theme",
                    tint = MaterialTheme.colorScheme.primary
                )
            }


            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {


                Spacer(modifier = Modifier.height(40.dp))


                Box(
                    modifier = Modifier
                        .size(140.dp)
                        .clip(CircleShape)
                        .background(MaterialTheme.colorScheme.primary)
                        .border(
                            4.dp,
                            MaterialTheme.colorScheme.tertiary,
                            CircleShape
                        ),

                    contentAlignment = Alignment.Center
                ) {

                    Text(
                        text = "AU",
                        style = MaterialTheme.typography.displaySmall,
                        color = MaterialTheme.colorScheme.onPrimary,
                        fontWeight = FontWeight.Bold
                    )
                }


                Spacer(modifier = Modifier.height(18.dp))


                Text(
                    text = "Azzie Umbay",
                    style = MaterialTheme.typography.headlineMedium,
                    fontWeight = FontWeight.Bold
                )


                Spacer(modifier = Modifier.height(6.dp))


                Text(
                    text = "Aspiring Android Developer",
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.primary
                )


                Spacer(modifier = Modifier.height(6.dp))


                Text(
                    text = "BS Information Technology • BSIT 3-2",
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )


                Spacer(modifier = Modifier.height(28.dp))


                Card(
                    modifier = Modifier
                        .fillMaxWidth(),

                    shape = RoundedCornerShape(24.dp),

                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.surface
                    ),

                    elevation = CardDefaults.cardElevation(
                        defaultElevation = 8.dp
                    )
                ) {

                    Column(
                        modifier = Modifier.padding(16.dp)
                    ) {

                        Text(
                            text = "Personal Information",
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.primary
                        )

                        Spacer(modifier = Modifier.height(4.dp))

                        Text(
                            text = "Basic information and contact details",
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )

                        Spacer(modifier = Modifier.height(10.dp))


                        InfoRow(
                            Icons.Default.Person,
                            "Full Name",
                            "Azzie Umbay"
                        )

                        HorizontalDivider()

                        InfoRow(
                            Icons.Default.Tag,
                            "Section",
                            "BSIT 3 - 2"
                        )

                        HorizontalDivider()

                        InfoRow(
                            Icons.Default.School,
                            "Course",
                            "BS Information Technology"
                        )

                        HorizontalDivider()

                        InfoRow(
                            Icons.Default.Phone,
                            "Mobile Number",
                            "0977 112 8463"
                        )

                        HorizontalDivider()

                        InfoRow(
                            Icons.Default.Email,
                            "Email Address",
                            "aumbay15550@liceo.edu.ph"
                        )
                    }
                }


                Footer()

            }
        }
    }
}


@Composable
fun InfoRow(
    icon: ImageVector,
    label: String,
    value: String
) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 14.dp),

        verticalAlignment = Alignment.CenterVertically
    ) {


        Box(
            modifier = Modifier
                .size(52.dp)
                .clip(CircleShape)
                .background(
                    MaterialTheme.colorScheme.primary.copy(alpha = 0.12f)
                ),

            contentAlignment = Alignment.Center
        ) {

            Icon(
                imageVector = icon,
                contentDescription = label,
                tint = MaterialTheme.colorScheme.primary,
                modifier = Modifier.size(26.dp)
            )
        }


        Spacer(modifier = Modifier.width(18.dp))


        Column(
            modifier = Modifier.weight(1f)
        ) {

            Text(
                text = label,
                style = MaterialTheme.typography.labelMedium,
                color = MaterialTheme.colorScheme.primary
            )


            Text(
                text = value,
                style = MaterialTheme.typography.bodyLarge,
                fontWeight = FontWeight.Medium,
                color = MaterialTheme.colorScheme.onSurface
            )
        }
    }
}



@Composable
fun Footer() {

    Spacer(modifier = Modifier.height(24.dp))

    HorizontalDivider()

    Spacer(modifier = Modifier.height(12.dp))


    Text(
        text = "Built with Jetpack Compose",
        style = MaterialTheme.typography.labelMedium,
        color = MaterialTheme.colorScheme.onSurfaceVariant
    )
}



@Preview(
    showBackground = true,
    showSystemUi = true,
    name = "Light Mode"
)
@Composable
fun ProfileLightPreview() {

    MyApplicationTheme(
        darkTheme = false
    ) {

        ProfileScreen(
            darkTheme = false,
            onThemeChange = {}
        )
    }
}



@Preview(
    showBackground = true,
    showSystemUi = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    name = "Dark Mode"
)
@Composable
fun ProfileDarkPreview() {

    MyApplicationTheme(
        darkTheme = true
    ) {

        ProfileScreen(
            darkTheme = true,
            onThemeChange = {}
        )
    }
}