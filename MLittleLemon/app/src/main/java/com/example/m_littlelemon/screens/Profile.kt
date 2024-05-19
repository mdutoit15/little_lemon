package com.example.m_littlelemon.screens

import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.m_littlelemon.R
import com.example.m_littlelemon.route.LoginS
import com.example.m_littlelemon.ui.theme.DarkGreen
import com.example.m_littlelemon.ui.theme.DarkGrey
import com.example.m_littlelemon.ui.theme.DarkPink
import com.example.m_littlelemon.ui.theme.Pink
import com.example.m_littlelemon.ui.theme.White
import com.example.m_littlelemon.ui.theme.Yellow

@Composable
fun Profile(navController: NavHostController) {
    val context = LocalContext.current

    val sharedPref = context
        .getSharedPreferences("sharedPreference", Context.MODE_PRIVATE)

    val userEmail = remember {
        mutableStateOf(TextFieldValue(
            sharedPref.getString("userEmail", "") ?: "")
        )
    }

    val userPass = remember {
        mutableStateOf(TextFieldValue(
            sharedPref.getString("userPass", "") ?: "")
        )
    }

    fun updateUser(
        userEmail: String,
        userPass: String,
        sharedPreferences: SharedPreferences
    ) {
        val editor = sharedPreferences.edit()
        editor.putString("userEmail", userEmail)
        editor.putString("userPass", userPass)
        editor.apply()
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 10.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo2),
            contentDescription = "Logo",
            modifier = Modifier
                .height(60.dp)
                .fillMaxWidth()
                .align(Alignment.CenterHorizontally)
                .padding(top = 10.dp)
        )
        Row(
            modifier = Modifier
                .padding(top = 20.dp)
                .background(DarkGreen)
                .fillMaxWidth()
                .height(70.dp),

            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
        ) {
            Text(
                text = "Personal Information",
                color = White,
                fontSize = (25.sp),
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                fontFamily = FontFamily(Font(R.font.markazi_text_regular))
            )
        }

        Text(
            text = "Email:",
            fontFamily = FontFamily(Font(R.font.markazi_text_regular)),
            fontSize = (20.sp),
            fontWeight = FontWeight.Normal,
            modifier = Modifier
                .padding(start = 10.dp, top = 30.dp)
        )
        TextField(
            value = userEmail.value,
            onValueChange = {userEmail.value = it},
            textStyle = TextStyle(
                fontFamily = FontFamily(Font(R.font.markazi_text_regular)),
                fontSize = (20.sp),
            ),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email,
                imeAction = ImeAction.Next

            ),
            modifier = Modifier
                .fillMaxWidth(0.9f)
                .height(50.dp)
                .align(Alignment.CenterHorizontally)
                .border(
                    width = 2.dp,
                    brush = Brush.horizontalGradient(
                        listOf(
                            DarkGreen,
                            Yellow,
                            DarkPink,
                            DarkGreen
                        )
                    ),
                    shape = RoundedCornerShape(35.dp)
                )
                .background(Color.Transparent)
        )

        Text(
            text = "Password:",
            fontFamily = FontFamily(Font(R.font.markazi_text_regular)),
            fontSize = (20.sp),
            fontWeight = FontWeight.Normal,
            modifier = Modifier
                .padding(start = 10.dp, top = 20.dp)
        )
        TextField(
            value = userPass.value,
            onValueChange = {userPass.value = it},
            textStyle = TextStyle(
                fontFamily = FontFamily(Font(R.font.markazi_text_regular)),
                fontSize = (20.sp),
            ),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password,
                imeAction = ImeAction.Default
            ),
            modifier = Modifier
                .fillMaxWidth(0.9f)
                .height(50.dp)
                .align(Alignment.CenterHorizontally)
                .border(
                    width = 2.dp,
                    brush = Brush.horizontalGradient(
                        listOf(
                            DarkGreen,
                            Yellow,
                            DarkPink,
                            DarkGreen
                        )
                    ),
                    shape = RoundedCornerShape(35.dp)
                )
                .background(Color.Transparent)
        )

        Button(
            onClick = {
                Log.d("AAA", userEmail.toString())
                Log.d("BBB", userPass.toString())

                val editor = sharedPref.edit()
                editor.putString("userEmail", userEmail.value.text)
                editor.putString("userPass", userPass.value.text)
                editor.apply()

                updateUser(
                    userEmail.value.text,
                    userPass.value.text,
                    sharedPref)

                Toast.makeText(
                    context,
                    "Logout Successful!",
                    Toast.LENGTH_SHORT
                ).show()

                navController.navigate(LoginS.route)
            },
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Yellow
            ),
            border = BorderStroke(2.dp, color = Pink),
            shape = RoundedCornerShape(35.dp),
            modifier = Modifier
                .padding(top = 100.dp)
                .fillMaxWidth(0.4f)
                .height(40.dp)
                .align(Alignment.CenterHorizontally)
        ) {
            Text(
                text = "Log Out",
                color = DarkGrey,
                fontFamily = FontFamily(Font(R.font.markazi_text_regular)),
                fontSize = (20.sp),
                fontWeight = FontWeight.Bold,
            )
        }
    }
}