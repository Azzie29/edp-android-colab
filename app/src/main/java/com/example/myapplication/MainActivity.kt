package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MaterialTheme {
                GroceryListApp()
            }
        }
    }
}

@Composable
fun GroceryListApp() {

    var newItem by remember { mutableStateOf("") }
    val groceries = remember { mutableStateListOf<String>() }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFFEAF6FF),
                        Color(0xFFF8FCFF)
                    )
                )
            )
    ) {



        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(190.dp)
                .background(
                    Brush.verticalGradient(
                        colors = listOf(
                            Color(0xFF64B5F6),
                            Color(0xFF90CAF9),
                            Color(0xFFBBDEFB)
                        )
                    )
                )
                .padding(horizontal = 24.dp),
            contentAlignment = Alignment.CenterStart
        ) {

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {

                Text(
                    text = "🛍️",
                    fontSize = 42.sp
                )

                Spacer(modifier = Modifier.width(16.dp))

                Column {

                    Text(
                        text = "Grocery List",
                        fontSize = 32.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )

                    Spacer(modifier = Modifier.height(6.dp))

                    Text(
                        text = "Organize your shopping easily",
                        fontSize = 15.sp,
                        color = Color.White.copy(alpha = .9f)
                    )
                }
            }
        }

        Column(
            modifier = Modifier.padding(20.dp)
        ) {


            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(24.dp),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 8.dp
                ),
                colors = CardDefaults.cardColors(
                    containerColor = Color.White
                )
            ) {

                Row(
                    modifier = Modifier.padding(18.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    OutlinedTextField(
                        value = newItem,
                        onValueChange = {
                            newItem = it
                        },
                        label = {
                            Text("Enter grocery item")
                        },
                        placeholder = {
                            Text("Milk, Bread, Eggs...")
                        },
                        singleLine = true,
                        shape = RoundedCornerShape(20.dp),
                        modifier = Modifier.weight(1f)
                    )

                    Spacer(modifier = Modifier.width(12.dp))

                    Button(
                        onClick = {
                            if (newItem.isNotBlank()) {
                                groceries.add(newItem.trim())
                                newItem = ""
                            }
                        },
                        shape = RoundedCornerShape(18.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFF42A5F5)
                        )
                    ) {
                        Text(
                            text = "Add",
                            color = Color.White
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(18.dp))

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .animateContentSize(),
                shape = RoundedCornerShape(24.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color(0xFFE3F2FD)
                ),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 6.dp
                )
            ) {

                Row(
                    modifier = Modifier.padding(18.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Text(
                        text = "📦",
                        fontSize = 28.sp
                    )

                    Spacer(modifier = Modifier.width(14.dp))

                    Column {

                        Text(
                            text = "Items in your cart",
                            fontSize = 14.sp,
                            color = Color.Gray
                        )

                        Spacer(modifier = Modifier.height(2.dp))

                        Text(
                            text = "${groceries.size} item(s)",
                            fontSize = 22.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFF1565C0)
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(18.dp))



            Button(
                onClick = {
                    groceries.clear()
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(55.dp),
                shape = RoundedCornerShape(18.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF1E88E5)
                )
            ) {

                Text(
                    text = "🗑 Clear All",
                    color = Color.White,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold
                )
            }

            Spacer(modifier = Modifier.height(24.dp))

            if (groceries.isEmpty()) {

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(300.dp),
                    contentAlignment = Alignment.Center
                ) {

                    Card(
                        shape = RoundedCornerShape(28.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = Color.White.copy(alpha = 0.95f)
                        ),
                        elevation = CardDefaults.cardElevation(
                            defaultElevation = 5.dp
                        )
                    ) {

                        Column(
                            modifier = Modifier.padding(
                                horizontal = 32.dp,
                                vertical = 28.dp
                            ),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {

                            Text(
                                text = "🧺",
                                fontSize = 72.sp
                            )

                            Spacer(modifier = Modifier.height(16.dp))

                            Text(
                                text = "Your list is empty",
                                fontSize = 22.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color(0xFF1565C0)
                            )

                            Spacer(modifier = Modifier.height(8.dp))

                            Text(
                                text = "Add your first grocery item above.",
                                fontSize = 15.sp,
                                color = Color.Gray
                            )
                        }
                    }
                }

            } else {

                LazyColumn(
                    verticalArrangement = Arrangement.spacedBy(14.dp),
                    contentPadding = PaddingValues(bottom = 40.dp)
                ) {                    items(groceries) { item ->

                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .animateContentSize(),
                        shape = RoundedCornerShape(22.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = Color.White
                        ),
                        elevation = CardDefaults.cardElevation(
                            defaultElevation = 6.dp
                        )
                    ) {

                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(18.dp),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {

                            Row(
                                verticalAlignment = Alignment.CenterVertically
                            ) {

                                Text(
                                    text = "🛒",
                                    fontSize = 28.sp
                                )

                                Spacer(modifier = Modifier.width(14.dp))

                                Column {

                                    Text(
                                        text = item,
                                        fontSize = 18.sp,
                                        fontWeight = FontWeight.SemiBold,
                                        color = Color(0xFF1565C0)
                                    )

                                    Spacer(modifier = Modifier.height(2.dp))

                                    Text(
                                        text = "Ready to buy",
                                        fontSize = 13.sp,
                                        color = Color.Gray
                                    )
                                }
                            }

                            Button(
                                onClick = {
                                    groceries.remove(item)
                                },
                                shape = RoundedCornerShape(16.dp),
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = Color(0xFFEF5350)
                                )
                            ) {

                                Text(
                                    text = "Delete",
                                    color = Color.White
                                )
                            }
                        }
                    }
                }
                }
            }
        }
    }
}