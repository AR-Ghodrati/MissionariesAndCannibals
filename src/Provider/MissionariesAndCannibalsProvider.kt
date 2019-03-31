package Provider

import Enums.BoatRouting
import Model.State
import Utils.PrintUtil
import java.io.File

object MissionariesAndCannibalsProvider {

    private const val MAX = 20
    private const val MAX_DEPTH = MAX
    private const val INIT_VALUE = 0
    private lateinit var PossibleState: MutableList<Pair<Int, Int>>
    private lateinit var Solution: MutableList<State>
    private lateinit var Solution_Printer: StringBuilder
    private var SolutionCount: Int = INIT_VALUE
    private var Size = 0

    fun exec(size: Int) {


        Size = size
        Solution = ArrayList()

        PossibleState = mutableListOf(
            2 to 0  // Two missionaries cross
            , 0 to 2  // Two cannibals cross
            , 1 to 1  // One missionary and One cannibal
            , 1 to 0  // One missionary cross
            , 0 to 1  // One cannibal cross
        )

        Solution_Printer = StringBuilder()

        Solution_Printer.append("Solution For $Size Missionaries & $Size Cannibals")
        Solution_Printer.append("\r\n")



        InitList()

        Solution[0] = State(
            size to size
            , INIT_VALUE to INIT_VALUE
            , INIT_VALUE to INIT_VALUE
            , BoatRouting.LEFT
        )

        MissionariesAndCannibalsBacktracking(
            size to size
            , INIT_VALUE to INIT_VALUE
            , BoatRouting.LEFT
            , 1
        )


        Solution_Printer.append("\r\n==========================================\n")
        Solution_Printer.append("Solution Count : $SolutionCount")

        println("Solution Count : $SolutionCount")
        // Save Result In .txt File
        File("Results/result_$Size.txt").writeText(Solution_Printer.toString())


    }

    /*
LeftSide : River LeftSide = First is Missionaries & Second is Cannibals
RightSide : River RightSide = First is Missionaries & Second is Cannibals
PickUpPair : NextState in Boat = First is Missionaries & Second is Cannibals
boat : BoatRouting
 */

    private fun MissionariesAndCannibalsBacktracking(
        LeftSide: Pair<Int, Int>
        , RightSide: Pair<Int, Int>
        , boat: BoatRouting, depth: Int
    ): Boolean {

        when {

            isEnd(LeftSide, boat) -> {
                SolutionCount++
                PrintUtil.printState(Solution, depth, Size, Solution_Printer, SolutionCount)
                return true
            }

            depth == MAX_DEPTH -> {
                return false
            }

            else -> {

                for (possibleState in PossibleState) {

                    if (boat == BoatRouting.LEFT) {
                        if (isPromising(
                                LeftSide.first - possibleState.first to LeftSide.second - possibleState.second
                                , RightSide.first + possibleState.first to RightSide.second + possibleState.second
                                , BoatRouting.RIGHT
                                , depth
                            )
                        ) {


                            // Add Next State To Memory
                            Solution[depth] = State(
                                LeftSide.first - possibleState.first to LeftSide.second - possibleState.second
                                , RightSide.first + possibleState.first to RightSide.second + possibleState.second
                                , possibleState
                                , BoatRouting.RIGHT
                            )

                            if (MissionariesAndCannibalsBacktracking(
                                    LeftSide.first - possibleState.first to LeftSide.second - possibleState.second
                                    , RightSide.first + possibleState.first to RightSide.second + possibleState.second
                                    , BoatRouting.RIGHT
                                    , depth + 1
                                )
                            ) {
                            }
                        }
                    } else {

                        if (isPromising(
                                LeftSide.first + possibleState.first to LeftSide.second + possibleState.second
                                , RightSide.first - possibleState.first to RightSide.second - possibleState.second
                                , BoatRouting.LEFT
                                , depth
                            )
                        ) {

                            Solution[depth] = State(
                                LeftSide.first + possibleState.first to LeftSide.second + possibleState.second
                                , RightSide.first - possibleState.first to RightSide.second - possibleState.second
                                , possibleState
                                , BoatRouting.LEFT
                            )

                            if (MissionariesAndCannibalsBacktracking(
                                    LeftSide.first + possibleState.first to LeftSide.second + possibleState.second
                                    , RightSide.first - possibleState.first to RightSide.second - possibleState.second
                                    , BoatRouting.LEFT
                                    , depth + 1
                                )
                            ) {
                            }
                        }
                    }
                }
                return false

            }
        }
    }


    private fun isPromising(
        LeftSide: Pair<Int, Int>
        , RightSide: Pair<Int, Int>
        , boat: BoatRouting
        , depth: Int
    )
            : Boolean {

        val stateCheck = (LeftSide.first >= 0 && RightSide.first >= 0 && LeftSide.second >= 0 && RightSide.second >= 0
                && (LeftSide.first <= Size && LeftSide.second <= Size)
                && (RightSide.first <= Size && RightSide.second <= Size)
                && (LeftSide.first == 0 || LeftSide.first >= LeftSide.second)
                && (RightSide.first == 0 || RightSide.first >= RightSide.second))


        var isExistBefore = false


        for (i in 0 until depth)
            if (boat == BoatRouting.LEFT && Solution[i].boatRouting == BoatRouting.LEFT)
                isExistBefore = Solution[i].LeftSide == LeftSide
            else if (boat == BoatRouting.RIGHT && Solution[i].boatRouting == BoatRouting.RIGHT)
                isExistBefore = Solution[i].RightSide == RightSide


        return stateCheck && !isExistBefore

    }

    private fun isEnd(LeftSide: Pair<Int, Int>, boat: BoatRouting): Boolean {
        return LeftSide.first == 0 && LeftSide.second == 0 && boat == BoatRouting.RIGHT
    }

    private fun InitList() {
        for (i in 0..MAX_DEPTH)
            Solution.add(
                State(
                    Int.MIN_VALUE to Int.MIN_VALUE
                    , Int.MIN_VALUE to Int.MIN_VALUE
                    , Int.MIN_VALUE to Int.MIN_VALUE
                    , BoatRouting.NOT_SET
                )
            )
    }
}