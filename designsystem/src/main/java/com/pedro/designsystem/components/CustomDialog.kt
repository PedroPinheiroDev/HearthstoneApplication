package com.pedro.designsystem.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.pedro.designsystem.theme.Purple500

@Composable
fun CustomDialog(
    text: String,
    onDismissRequest: () -> Unit = {},
    clickPositive: () -> Unit = {}
) {

    Dialog(onDismissRequest = { onDismissRequest() }) {
        Column(
            modifier = Modifier
                .padding(5.dp)
                .fillMaxWidth(0.9f)
                .fillMaxHeight(0.6f)
                .background(Color.White),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = text,
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp
            )

            Spacer(modifier = Modifier.padding(15.dp))

            Row(modifier = Modifier.fillMaxWidth()) {
                Spacer(modifier = Modifier.padding(10.dp))

                Button(
                    onClick = {
                        clickPositive()
                        onDismissRequest()
                    },
                    modifier = Modifier
                        .width(100.dp)
                        .height(60.dp)
                        .padding(10.dp),
                    shape = RoundedCornerShape(5.dp),
                    colors = ButtonDefaults.buttonColors(Purple500)
                ) {
                    Text(
                        text = "Yes",
                        color = Color.White,
                        fontSize = 12.sp
                    )
                }

                Spacer(modifier = Modifier.padding(5.dp))

                Button(
                    onClick = {
                        onDismissRequest()
                    },
                    modifier = Modifier
                        .width(100.dp)
                        .height(60.dp)
                        .padding(10.dp),
                    shape = RoundedCornerShape(5.dp),
                    colors = ButtonDefaults.buttonColors(Purple500)
                ) {
                    Text(
                        text = "No",
                        color = Color.White,
                        fontSize = 12.sp
                    )
                }
            }
        }
    }
}
