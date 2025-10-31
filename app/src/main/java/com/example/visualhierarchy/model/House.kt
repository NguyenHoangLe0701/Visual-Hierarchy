package com.example.visualhierarchy.model

data class House(
    val price: String,
    val title: String,
    val address: String,
    val size: String,
    val beds: String,
    val baths: String,
    val agent: String,
    val phone: String,
    val imageRes: Int
)

/*
 tạo 1 đối tượng mẫu:
val house = House(
    price = "3.273.279.000đ",
    title = "Biệt thự 5 phòng ngủ sang trọng",
    address = "29 Đường Tân Quý, Tân Phú, HCM",
    size = "250m²",
    beds = "5",
    baths = "3",
    agent = "Hoàng Lê",
    phone = "0987 654 321",
    imageRes = R.drawable.house
)
*/