package Utils

import Enums.BoatRouting
import Model.State
import java.io.File

object PrintUtil {

    fun printState(
        Solution: MutableList<State>,
        depth: Int,
        Size: Int,
        Solution_Printer: StringBuilder,
        Solution_Count: Int
    ) {

        // Remove NOT_SET Buffer
        //Solution.removeAll { Solution[i].boatRouting == BoatRouting.NOT_SET }
        Solution_Printer.append("\r\n")
        Solution_Printer.append("==========================Solution($Solution_Count)========================")
        Solution_Printer.append("\r\n\n")

        for (i in 0..depth) {

            if (Solution[i].boatRouting != BoatRouting.NOT_SET) {

                if (Solution[i].boatRouting == BoatRouting.LEFT) {
                    if (Solution[i].PickUpPair.first == 2)
                        Solution_Printer.append("(ML:${Solution[i].LeftSide.first},CL:${Solution[i].LeftSide.second}) |(M,M)~~~~~~| (MR:${Solution[i].RightSide.first},CR:${Solution[i].RightSide.second})").append(
                            "\r\n"
                        )
                    else if (Solution[i].PickUpPair.first == 1 && Solution[i].PickUpPair.second == 1)
                        Solution_Printer.append("(ML:${Solution[i].LeftSide.first},CL:${Solution[i].LeftSide.second}) |(M,C)~~~~~~| (MR:${Solution[i].RightSide.first},CR:${Solution[i].RightSide.second})").append(
                            "\r\n"
                        )
                    else if (Solution[i].PickUpPair.second == 2)
                        Solution_Printer.append("(ML:${Solution[i].LeftSide.first},CL:${Solution[i].LeftSide.second}) |(C,C)~~~~~~| (MR:${Solution[i].RightSide.first},CR:${Solution[i].RightSide.second})").append(
                            "\r\n"
                        )
                    else if (Solution[i].PickUpPair.first == 1)
                        Solution_Printer.append("(ML:${Solution[i].LeftSide.first},CL:${Solution[i].LeftSide.second}) |(M,_)~~~~~~| (MR:${Solution[i].RightSide.first},CR:${Solution[i].RightSide.second})").append(
                            "\r\n"
                        )
                    else if (Solution[i].PickUpPair.second == 1)
                        Solution_Printer.append("(ML:${Solution[i].LeftSide.first},CL:${Solution[i].LeftSide.second}) |(_,C)~~~~~~| (MR:${Solution[i].RightSide.first},CR:${Solution[i].RightSide.second})").append(
                            "\r\n"
                        )
                    else
                        Solution_Printer.append("(ML:${Solution[i].LeftSide.first},CL:${Solution[i].LeftSide.second}) |(_,_)~~~~~~| (MR:${Solution[i].RightSide.first},CR:${Solution[i].RightSide.second})").append(
                            "\r\n"
                        )

                } else {
                    if (Solution[i].PickUpPair.first == 2)
                        Solution_Printer.append("(ML:${Solution[i].LeftSide.first},CL:${Solution[i].LeftSide.second}) |~~~~~~(M,M)| (MR:${Solution[i].RightSide.first},CR:${Solution[i].RightSide.second})").append(
                            "\r\n"
                        )
                    else if (Solution[i].PickUpPair.first == 1 && Solution[i].PickUpPair.second == 1)
                        Solution_Printer.append("(ML:${Solution[i].LeftSide.first},CL:${Solution[i].LeftSide.second}) |~~~~~~(M,C)| (MR:${Solution[i].RightSide.first},CR:${Solution[i].RightSide.second})").append(
                            "\r\n"
                        )
                    else if (Solution[i].PickUpPair.second == 2)
                        Solution_Printer.append("(ML:${Solution[i].LeftSide.first},CL:${Solution[i].LeftSide.second}) |~~~~~~(C,C)| (MR:${Solution[i].RightSide.first},CR:${Solution[i].RightSide.second})").append(
                            "\r\n"
                        )
                    else if (Solution[i].PickUpPair.first == 1)
                        Solution_Printer.append("(ML:${Solution[i].LeftSide.first},CL:${Solution[i].LeftSide.second}) |~~~~~~(M,_)| (MR:${Solution[i].RightSide.first},CR:${Solution[i].RightSide.second})").append(
                            "\r\n"
                        )
                    else if (Solution[i].PickUpPair.second == 1)
                        Solution_Printer.append("(ML:${Solution[i].LeftSide.first},CL:${Solution[i].LeftSide.second}) |~~~~~~(_,C)| (MR:${Solution[i].RightSide.first},CR:${Solution[i].RightSide.second})").append(
                            "\r\n"
                        )
                    else
                        Solution_Printer.append("(ML:${Solution[i].LeftSide.first},CL:${Solution[i].LeftSide.second}) |~~~~~~(_,_)| (MR:${Solution[i].RightSide.first},CR:${Solution[i].RightSide.second})").append(
                            "\r\n"
                        )
                }
            }
        }

        println(Solution_Printer)
        File("Results/result_$Size.txt").writeText(Solution_Printer.toString())

    }

}