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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.visualhierarchy.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BadDesignScreen(onBackClick: () -> Unit) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Thiết kế xấu ") },
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
                .padding(12.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.house), 
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(220.dp)
                    .border(2.dp, Color.Gray),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.height(8.dp))

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .border(1.dp, Color.Gray)
                    .padding(8.dp)
            ) {
                Text("Biệt thự 5 phòng ngủ sang trọng")
                Text("Trạng thái: Đang bán")
                Text("Giá: 3.273.279.000đ")
                Text("Địa chỉ: 29 Đường Terrace, Quận BH2, TP Đà Nẵng")
                Text("Diện tích: 1634 sqft")
                Text("Phòng ngủ: 5")
                Text("Phòng tắm: 2")
                Text("Người liên hệ: Hoàng Lê")
                Text("Số điện thoại: +44 235 123 321")
            }

            Spacer(modifier = Modifier.height(10.dp))
            
        }
    }
}
