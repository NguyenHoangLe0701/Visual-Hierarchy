
package com.example.visualhierarchy.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
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

/**
 * Card "xấu" — minh họa giao diện rối, thiếu phân cấp.
 */
@Composable
fun CardBad() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .border(1.dp, Color.Gray, RoundedCornerShape(6.dp)),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Column(
            modifier = Modifier
                .padding(12.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                "Căn hộ cao cấp giá rẻ tại trung tâm thành phố cực kỳ đẹp, có ban công, 3 phòng ngủ, gần chợ, tiện nghi đầy đủ",
                fontSize = 16.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(bottom = 6.dp)
            )
            Image(
                painter = painterResource(id = R.drawable.house),
                contentDescription = "House Image",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .height(150.dp)
                    .fillMaxWidth()
            )
            Text("Giá: 3.2 Tỷ", fontSize = 14.sp, color = Color.Red)
            Text("Địa chỉ: 123 Nguyễn Trãi, Quận 1", fontSize = 12.sp)
            Text("Liên hệ: 0909 123 456 - Anh A", fontSize = 12.sp)
            Text("Diện tích: 80m2 | 3PN | 2WC", fontSize = 12.sp)
        }
    }
}

/**
 * Card "đẹp" — có phân cấp trực quan rõ ràng.
 */
@Composable
fun CardGood() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(6.dp)
    ) {
        Column {
            Image(
                painter = painterResource(id = R.drawable.house),
                contentDescription = "House Image",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .height(160.dp)
                    .fillMaxWidth()
            )
            Column(Modifier.padding(16.dp)) {
                Text(
                    "3.2 Tỷ",
                    color = MaterialTheme.colorScheme.primary,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp
                )
                Text(
                    "Căn hộ trung tâm, có ban công, tiện nghi đầy đủ",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium,
                    modifier = Modifier.padding(top = 4.dp)
                )
                Text(
                    "123 Nguyễn Trãi, Quận 1",
                    fontSize = 13.sp,
                    color = Color.Gray,
                    modifier = Modifier.padding(top = 2.dp)
                )
                Spacer(Modifier.height(12.dp))
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    FeatureBadge("80m²")
                    FeatureBadge("3PN")
                    FeatureBadge("2WC")
                }
                Spacer(Modifier.height(12.dp))
                Text(
                    "Liên hệ: 0909 123 456 - Anh A",
                    fontSize = 13.sp,
                    color = Color.Gray,
                    textAlign = TextAlign.End,
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
    }
}

@Composable
fun FeatureBadge(text: String) {
    Box(
        modifier = Modifier
            .background(Color(0xFFE8F5E8), RoundedCornerShape(8.dp))
            .padding(horizontal = 8.dp, vertical = 4.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(text = text, fontSize = 12.sp, color = Color(0xFF2E7D32))
    }
}
