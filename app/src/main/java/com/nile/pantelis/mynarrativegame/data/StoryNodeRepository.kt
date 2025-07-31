package com.nile.pantelis.mynarrativegame.data

class StoryNodeRepository {

    private val storyNodeOne = StoryNode(
        name = "StoryNodeOne",
        narrativePiece = "",
        optionOne = "Go Left",
        optionTwo = "Go Right"
    )

    private val storyNodeTwo = StoryNode(
        name = "StoryNodeTwo",
        narrativePiece = "You went left and find an old bridge stretching across a misty ravine.",
        optionOne = "Cross the bridge",
        optionTwo = "Climb down into the ravine"
    )

    private val storyNodeThree = StoryNode(
        name = "StoryNodeThree",
        narrativePiece = "You went right and encounter a traveler who offers you a mysterious box.",
        optionOne = "Accept the box",
        optionTwo = "Politely decline and walk away"
    )

    private val storyNodeFour = StoryNode(
        name = "StoryNodeFour",
        narrativePiece = "Crossing the bridge, you see a strange glowing figure ahead.",
        optionOne = "Approach the figure",
        optionTwo = "Hide and observe"
    )

    private val storyNodeFive = StoryNode(
        name = "StoryNodeFive",
        narrativePiece = "Climbing into the ravine, you discover a cave entrance hidden by vines.",
        optionOne = "Enter the cave",
        optionTwo = "Continue following the ravine floor"
    )

    private val storyNodeSix = StoryNode(
        name = "StoryNodeSix",
        narrativePiece = "The traveler smiles as you accept the box. It starts to hum in your hands.",
        optionOne = "Open the box",
        optionTwo = "Throw it away"
    )

    private val storyNodeSeven = StoryNode(
        name = "StoryNodeSeven",
        narrativePiece = "You walk away from the traveler and find a forked path through ancient ruins.",
        optionOne = "Take the left path through the ruins",
        optionTwo = "Take the right path into the forest"
    )

    init {
        configureStoryPaths(getAllStoryNodes())
    }

    fun getAllStoryNodes(): Map<String, StoryNode> {
        return mapOf(
            "StoryNodeOne" to storyNodeOne,
            "StoryNodeTwo" to storyNodeTwo,
            "StoryNodeThree" to storyNodeThree,
            "StoryNodeFour" to storyNodeFour,
            "StoryNodeFive" to storyNodeFive,
            "StoryNodeSix" to storyNodeSix,
            "StoryNodeSeven" to storyNodeSeven

        )
    }

    fun configureStoryPaths(StoryNodes: Map<String, StoryNode>) {
        StoryNodes["StoryNodeOne"]?.let {
            it.optionOnePath = storyNodeTwo
            it.optionTwoPath = storyNodeThree
        }

        StoryNodes["StoryNodeTwo"]?.let {
            it.optionOnePath = storyNodeThree
            it.optionTwoPath = storyNodeFive
        }

        StoryNodes["StoryNodeThree"]?.let {
            it.optionOnePath = storyNodeTwo
            it.optionTwoPath = storyNodeSix
        }

        StoryNodes["StoryNodeFour"]?.let {
            it.optionOnePath = storyNodeFive
            it.optionTwoPath = storyNodeSeven
        }

        StoryNodes["StoryNodeFive"]?.let {
            it.optionOnePath = null
            it.optionTwoPath = null
        }

        StoryNodes["StoryNodeSix"]?.let {
            it.optionOnePath = storyNodeSeven
            it.optionTwoPath = storyNodeOne
        }

        StoryNodes["StoryNodeSeven"]?.let {
            it.optionOnePath = null
            it.optionTwoPath = null
        }
    }

    fun getStartingStoryNode(): StoryNode {
        return getAllStoryNodes()["StoryNodeOne"]!!
    }
}