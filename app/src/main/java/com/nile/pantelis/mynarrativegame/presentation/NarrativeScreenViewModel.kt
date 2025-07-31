package com.nile.pantelis.mynarrativegame.presentation

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.nile.pantelis.mynarrativegame.data.StoryNode
import com.nile.pantelis.mynarrativegame.data.StoryNodeRepository
import com.nile.pantelis.mynarrativegame.domain.StoryOption

class NarrativeScreenViewModel(

) {
    private val storyNodeRepository = StoryNodeRepository()
    var state by mutableStateOf(storyNodeRepository.getStartingStoryNode())

    fun changeStory(option: StoryOption) {
        Log.d("Path", state.toString())
        when(option) {
            StoryOption.OptionOne -> updateStoryPath(state.optionOnePath)
            StoryOption.OptionTwo -> updateStoryPath(state.optionTwoPath)
        }
    }

    private fun updateStoryPath(path: StoryNode?) {
        if (path == null) {
            Log.d("Path", path.toString())
            return
        }
        state = storyNodeRepository.getNodeByName(path.name)
//            .let {
//            state.copy(
//                name = it.name,
//                optionOne = path.optionOne,
//                optionTwo = path.optionTwo,
//                narrativePiece = path.narrativePiece
//            )
//        }
    }

}