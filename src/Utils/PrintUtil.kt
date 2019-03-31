package Utils

import Enums.BoatRouting
import Model.State

object PrintUtil {

    fun printState(Solution: MutableList<State>) {

        // Remove NOT_SET Buffer
        Solution.removeAll { it.boatRouting == BoatRouting.NOT_SET }
        Solution.forEach {

            if (it.boatRouting == BoatRouting.LEFT) {
                if (it.PickUpPair.first == 2)
                    println("(ML:${it.LeftSide.first},CL:${it.LeftSide.second}) |(M,M)~~~~~~| (MR:${it.RightSide.first},CR:${it.RightSide.second})")
                else if (it.PickUpPair.first == 1 && it.PickUpPair.second == 1)
                    println("(ML:${it.LeftSide.first},CL:${it.LeftSide.second}) |(M,C)~~~~~~| (MR:${it.RightSide.first},CR:${it.RightSide.second})")
                else if (it.PickUpPair.second == 2)
                    println("(ML:${it.LeftSide.first},CL:${it.LeftSide.second}) |(C,C)~~~~~~| (MR:${it.RightSide.first},CR:${it.RightSide.second})")
                else if (it.PickUpPair.first == 1)
                    println("(ML:${it.LeftSide.first},CL:${it.LeftSide.second}) |(M,_)~~~~~~| (MR:${it.RightSide.first},CR:${it.RightSide.second})")
                else if (it.PickUpPair.second == 1)
                    println("(ML:${it.LeftSide.first},CL:${it.LeftSide.second}) |(_,C)~~~~~~| (MR:${it.RightSide.first},CR:${it.RightSide.second})")
                else
                    println("(ML:${it.LeftSide.first},CL:${it.LeftSide.second}) |(_,_)~~~~~~| (MR:${it.RightSide.first},CR:${it.RightSide.second})")


            } else {
                if (it.PickUpPair.first == 2)
                    println("(ML:${it.LeftSide.first},CL:${it.LeftSide.second}) |~~~~~~(M,M)| (MR:${it.RightSide.first},CR:${it.RightSide.second})")
                else if (it.PickUpPair.first == 1 && it.PickUpPair.second == 1)
                    println("(ML:${it.LeftSide.first},CL:${it.LeftSide.second}) |~~~~~~(M,C)| (MR:${it.RightSide.first},CR:${it.RightSide.second})")
                else if (it.PickUpPair.second == 2)
                    println("(ML:${it.LeftSide.first},CL:${it.LeftSide.second}) |~~~~~~(C,C)| (MR:${it.RightSide.first},CR:${it.RightSide.second})")
                else if (it.PickUpPair.first == 1)
                    println("(ML:${it.LeftSide.first},CL:${it.LeftSide.second}) |~~~~~~(M,_)| (MR:${it.RightSide.first},CR:${it.RightSide.second})")
                else if (it.PickUpPair.second == 1)
                    println("(ML:${it.LeftSide.first},CL:${it.LeftSide.second}) |~~~~~~(_,C)| (MR:${it.RightSide.first},CR:${it.RightSide.second})")
                else
                    println("(ML:${it.LeftSide.first},CL:${it.LeftSide.second}) |~~~~~~(_,_)| (MR:${it.RightSide.first},CR:${it.RightSide.second})")

            }
        }

    }

}