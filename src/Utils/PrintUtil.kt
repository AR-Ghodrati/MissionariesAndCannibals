package Utils

import Enums.BoatRouting

object PrintUtil {

    fun printState(
        LeftSide: Pair<Int, Int>,
        RightSide: Pair<Int, Int>
        , PickUpPair: Pair<Int, Int>
        , boat: BoatRouting
    ) {

        if (boat == BoatRouting.LEFT) {
            if (PickUpPair.first == 2)
                println("(ML:${LeftSide.first},CL:${LeftSide.second}) |(M,M)~~~~~~| (MR:${RightSide.first},CR:${RightSide.second})")
            else if (PickUpPair.first == 1 && PickUpPair.second == 1)
                println("(ML:${LeftSide.first},CL:${LeftSide.second}) |(M,C)~~~~~~| (MR:${RightSide.first},CR:${RightSide.second})")
            else if (PickUpPair.second == 2)
                println("(ML:${LeftSide.first},CL:${LeftSide.second}) |(C,C)~~~~~~| (MR:${RightSide.first},CR:${RightSide.second})")
            else if (PickUpPair.first == 1)
                println("(ML:${LeftSide.first},CL:${LeftSide.second}) |(M,_)~~~~~~| (MR:${RightSide.first},CR:${RightSide.second})")
            else if (PickUpPair.second == 1)
                println("(ML:${LeftSide.first},CL:${LeftSide.second}) |(_,C)~~~~~~| (MR:${RightSide.first},CR:${RightSide.second})")
            else
                println("(ML:${LeftSide.first},CL:${LeftSide.second}) |(_,_)~~~~~~| (MR:${RightSide.first},CR:${RightSide.second})")


        } else {
            if (PickUpPair.first == 2)
                println("(ML:${LeftSide.first},CL:${LeftSide.second}) |~~~~~~(M,M)| (MR:${RightSide.first},CR:${RightSide.second})")
            else if (PickUpPair.first == 1 && PickUpPair.second == 1)
                println("(ML:${LeftSide.first},CL:${LeftSide.second}) |~~~~~~(M,C)| (MR:${RightSide.first},CR:${RightSide.second})")
            else if (PickUpPair.second == 2)
                println("(ML:${LeftSide.first},CL:${LeftSide.second}) |~~~~~~(C,C)| (MR:${RightSide.first},CR:${RightSide.second})")
            else if (PickUpPair.first == 1)
                println("(ML:${LeftSide.first},CL:${LeftSide.second}) |~~~~~~(M,_)| (MR:${RightSide.first},CR:${RightSide.second})")
            else if (PickUpPair.second == 1)
                println("(ML:${LeftSide.first},CL:${LeftSide.second}) |~~~~~~(_,C)| (MR:${RightSide.first},CR:${RightSide.second})")
            else
                println("(ML:${LeftSide.first},CL:${LeftSide.second}) |~~~~~~(_,_)| (MR:${RightSide.first},CR:${RightSide.second})")

        }

    }

}