package Utils

import Enums.BoatRouting
import Model.State
import java.io.File

object PrintUtil {

    fun printState(Solution: MutableList<State>, Solution_Printer: StringBuilder, Solution_Count: Int) {

        // Remove NOT_SET Buffer
        //Solution.removeAll { it.boatRouting == BoatRouting.NOT_SET }
        Solution_Printer.append("\r\n")
        Solution_Printer.append("==========================Solution($Solution_Count)========================")
        Solution_Printer.append("\r\n\n")

        Solution.forEach {

            if (it.boatRouting != BoatRouting.NOT_SET) {

                if (it.boatRouting == BoatRouting.LEFT) {
                    if (it.PickUpPair.first == 2)
                        Solution_Printer.append("(ML:${it.LeftSide.first},CL:${it.LeftSide.second}) |(M,M)~~~~~~| (MR:${it.RightSide.first},CR:${it.RightSide.second})").append(
                            "\r\n"
                        )
                    else if (it.PickUpPair.first == 1 && it.PickUpPair.second == 1)
                        Solution_Printer.append("(ML:${it.LeftSide.first},CL:${it.LeftSide.second}) |(M,C)~~~~~~| (MR:${it.RightSide.first},CR:${it.RightSide.second})").append(
                            "\r\n"
                        )
                    else if (it.PickUpPair.second == 2)
                        Solution_Printer.append("(ML:${it.LeftSide.first},CL:${it.LeftSide.second}) |(C,C)~~~~~~| (MR:${it.RightSide.first},CR:${it.RightSide.second})").append(
                            "\r\n"
                        )
                    else if (it.PickUpPair.first == 1)
                        Solution_Printer.append("(ML:${it.LeftSide.first},CL:${it.LeftSide.second}) |(M,_)~~~~~~| (MR:${it.RightSide.first},CR:${it.RightSide.second})").append(
                            "\r\n"
                        )
                    else if (it.PickUpPair.second == 1)
                        Solution_Printer.append("(ML:${it.LeftSide.first},CL:${it.LeftSide.second}) |(_,C)~~~~~~| (MR:${it.RightSide.first},CR:${it.RightSide.second})").append(
                            "\r\n"
                        )
                    else
                        Solution_Printer.append("(ML:${it.LeftSide.first},CL:${it.LeftSide.second}) |(_,_)~~~~~~| (MR:${it.RightSide.first},CR:${it.RightSide.second})").append(
                            "\r\n"
                        )

                } else {
                    if (it.PickUpPair.first == 2)
                        Solution_Printer.append("(ML:${it.LeftSide.first},CL:${it.LeftSide.second}) |~~~~~~(M,M)| (MR:${it.RightSide.first},CR:${it.RightSide.second})").append(
                            "\r\n"
                        )
                    else if (it.PickUpPair.first == 1 && it.PickUpPair.second == 1)
                        Solution_Printer.append("(ML:${it.LeftSide.first},CL:${it.LeftSide.second}) |~~~~~~(M,C)| (MR:${it.RightSide.first},CR:${it.RightSide.second})").append(
                            "\r\n"
                        )
                    else if (it.PickUpPair.second == 2)
                        Solution_Printer.append("(ML:${it.LeftSide.first},CL:${it.LeftSide.second}) |~~~~~~(C,C)| (MR:${it.RightSide.first},CR:${it.RightSide.second})").append(
                            "\r\n"
                        )
                    else if (it.PickUpPair.first == 1)
                        Solution_Printer.append("(ML:${it.LeftSide.first},CL:${it.LeftSide.second}) |~~~~~~(M,_)| (MR:${it.RightSide.first},CR:${it.RightSide.second})").append(
                            "\r\n"
                        )
                    else if (it.PickUpPair.second == 1)
                        Solution_Printer.append("(ML:${it.LeftSide.first},CL:${it.LeftSide.second}) |~~~~~~(_,C)| (MR:${it.RightSide.first},CR:${it.RightSide.second})").append(
                            "\r\n"
                        )
                    else
                        Solution_Printer.append("(ML:${it.LeftSide.first},CL:${it.LeftSide.second}) |~~~~~~(_,_)| (MR:${it.RightSide.first},CR:${it.RightSide.second})").append(
                            "\r\n"
                        )
                }
            }
        }

        println(Solution_Printer)
        File("result.txt").writeText(Solution_Printer.toString())

    }

}