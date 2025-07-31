package com.nile.pantelis.mynarrativegame.data

data class StoryNode(
    val name: String,
    val narrativePiece: String,
    val optionOne: String?,
    val optionTwo: String?,


    ) {
    var optionOnePath: StoryNode? = null
    var optionTwoPath: StoryNode? = null
}
