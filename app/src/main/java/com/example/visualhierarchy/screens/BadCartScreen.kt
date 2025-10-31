package com.example.visualhierarchy.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.visualhierarchy.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BadCartScreen(onBackClick: () -> Unit) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("Giỏ hàng XẤU", fontWeight = FontWeight.Bold) },
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(Icons.Default.ArrowBack, contentDescription = null)
                    }
                }
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
                .background(Color.White)
                .padding(16.dp)
        ) {
            Text("Shopping Cart", fontWeight = FontWeight.Bold, fontSize = 22.sp)
            Spacer(Modifier.height(10.dp))

            val products = listOf(
                Triple("Avocado", "1 piece", R.drawable.avocado),
                Triple("Banana", "2 pieces", R.drawable.banana),
                Triple("Strawberry", "10 pcs", R.drawable.strawberry)
            )

            products.forEach { (name, qty, imgRes) ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .border(1.dp, Color.LightGray)
                        .padding(8.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Image(
                            painter = painterResource(id = imgRes),
                            contentDescription = null,
                            modifier = Modifier.size(48.dp),
                            contentScale = ContentScale.Crop
                        )
                        Column(Modifier.padding(start = 8.dp)) {
                            Text(name, fontWeight = FontWeight.Bold)
                            Text(qty, fontSize = 12.sp, color = Color.Gray)
                        }
                    }
                    Text("$4.50", fontWeight = FontWeight.Bold)
                }
                Spacer(Modifier.height(8.dp))
            }

            //Divider()
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text("Tổng cộng")
                Text("$11.20", fontWeight = FontWeight.Bold)
            }
            Spacer(Modifier.height(16.dp))


            Button(
                onClick = {},
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp),
                shape = RoundedCornerShape(12.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFFF9800),
                    contentColor = Color.White
                )
            ) {
                Text("Tiếp tục mua hàng", fontWeight = FontWeight.Bold)
            }

            Spacer(Modifier.height(8.dp))


            Button(
                onClick = {},
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp),
                shape = RoundedCornerShape(12.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFF44336),
                    contentColor = Color.White
                )
            ) {
                Text("Thanh Toán", fontWeight = FontWeight.Bold)
            }
        }
    }
}
