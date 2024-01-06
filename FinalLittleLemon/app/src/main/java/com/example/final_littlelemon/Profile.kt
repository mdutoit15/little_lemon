package com.example.final_littlelemon

import android.content.Context
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun ProfileScreen(
    navController: NavController
) {
    val sharedPreferences = LocalContext.current.getSharedPreferences(
        "UserData", Context.MODE_PRIVATE)

    val userName = remember {
        mutableStateOf(
            TextFieldValue(
                sharedPreferences.getString(
                    "userName", "") ?: "")
        )
    }

    val userSurname = remember {
        mutableStateOf(
            TextFieldValue(
                sharedPreferences.getString(
                    "userSurname", "") ?: "")
        )
    }

    val userEmail = remember {
        mutableStateOf(
            TextFieldValue(
                sharedPreferences.getString(
                    "userEmail", "") ?: "")
        )
    }




    val darkGreen = Color(0xFF495E57)
    val yellow = Color(0xFFF4CE14)

    Column {
        Image(
            painter = (painterResource(id = R.drawable.logo)),
            contentDescription = "Logo",
            modifier = Modifier
                .height(80.dp)
                .width(200.dp)
                .padding(5.dp)
                .align(Alignment.CenterHorizontally)
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(80.dp)
                .background(color = darkGreen),

            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Profile",
                fontSize = (20.sp),
                fontWeight = FontWeight.Bold,
                color = Color.White,
            )
        }

        Column(
            modifier = Modifier
                .padding(10.dp)
        ) {
            Text(
                text = "Personal Information:",
                fontWeight = FontWeight.Bold,
                fontSize = (16.sp),
                modifier = Modifier
                    .padding(top = 30.dp, bottom = 30.dp)
            )
            OutlinedTextField(
                value = userName.value,
                onValueChange = { userName.value = it },
                label = {
                    Text(text = "First Name",
                    )
                },
                modifier = Modifier
                    .width(500.dp)
                    .padding(start = 10.dp, end = 10.dp, bottom = 20.dp)
                    .align(Alignment.CenterHorizontally)
            )

            OutlinedTextField(
                value = userSurname.value,
                onValueChange = {userSurname.value = it},
                label = {
                    Text(text = "Surname",
                    )
                },
                modifier = Modifier
                    .width(500.dp)
                    .padding(start = 10.dp, end = 10.dp, bottom = 20.dp)
                    .align(Alignment.CenterHorizontally)
            )

            OutlinedTextField(
                value = userEmail.value,
                onValueChange = { userEmail.value = it },
                label = {
                    Text(
                        text = "Email"
                    )
                },
                modifier = Modifier
                    .width(500.dp)
                    .padding(start = 10.dp, end = 10.dp, bottom = 20.dp)
                    .align(Alignment.CenterHorizontally)
            )
        }
        Button(
            onClick = {
                Log.d("AAA", userName.toString())
                Log.d("BBB", userName.toString())
                Log.d("CCC", userName.toString())

                val editor = sharedPreferences.edit()
                editor.putString("userName", userName.value.text)
                editor.putString("userSurname", userSurname.value.text)
                editor.putString("userEmail", userEmail.value.text)
                editor.apply()

                navController.navigate(Onboard.route)
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = yellow
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    start = 10.dp,
                    top = 100.dp,
                    end = 10.dp
                )

        ) {
            Text(
                text = "Logout",
                color = Color.Black,
                fontWeight = FontWeight.Bold
            )
        }
    }
}