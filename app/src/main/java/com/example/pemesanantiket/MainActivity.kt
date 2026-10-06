package com.example.pemesanantiket

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Remove
import androidx.compose.material.icons.outlined.ConfirmationNumber
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.text.NumberFormat
import java.util.Locale

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MaterialTheme {
                PemesananTiketScreen()
            }
        }
    }
}

@SuppressLint("AutoboxingStateCreation")
@Composable
fun PemesananTiketScreen() {

    val hargaTiket = 25000
    var jumlahTiket by remember { mutableIntStateOf(1) }

    val totalBayar = hargaTiket * jumlahTiket

    val biru = Color(0xFF2196F3)
    val hijau = Color(0xFF00A651)
    val merah = Color(0xFFF44336)
    val background = Color(0xFFF3F6FA)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(background)
    ) {

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(biru)
                .statusBarsPadding()
                .padding(top = 16.dp, bottom = 22.dp),
            contentAlignment = Alignment.Center
        ) {

            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                // LOGO TIKET
                Icon(
                    imageVector = Icons.Outlined.ConfirmationNumber,
                    contentDescription = "Logo Tiket",
                    tint = Color.White,
                    modifier = Modifier.size(45.dp)
                )

                Spacer(modifier = Modifier.height(6.dp))

                Text(
                    text = "Pemesanan Tiket",
                    color = Color.White,
                    fontSize = 25.sp,
                    fontWeight = FontWeight.Bold
                )

                Text(
                    text = "Pesan tiket dengan mudah!",
                    color = Color.White.copy(alpha = 0.85f),
                    fontSize = 13.sp
                )
            }
        }

        // ISI
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {

            // HARGA TIKET
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(14.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color.White
                ),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 2.dp
                )
            ) {

                Column(
                    modifier = Modifier.padding(18.dp)
                ) {

                    Text(
                        text = "Harga Tiket",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = Color.DarkGray
                    )

                    Spacer(modifier = Modifier.height(4.dp))

                    Text(
                        text = formatRupiah(hargaTiket),
                        fontSize = 28.sp,
                        fontWeight = FontWeight.Bold,
                        color = biru
                    )

                    Text(
                        text = "per tiket",
                        fontSize = 12.sp,
                        color = Color.Gray
                    )
                }
            }

            Spacer(modifier = Modifier.height(12.dp))

            // JUMLAH TIKET
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(14.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color.White
                ),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 2.dp
                )
            ) {

                Column(
                    modifier = Modifier.padding(18.dp)
                ) {

                    Text(
                        text = "Jumlah Tiket",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = Color.DarkGray
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {

                        // TOMBOL MINUS
                        IconButton(
                            onClick = {
                                if (jumlahTiket > 1) {
                                    jumlahTiket--
                                }
                            },
                            modifier = Modifier
                                .size(52.dp)
                                .clip(CircleShape)
                                .background(biru)
                        ) {
                            Icon(
                                imageVector = Icons.Default.Remove,
                                contentDescription = "Kurang",
                                tint = Color.White,
                                modifier = Modifier.size(28.dp)
                            )
                        }

                        // JUMLAH
                        Box(
                            modifier = Modifier
                                .width(110.dp)
                                .height(52.dp)
                                .clip(RoundedCornerShape(12.dp))
                                .background(Color(0xFFF1F4F8)),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = jumlahTiket.toString(),
                                fontSize = 26.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }

                        // TOMBOL PLUS
                        IconButton(
                            onClick = {
                                jumlahTiket++
                            },
                            modifier = Modifier
                                .size(52.dp)
                                .clip(CircleShape)
                                .background(biru)
                        ) {
                            Icon(
                                imageVector = Icons.Default.Add,
                                contentDescription = "Tambah",
                                tint = Color.White,
                                modifier = Modifier.size(28.dp)
                            )
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(12.dp))

            // TOTAL
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(14.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color.White
                ),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 2.dp
                )
            ) {

                Column(
                    modifier = Modifier.padding(18.dp)
                ) {

                    Text(
                        text = "Total",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = Color.DarkGray
                    )

                    Spacer(modifier = Modifier.height(4.dp))

                    Text(
                        text = formatRupiah(totalBayar),
                        fontSize = 28.sp,
                        fontWeight = FontWeight.Bold,
                        color = hijau
                    )
                }
            }

            Spacer(modifier = Modifier.height(14.dp))

            // RESET
            Button(
                onClick = {
                    jumlahTiket = 1
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(52.dp),
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = merah
                )
            ) {

                Icon(
                    imageVector = Icons.Default.Refresh,
                    contentDescription = "Reset",
                    tint = Color.White
                )

                Spacer(modifier = Modifier.width(8.dp))

                Text(
                    text = "RESET",
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}

fun formatRupiah(nominal: Int): String {

    val localeIndonesia = Locale.forLanguageTag("id-ID")
    val format = NumberFormat.getNumberInstance(localeIndonesia)

    return "Rp${format.format(nominal)}"
}