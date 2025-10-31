package com.example.visualhierarchy.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.visualhierarchy.R

data class CartProduct(
    val name: String,
    val quantity: String,
    val price: Double,
    val imageRes: Int
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GoodCartScreen(onBackClick: () -> Unit) {
    val cartItems = listOf(
        CartProduct("Avocado", "1 piece", 4.50, R.drawable.avocado),
        CartProduct("Banana", "2 pieces", 3.20, R.drawable.banana),
        CartProduct("Strawberry", "10 pcs", 3.50, R.drawable.strawberry)
    )

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("Giỏ hàng ĐẸP", fontWeight = FontWeight.Bold) },
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
                .background(Color(0xFFF6F7FB))
                .padding(horizontal = 16.dp, vertical = 12.dp)
        ) {
            Text(
                text = "Shopping Cart",
                fontWeight = FontWeight.Bold,
                fontSize = 22.sp,
                modifier = Modifier.padding(bottom = 12.dp)
            )

            // Danh sách sản phẩm
            cartItems.forEach { item ->
                CartItem(item)
                Spacer(Modifier.height(10.dp))
            }

            Spacer(Modifier.height(8.dp))
            Divider(color = Color(0xFFDDDDDD))
            Spacer(Modifier.height(8.dp))

            // Tổng tiền
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text("Tổng cộng", fontSize = 16.sp, color = Color.Gray)
                Text("$11.20", fontWeight = FontWeight.Bold, fontSize = 18.sp)
            }

            Spacer(Modifier.height(20.dp))

            // Nút hành động chính — Thanh toán
            Button(
                onClick = {},
                modifier = Modifier.fillMaxWidth().height(50.dp),
                shape = RoundedCornerShape(12.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF4CAF50))
            ) {
                Text("Thanh toán", color = Color.White, fontWeight = FontWeight.Bold)
            }

            Spacer(Modifier.height(12.dp))

            // Hành động phụ — Tiếp tục mua hàng
            OutlinedButton(
                onClick = {},
                modifier = Modifier.fillMaxWidth().height(50.dp),
                shape = RoundedCornerShape(12.dp),
                colors = ButtonDefaults.outlinedButtonColors(contentColor = Color.Gray)
            ) {
                Text("Tiếp tục mua hàng", fontWeight = FontWeight.Medium)
            }

            Spacer(Modifier.height(12.dp))

            
        }
    }
}

@Composable
fun CartItem(product: CartProduct) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Row(
            modifier = Modifier.padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = product.imageRes),
                contentDescription = product.name,
                modifier = Modifier
                    .size(60.dp)
                    .clip(RoundedCornerShape(12.dp)),
                contentScale = ContentScale.Crop
            )

            Spacer(Modifier.width(12.dp))

            Column(modifier = Modifier.weight(1f)) {
                Text(product.name, fontWeight = FontWeight.SemiBold, fontSize = 16.sp)
                Text(product.quantity, color = Color.Gray, fontSize = 13.sp)
            }

            Text("$${product.price}", fontWeight = FontWeight.Bold, color = Color(0xFF1E88E5))
        }
    }
}
