package com.nile.pantelis.mynarrativegame

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.nile.pantelis.mynarrativegame.presentation.NarrativeScreen
import com.nile.pantelis.mynarrativegame.presentation.NarrativeScreenViewModel
import com.nile.pantelis.mynarrativegame.ui.theme.MyNarrativeGameTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val viewModel = NarrativeScreenViewModel()
            MyNarrativeGameTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    NarrativeScreen(
                        viewModel = viewModel,
                        modifier = Modifier.padding(innerPadding).safeDrawingPadding(),
                    )
                }
            }
        }
    }
}

