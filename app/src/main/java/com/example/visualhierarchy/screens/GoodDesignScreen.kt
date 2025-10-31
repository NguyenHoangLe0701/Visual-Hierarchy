package com.example.visualhierarchy.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
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
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.visualhierarchy.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GoodDesignScreen(onBackClick: () -> Unit) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("Thiết kế đẹp", fontWeight = FontWeight.Bold) },
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
                .background(Color(0xFFF6F7FB)),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Card(
                modifier = Modifier
                    .fillMaxWidth(0.9f)
                    .padding(16.dp),
                shape = RoundedCornerShape(20.dp),
                elevation = CardDefaults.cardElevation(6.dp)
            ) {
                Column {
                    Image(
                        painter = painterResource(id = R.drawable.house),
                        contentDescription = null,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(220.dp)
                            .clip(RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp)),
                        contentScale = ContentScale.Crop
                    )

                    Column(
                        modifier = Modifier
                            .background(Color.White)
                            .padding(16.dp)
                    ) {
                       Row(
    verticalAlignment = Alignment.CenterVertically
) {
    Image(
        painter = painterResource(id = R.drawable.icon_money),
        contentDescription = null,
        modifier = Modifier
            .size(26.dp)  
            .padding(end = 6.dp),
        contentScale = ContentScale.Fit
    )
    Text(
        "3.273.279.000đ",
        fontWeight = FontWeight.Bold,
        fontSize = 22.sp,
        color = Color(0xFF1E88E5)
    )
}
                        Text(
                            "Biệt thự 5 phòng ngủ sang trọng",
                            fontWeight = FontWeight.Medium,
                            fontSize = 16.sp
                        )
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                            "29 Đường Tân Quý, Quận BH2, TP Đà Nẵng",
                            color = Color.Gray,
                            fontSize = 13.sp
                        )

                        Spacer(modifier = Modifier.height(12.dp))

                        // Box để canh giữa cả nhóm chip
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                        ) {
                            Row(
                                modifier = Modifier
                                    .wrapContentWidth() 
                                    .align(Alignment.Center),
                                horizontalArrangement = Arrangement.spacedBy(8.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                InfoChip(iconRes = R.drawable.icon_local, text = "Đà Nẵng")
                                InfoChip(iconRes = R.drawable.icon_bed, text = "5 phòng")
                                InfoChip(iconRes = R.drawable.icon_bathroom, text = "2 phòng ")
                            }
                        }

                        Spacer(modifier = Modifier.height(16.dp))

                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Image(
                                painter = painterResource(id = R.drawable.icon_user),
                                contentDescription = null,
                                modifier = Modifier
                                    .size(40.dp)
                                    .clip(CircleShape),
                                contentScale = ContentScale.Crop
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Column {
                                Text("Hoàng Lê", fontWeight = FontWeight.Medium)
                                Text("+44 235 123 321", fontSize = 12.sp, color = Color.Gray)
                            }
                        }
                    }
                }
            }

           
        }
    }
}

@Composable
fun InfoChip(iconRes: Int, text: String) {
    Surface(
        color = Color(0xFFF1F3F6),
        shape = RoundedCornerShape(50),
        modifier = Modifier.padding(horizontal = 4.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(horizontal = 10.dp, vertical = 6.dp)
        ) {
            Image(
                painter = painterResource(id = iconRes),
                contentDescription = null,
                modifier = Modifier
                    .size(18.dp)        // chuẩn hoá kích thước icon
                    .aspectRatio(1f),
                contentScale = ContentScale.Fit
            )
            Spacer(modifier = Modifier.width(6.dp))
            Text(
                text,
                fontSize = 13.sp,
                maxLines = 1,                    // tránh xuống dòng
                overflow = TextOverflow.Ellipsis // nếu quá dài sẽ hiển thị "..."
            )
        }
    }
}
