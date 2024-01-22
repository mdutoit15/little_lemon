package com.munbonecci.littlelemon.presentation.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.munbonecci.littlelemon.Constants.DEFAULT_CATEGORY
import com.munbonecci.littlelemon.Constants.DESSERTS_CATEGORY
import com.munbonecci.littlelemon.Constants.DRINKS_CATEGORY
import com.munbonecci.littlelemon.Constants.MAINS_CATEGORY
import com.munbonecci.littlelemon.Constants.STARTERS_CATEGORY
import com.munbonecci.littlelemon.R
import com.munbonecci.littlelemon.ui.theme.DarkGray
import com.munbonecci.littlelemon.ui.theme.Gray
import com.munbonecci.littlelemon.ui.theme.LightGray

@Composable
fun MenuCategories(onItemClick: (String) -> Unit) {
    val category = listOf(
        STARTERS_CATEGORY, MAINS_CATEGORY, DESSERTS_CATEGORY, DRINKS_CATEGORY, DEFAULT_CATEGORY
    )
    Column(modifier = Modifier.padding(16.dp)) {
        Text(
            text = "Order for Delivery:",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF495E57),
            modifier = Modifier
                .padding(
                    start = 10.dp,
                    bottom = 10.dp
                )
        )
        LazyRow {
            items(category) { categories ->
                Card(
                    modifier = Modifier
                        .clickable { onItemClick(categories) }
                        .padding(
                            start = 10.dp,
                            end = 10.dp
                        ),
                    backgroundColor = Color(0xFFEDEFEE),
                    shape = RoundedCornerShape(10.dp)
                ) {
                    Text(
                        text = categories,
                        textAlign = TextAlign.Center,
                        color = Color(0xFF333333),
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
                            .padding(10.dp)
                    )
                }
            }
        }

        Divider(
            color = Color(0xFFEE9972),
            thickness = 2.dp,
            modifier = Modifier
                .padding(top = 10.dp, bottom = 10.dp)
                .clip(shape = RoundedCornerShape(3.dp))
        )
    }
}