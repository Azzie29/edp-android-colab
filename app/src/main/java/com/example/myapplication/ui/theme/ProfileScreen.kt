package com.example.myapplication.ui.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun ProfileForm(
    state: ProfileUiState,
    viewModel: ProfileViewModel
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(PastelBackground)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Spacer(modifier = Modifier.height(10.dp))

            Box(
                modifier = Modifier
                    .size(72.dp)
                    .clip(CircleShape)
                    .background(PastelLavender),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "♡",
                    fontSize = 36.sp,
                    color = PastelPurpleDark
                )
            }

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = "My Profile",
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                color = PastelText
            )

            Text(
                text = "Tell us a little about you ✨",
                fontSize = 14.sp,
                color = PastelTextLight
            )

            Spacer(modifier = Modifier.height(20.dp))

            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(24.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color.White
                ),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 4.dp
                )
            ) {
                Column(
                    modifier = Modifier.padding(18.dp)
                ) {

                    Text(
                        text = "Personal Information",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = PastelPurpleDark
                    )

                    Spacer(modifier = Modifier.height(14.dp))

                    CuteTextField(
                        value = state.name,
                        onValueChange = {
                            viewModel.onNameChange(it)
                        },
                        label = "Full name"
                    )

                    Spacer(modifier = Modifier.height(10.dp))

                    CuteTextField(
                        value = state.email,
                        onValueChange = {
                            viewModel.onEmailChange(it)
                        },
                        label = "Email"
                    )

                    Spacer(modifier = Modifier.height(10.dp))

                    CuteTextField(
                        value = state.contactNumber,
                        onValueChange = {
                            viewModel.onContactChange(it)
                        },
                        label = "Contact number"
                    )

                    Spacer(modifier = Modifier.height(10.dp))

                    CuteTextField(
                        value = state.address,
                        onValueChange = {
                            viewModel.onAddressChange(it)
                        },
                        label = "Address"
                    )

                    Spacer(modifier = Modifier.height(10.dp))

                    CuteTextField(
                        value = state.username,
                        onValueChange = {
                            viewModel.onUsernameChange(it)
                        },
                        label = "Username"
                    )
                }
            }

            Spacer(modifier = Modifier.height(18.dp))

            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(24.dp),
                colors = CardDefaults.cardColors(
                    containerColor = PastelCream
                ),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 2.dp
                )
            ) {
                Column(
                    modifier = Modifier.padding(18.dp)
                ) {

                    Text(
                        text = "My Skills ♡",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = PastelPinkDark
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        OutlinedTextField(
                            value = state.newSkill,
                            onValueChange = {
                                viewModel.onNewSkillChange(it)
                            },
                            label = {
                                Text("Add a skill")
                            },
                            singleLine = true,
                            modifier = Modifier.weight(1f),
                            shape = RoundedCornerShape(16.dp),
                            colors = OutlinedTextFieldDefaults.colors(
                                focusedBorderColor = PastelPinkDark,
                                unfocusedBorderColor = PastelPink,
                                focusedLabelColor = PastelPinkDark,
                                cursorColor = PastelPinkDark
                            )
                        )

                        Spacer(modifier = Modifier.width(8.dp))

                        Button(
                            onClick = {
                                viewModel.addSkill()
                            },
                            shape = RoundedCornerShape(16.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = PastelPink,
                                contentColor = PastelText
                            )
                        ) {
                            Text(
                                text = "Add",
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(10.dp))

                    state.skills.forEach { skill ->

                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 3.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {

                            Box(
                                modifier = Modifier
                                    .size(30.dp)
                                    .clip(CircleShape)
                                    .background(Color.White),
                                contentAlignment = Alignment.Center
                            ) {
                                Text(
                                    text = "♡",
                                    color = PastelPinkDark,
                                    fontSize = 15.sp
                                )
                            }

                            Spacer(modifier = Modifier.width(8.dp))

                            Text(
                                text = skill,
                                modifier = Modifier.weight(1f),
                                color = PastelText,
                                fontSize = 15.sp
                            )

                            TextButton(
                                onClick = {
                                    viewModel.removeSkill(skill)
                                }
                            ) {
                                Text(
                                    text = "Remove",
                                    color = PastelPinkDark
                                )
                            }
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            Button(
                onClick = {
                    viewModel.showPreview()
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(54.dp),
                shape = RoundedCornerShape(18.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = PastelPurple,
                    contentColor = Color.White
                )
            ) {
                Text(
                    text = "View My Profile ✨",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            Spacer(modifier = Modifier.height(20.dp))
        }
    }
}

@Composable
private fun CuteTextField(
    value: String,
    onValueChange: (String) -> Unit,
    label: String
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = {
            Text(label)
        },
        singleLine = true,
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = PastelPurpleDark,
            unfocusedBorderColor = PastelPurple,
            focusedLabelColor = PastelPurpleDark,
            unfocusedLabelColor = PastelTextLight,
            cursorColor = PastelPurpleDark,
            focusedContainerColor = Color.White,
            unfocusedContainerColor = Color.White
        )
    )
}

@Composable
fun ProfilePreview(
    state: ProfileUiState,
    onBack: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(PastelBackground)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Spacer(modifier = Modifier.height(20.dp))

            Box(
                modifier = Modifier
                    .size(80.dp)
                    .clip(CircleShape)
                    .background(PastelLavender),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "♡",
                    fontSize = 40.sp,
                    color = PastelPurpleDark
                )
            }

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = "Profile Preview",
                fontSize = 27.sp,
                fontWeight = FontWeight.Bold,
                color = PastelText
            )

            Text(
                text = "Here's a little about me ✨",
                fontSize = 14.sp,
                color = PastelTextLight
            )

            Spacer(modifier = Modifier.height(20.dp))

            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(26.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color.White
                ),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 5.dp
                )
            ) {
                Column(
                    modifier = Modifier.padding(22.dp)
                ) {

                    Text(
                        text = "Personal Details",
                        fontSize = 19.sp,
                        fontWeight = FontWeight.Bold,
                        color = PastelPurpleDark
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    ProfileInfo(
                        title = "Name",
                        value = state.name
                    )

                    ProfileInfo(
                        title = "Email",
                        value = state.email
                    )

                    ProfileInfo(
                        title = "Contact",
                        value = state.contactNumber
                    )

                    ProfileInfo(
                        title = "Address",
                        value = state.address
                    )

                    ProfileInfo(
                        title = "Username",
                        value = state.username
                    )

                    Spacer(modifier = Modifier.height(14.dp))

                    Text(
                        text = "Skills ♡",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = PastelPinkDark
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    if (state.skills.isEmpty()) {

                        Text(
                            text = "No skills added yet.",
                            color = PastelTextLight,
                            fontSize = 14.sp
                        )

                    } else {

                        state.skills.forEach { skill ->

                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(vertical = 4.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {

                                Box(
                                    modifier = Modifier
                                        .size(26.dp)
                                        .clip(CircleShape)
                                        .background(PastelLavender),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Text(
                                        text = "✓",
                                        color = PastelPurpleDark,
                                        fontSize = 13.sp,
                                        fontWeight = FontWeight.Bold
                                    )
                                }

                                Spacer(modifier = Modifier.width(8.dp))

                                Text(
                                    text = skill,
                                    color = PastelText,
                                    fontSize = 15.sp
                                )
                            }
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            OutlinedButton(
                onClick = onBack,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(52.dp),
                shape = RoundedCornerShape(18.dp),
                colors = ButtonDefaults.outlinedButtonColors(
                    contentColor = PastelPurpleDark
                )
            ) {
                Text(
                    text = "Back to Edit",
                    fontWeight = FontWeight.Bold
                )
            }

            Spacer(modifier = Modifier.height(20.dp))
        }
    }
}

@Composable
private fun ProfileInfo(
    title: String,
    value: String
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 12.dp)
    ) {
        Text(
            text = title,
            fontSize = 12.sp,
            color = PastelTextLight,
            fontWeight = FontWeight.Medium
        )

        Spacer(modifier = Modifier.height(2.dp))

        Text(
            text = if (value.isEmpty()) "Not provided" else value,
            fontSize = 16.sp,
            color = PastelText,
            fontWeight = FontWeight.Medium
        )
    }
}

@Composable
fun ProfileScreen(
    viewModel: ProfileViewModel = viewModel()
) {
    val state by viewModel.uiState.collectAsStateWithLifecycle()

    if (state.isPreview) {
        ProfilePreview(
            state = state,
            onBack = {
                viewModel.backToEdit()
            }
        )
    } else {
        ProfileForm(
            state = state,
            viewModel = viewModel
        )
    }
}
