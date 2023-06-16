package com.example.smarthouse_tp3.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.smarthouse_tp3.R
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState

@Composable
fun HomeScreen(
    viewModel: DeviceViewModel,
    modifier: Modifier = Modifier
) {
    val uiState by viewModel.uiState.collectAsState()
    Column() {
        Row() {
            Button(
                onClick = {
                    viewModel.fetchDevice("449f988c6f20d610")
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Text(
                    text = stringResource(R.string.load_devices),
                    modifier = Modifier.padding(8.dp))
            }
        }

        Row() {
            Button(
                onClick = {
                    viewModel.executeAction("449f988c6f20d610", "turnOn", emptyArray<String>())
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Text(
                    text = "turnOn",
                    modifier = Modifier.padding(8.dp))
            }
        }

        Row() {
            Button(
                onClick = {
                    viewModel.executeAction("449f988c6f20d610", "turnOff", emptyArray<String>())
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Text(
                    text = "turnOff",
                    modifier = Modifier.padding(8.dp))
            }
        }

        Row() {
            Text(
                text = uiState.device.toString(),
                modifier = Modifier.padding(8.dp))
        }

    }


}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {

    val viewModel: DeviceViewModel = viewModel()
    val uiState = viewModel.uiState

    HomeScreen(viewModel = viewModel())
}
