package com.example.calculator

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Calculator(
    state: CalculatorState,
    modifier: Modifier = Modifier,
    buttonSpacing: Dp = 8.dp,
    onAction: (Actions) -> Unit
) {
    Box(modifier = modifier) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter),
            verticalArrangement = Arrangement.spacedBy(buttonSpacing)
        ) {
            Text(
                text = state.number1 + (state.operations?.symbol ?: "") + state.number2,
                textAlign = TextAlign.End,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 32.dp),
                fontSize = 80.sp,
                color = Color.White,
                maxLines = 2

            )
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing),

                ) {
                Button(symbol = "AC",
                    modifier = Modifier
                        .background(Color.LightGray)
                        .aspectRatio(ratio = 2f)
                        .weight(2f),
                    onClick = {
                        onAction(Actions.Clear)
                    })
                Button(symbol = "Del",
                    modifier = Modifier
                        .background(Color.LightGray)
                        .aspectRatio(ratio = 1f)
                        .weight(1f),
                    onClick = {
                        onAction(Actions.Delete)
                    })
                Button(symbol = "/",
                    modifier = Modifier
                        .background(Color.Magenta)
                        .aspectRatio(ratio = 1f)
                        .weight(1f),
                    onClick = {
                        onAction(Actions.Operation(Operations.Divide))
                    })

            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing),

                ) {
                Button(symbol = "7",
                    modifier = Modifier
                        .background(Color.DarkGray)
                        .aspectRatio(ratio = 1f)
                        .weight(1f),
                    onClick = {
                        onAction(Actions.Number(7))
                    })
                Button(symbol = "8",
                    modifier = Modifier
                        .background(Color.DarkGray)
                        .aspectRatio(ratio = 1f)
                        .weight(1f),
                    onClick = {
                        onAction(Actions.Number(8))
                    })
                Button(symbol = "9",
                    modifier = Modifier
                        .background(Color.DarkGray)
                        .aspectRatio(ratio = 1f)
                        .weight(1f),
                    onClick = {
                        onAction(Actions.Number(9))
                    })
                Button(symbol = "x",
                    modifier = Modifier
                        .background(Color.Magenta)
                        .aspectRatio(ratio = 1f)
                        .weight(1f),
                    onClick = {
                        onAction(Actions.Operation(Operations.Multiply))
                    })

            }


            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing),

                ) {
                Button(symbol = "4",
                    modifier = Modifier
                        .background(Color.DarkGray)
                        .aspectRatio(ratio = 1f)
                        .weight(1f),
                    onClick = {
                        onAction(Actions.Number(4))
                    })
                Button(symbol = "5",
                    modifier = Modifier
                        .background(Color.DarkGray)
                        .aspectRatio(ratio = 1f)
                        .weight(1f),
                    onClick = {
                        onAction(Actions.Number(5))
                    })
                Button(symbol = "6",
                    modifier = Modifier
                        .background(Color.DarkGray)
                        .aspectRatio(ratio = 1f)
                        .weight(1f),
                    onClick = {
                        onAction(Actions.Number(6))
                    })
                Button(symbol = "-",
                    modifier = Modifier
                        .background(Color.Magenta)
                        .aspectRatio(ratio = 1f)
                        .weight(1f),
                    onClick = {
                        onAction(Actions.Operation(Operations.Subtract))
                    })

            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing),

                ) {
                Button(symbol = "1",
                    modifier = Modifier
                        .background(Color.DarkGray)
                        .aspectRatio(ratio = 1f)
                        .weight(1f),
                    onClick = {
                        onAction(Actions.Number(4))
                    })
                Button(symbol = "2",
                    modifier = Modifier
                        .background(Color.DarkGray)
                        .aspectRatio(ratio = 1f)
                        .weight(1f),
                    onClick = {
                        onAction(Actions.Number(5))
                    })
                Button(symbol = "3",
                    modifier = Modifier
                        .background(Color.DarkGray)
                        .aspectRatio(ratio = 1f)
                        .weight(1f),
                    onClick = {
                        onAction(Actions.Number(6))
                    })
                Button(symbol = "+",
                    modifier = Modifier
                        .background(Color.Magenta)
                        .aspectRatio(ratio = 1f)
                        .weight(1f),
                    onClick = {
                        onAction(Actions.Operation(Operations.Add))
                    })

            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing),

                ) {
                Button(symbol = "0",
                    modifier = Modifier
                        .background(Color.DarkGray)
                        .aspectRatio(ratio = 2f)
                        .weight(2f),
                    onClick = {
                        onAction(Actions.Number(0))
                    })
                Button(symbol = ".",
                    modifier = Modifier
                        .background(Color.DarkGray)
                        .aspectRatio(ratio = 1f)
                        .weight(1f),
                    onClick = {
                        onAction(Actions.Decimal)
                    })
                Button(symbol = "=",
                    modifier = Modifier
                        .background(Color.Magenta)
                        .aspectRatio(ratio = 1f)
                        .weight(1f),
                    onClick = {
                        onAction(Actions.Calculate)
                    })

            }


        }

    }
}

