package com.fuka.flow

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.fuka.flow.ui.theme.FlowTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FlowTheme {
                TimerScreen()
            }
        }
    }
}






@Composable
fun TimerScreen() {
    val viewModel = viewModel<TimerViewModel>()
    val timer = viewModel.countdownFlow.collectAsState(initial = 20)
    Box(modifier = Modifier.fillMaxSize()) {
        Text(
            text = timer.value.toString(),
            fontSize = 30.sp,
            modifier = Modifier.align(Alignment.Center))
    }
}