package com.nile.pantelis.mynarrativegame.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.nile.pantelis.mynarrativegame.domain.StoryOption
import com.nile.pantelis.mynarrativegame.ui.theme.MyNarrativeGameTheme

@Composable
fun NarrativeScreen(modifier: Modifier, viewModel: NarrativeScreenViewModel){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.LightGray)
            .then(modifier)
    ) {
        Text(
            text = viewModel.state.narrativePiece
        )

        Row(
//            modifier = Modifier.weight(1f)
        ) {
            Button(
                modifier = Modifier,
                onClick = { viewModel.changeStory(StoryOption.OptionOne) }
            ) {
                viewModel.state.optionOne?.let { Text(it) }
            }
            Button(
                modifier = Modifier,
                onClick = { viewModel.changeStory(StoryOption.OptionTwo) }
            ) {
                viewModel.state.optionTwo?.let { Text(it) }
            }
        }
    }


}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyNarrativeGameTheme {
        NarrativeScreen(
            modifier = Modifier.fillMaxWidth(),
            viewModel = NarrativeScreenViewModel()
        )
    }
}

