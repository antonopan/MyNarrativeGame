package com.nile.pantelis.mynarrativegame.data

import android.util.Log

class StoryNodeRepository {

    private val storyNodeOne = StoryNode(
        name = "StoryNodeOne",
        narrativePiece = "You got lost in the forest, and you find two paths. On the left you cannot see its end, on the right is a tent and a campfire.",
        optionOne = "Go Left",
        optionTwo = "Go Right"
    )

    private val storyNodeTwo = StoryNode(
        name = "StoryNodeTwo",
        narrativePiece = "You follow the left path, but it does not seem to end. You are hungry and exhausted, but have a feeling that it is worth it.",
        optionOne = "Keep going",
        optionTwo = "Turn back"
    )

    private val storyNodeThree = StoryNode(
        name = "StoryNodeThree",
        narrativePiece = "You sit in the tent to rest. You feel that the tent has something inside.",
        optionOne = "Relax for a bit and leave",
        optionTwo = "Check inside"
    )

    private val storyNodeFour = StoryNode(
        name = "StoryNodeFour",
        narrativePiece = "You see the end of the path. You can see your car, but not where you remembered it to be. You get inside, and you drive to what seems like home.",
        optionOne = null,
        optionTwo = null,
    )

    private val storyNodeFive = StoryNode(
        name = "StoryNodeFive",
        narrativePiece = "You find yourself back where you started. You start feeling weird things. You need to do something, and fast",
        optionOne = "Go letF",
        optionTwo = "gou rIgt"
    )

    private val storyNodeSix = StoryNode(
        name = "StoryNodeSix",
        narrativePiece = "You go in the tent and notice an old box. Inside you find a weird glowing marble",
        optionOne = "Touch the marble",
        optionTwo = "Get out of the tent"
    )

    private val storyNodeSeven = StoryNode(
        name = "StoryNodeSeven",
        narrativePiece = "You touch it. Immediately you start feeling pain. You start seeing visions. You want to reach out to them, but you cannot move.",
        optionOne = null,
        optionTwo = null
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
            it.optionOnePath = storyNodeFour
            it.optionTwoPath = storyNodeFive
        }

        StoryNodes["StoryNodeThree"]?.let {
            it.optionOnePath = storyNodeFive
            it.optionTwoPath = storyNodeSix
        }

        StoryNodes["StoryNodeFour"]?.let {
            it.optionOnePath = null
            it.optionTwoPath = null
        }

        StoryNodes["StoryNodeFive"]?.let {
            it.optionOnePath = storyNodeTwo
            it.optionTwoPath = storyNodeThree
        }

        StoryNodes["StoryNodeSix"]?.let {
            it.optionOnePath = storyNodeSeven
            it.optionTwoPath = storyNodeThree
        }

        StoryNodes["StoryNodeSeven"]?.let {
            it.optionOnePath = null
            it.optionTwoPath = null
        }
    }

    fun getStartingStoryNode(): StoryNode {
        return getAllStoryNodes()["StoryNodeOne"]!!
    }

    fun getNodeByName(name: String): StoryNode {
        return getAllStoryNodes()[name]!!
    }
}