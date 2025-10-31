package com.example.visualhierarchy.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.DesignServices
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    onBadDesignClick: () -> Unit,
    onGoodDesignClick: () -> Unit,
    onBadCartClick: () -> Unit,
    onGoodCartClick: () -> Unit
) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        "Visual Hierarchy",
                        style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold)
                    )
                },
                navigationIcon = {
                    Icon(
                        imageVector = Icons.Default.DesignServices,
                        contentDescription = "App Icon",
                        tint = MaterialTheme.colorScheme.primary
                    )
                }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(horizontal = 20.dp, vertical = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(28.dp)
        ) {

            Text(
                text = "So sánh giữa Giao diện Xấu và Giao diện Đẹp",
                style = MaterialTheme.typography.bodyMedium.copy(color = Color.Gray),
                textAlign = TextAlign.Center
            )

            // --- Nhóm Thiết kế ---
            DesignCard(
                title = "GIAO DIỆN XẤU",
                description = "Nhiều chữ, thiếu phân cấp, khó đọc",
                color = Color(0xFFFFEBEE),
                textColor = Color(0xFFD32F2F)
            )

            DesignCard(
                title = "GIAO DIỆN ĐẸP",
                description = "Trực quan, dễ quét thông tin, có trọng tâm",
                color = Color(0xFFE8F5E9),
                textColor = Color(0xFF2E7D32)
            )

            Row(
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                Button(
                    onClick = onBadDesignClick,
                    modifier = Modifier.weight(1f).height(52.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFD32F2F))
                ) {
                    Icon(Icons.Default.ArrowForward, contentDescription = null, tint = Color.White)
                    Spacer(Modifier.width(6.dp))
                    Text("Thiết kế XẤU", color = Color.White)
                }

                Button(
                    onClick = onGoodDesignClick,
                    modifier = Modifier.weight(1f).height(52.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF4CAF50))
                ) {
                    Icon(Icons.Default.ArrowForward, contentDescription = null, tint = Color.White)
                    Spacer(Modifier.width(6.dp))
                    Text("Thiết kế ĐẸP", color = Color.White)
                }
            }

            // --- Nhóm Giỏ hàng ---
            Spacer(Modifier.height(24.dp))
            Text(
                text = "So sánh giữa Giỏ hàng Xấu và Đẹp",
                style = MaterialTheme.typography.bodyMedium.copy(color = Color.Gray),
                textAlign = TextAlign.Center
            )

            Row(
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                Button(
                    onClick = onBadCartClick,
                    modifier = Modifier.weight(1f).height(52.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFD32F2F))
                ) {
                    Icon(Icons.Default.ArrowForward, contentDescription = null, tint = Color.White)
                    Spacer(Modifier.width(6.dp))
                    Text("Giỏ hàng XẤU", color = Color.White)
                }

                Button(
                    onClick = onGoodCartClick,
                    modifier = Modifier.weight(1f).height(52.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF4CAF50))
                ) {
                    Icon(Icons.Default.ArrowForward, contentDescription = null, tint = Color.White)
                    Spacer(Modifier.width(6.dp))
                    Text("Giỏ hàng ĐẸP", color = Color.White)
                }
            }
        }
    }
}

@Composable
private fun DesignCard(
    title: String,
    description: String,
    color: Color,
    textColor: Color
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .shadow(2.dp, RoundedCornerShape(16.dp)),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = color)
    ) {
        Column(
            modifier = Modifier.padding(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(title, fontWeight = FontWeight.Bold, color = textColor, fontSize = 18.sp)
            Spacer(modifier = Modifier.height(6.dp))
            Text(description, color = Color.Gray, textAlign = TextAlign.Center)
        }
    }
}
