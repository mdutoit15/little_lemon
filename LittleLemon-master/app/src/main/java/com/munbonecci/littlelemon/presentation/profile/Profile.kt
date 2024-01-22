package com.munbonecci.littlelemon.presentation.profile

import android.content.Context
import android.content.SharedPreferences
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.munbonecci.littlelemon.R
import com.munbonecci.littlelemon.core.navigation.OnBoard
import com.munbonecci.littlelemon.ui.theme.Yellow

@Composable
fun Profile(navController: NavHostController) {
    val context = LocalContext.current

    val sharedPreferences = context
        .getSharedPreferences("sharedPreferences", Context.MODE_PRIVATE)


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

    fun updateUserData(
        userName: String,
        userSurname: String,
        userEmail: String,
        sharedPreferences: SharedPreferences
    ) {
        val editor = sharedPreferences.edit()
        editor.putString("userName", userName)
        editor.putString("userSurname", userSurname)
        editor.putString("userEmail", userEmail)
        editor.apply()
    }

    Column {
        Image(
            painter = (painterResource(id = R.drawable.logo2)),
            contentDescription = "Logo",
            contentScale = ContentScale.FillWidth,
            modifier = Modifier
                .height(100.dp)
                .width(200.dp)
                .padding(5.dp)
                .align(Alignment.CenterHorizontally)
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(80.dp)
                .background(Color(0xFF495E57)),

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
                .padding(
                    top = 40.dp,
                    start = 10.dp,
                    end = 10.dp
                ),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = stringResource(id = R.string.personal_information),
                fontWeight = FontWeight.ExtraBold,
                modifier = Modifier.padding(top = 8.dp)
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
                    .align(Alignment.CenterHorizontally),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Email
                )
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

                updateUserData(
                    userName.value.text,
                    userSurname.value.text,
                    userEmail.value.text,
                    sharedPreferences)

                navController.navigate(OnBoard.route)
            },
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Yellow,
                contentColor = Color.Black
            ),
            modifier = Modifier
                .fillMaxWidth(0.6f)
                .padding(
                    start = 10.dp,
                    top = 100.dp,
                    end = 10.dp
                )
                .align(Alignment.CenterHorizontally),
            shape = RoundedCornerShape(40),
        ) {
            Text(
                text = "Register",
                color = Color(0xFF495E57),
                fontWeight = FontWeight.Bold
            )
        }
    }
}