package Provider

import Enums.BoatRouting
import Model.State
import Utils.PrintUtil

object MissionariesAndCannibalsProvider {

    private const val MAX = 100
    private const val MAX_DEPTH = MAX
    private const val INIT_VALUE = 0
    private lateinit var Solution: MutableList<State>
    private var SolutionCount: Int = INIT_VALUE
    private lateinit var Solution_Printer: StringBuilder

    fun exec(size: Int) {


        Solution = ArrayList()
        Solution_Printer = StringBuilder()

        InitList(Solution, MAX)

        Solution[0] = State(
            size to size
            , INIT_VALUE to INIT_VALUE
            , INIT_VALUE to INIT_VALUE
            , BoatRouting.LEFT
        )

        MissionariesAndCannibalsBacktracking(
            size to size
            , INIT_VALUE to INIT_VALUE
            , INIT_VALUE to INIT_VALUE
            , BoatRouting.LEFT
            , 1
            , Solution
        )

        println("Solution Count : $SolutionCount")

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
        , PickUpPair: Pair<Int, Int>
        , boat: BoatRouting, depth: Int
        , Solution: MutableList<State>
    ): Boolean {

        // Break Point
        when {

            isEnd(LeftSide, boat) -> {
                // PrintUtil.printState(LeftSide, RightSide, PickUpPair, boat)
                SolutionCount++
                PrintUtil.printState(Solution, Solution_Printer, SolutionCount)
                return true
            }

            depth == MAX_DEPTH -> {
                return false
            }

            else -> {

                //PrintUtil.printState(LeftSide, RightSide, PickUpPair, boat)
                //println(Solution)

                    if (boat == BoatRouting.LEFT) {

                        // Check Is Next State Promising
                        if (isPromising(
                                LeftSide.first - 2 to LeftSide.second
                                , RightSide.first + 2 to RightSide.second
                                , Solution, BoatRouting.RIGHT
                                , depth
                            )
                        ) {

                            // Two missionaries cross left to right.
                            if (MissionariesAndCannibalsBacktracking(
                                LeftSide.first - 2 to LeftSide.second
                                , RightSide.first + 2 to RightSide.second
                                , 2 to 0
                                , BoatRouting.RIGHT
                                , depth + 1
                                , Solution.also {
                                    // Add Next State To Memory
                                        it[depth] = State(
                                            LeftSide.first - 2 to LeftSide.second
                                            , RightSide.first + 2 to RightSide.second
                                            , 2 to 0
                                            , BoatRouting.RIGHT
                                        )
                                }
                                )
                            ) {
                            }
                        }


                        if (isPromising(
                                LeftSide.first to LeftSide.second - 2
                                , RightSide.first to RightSide.second + 2
                                , Solution, BoatRouting.RIGHT
                                , depth
                            )
                        ) {

                            // Two cannibals cross left to right.
                            if (MissionariesAndCannibalsBacktracking(
                                LeftSide.first to LeftSide.second - 2
                                , RightSide.first to RightSide.second + 2
                                , 0 to 2
                                , BoatRouting.RIGHT
                                , depth + 1
                                , Solution.also {
                                    // Add Next State To Memory
                                        it[depth] = State(
                                            LeftSide.first to LeftSide.second - 2
                                            , RightSide.first to RightSide.second + 2
                                            , 0 to 2
                                            , BoatRouting.RIGHT
                                        )
                                }
                                )
                            ) {
                            }
                        }

                        if (isPromising(
                                LeftSide.first - 1 to LeftSide.second - 1
                                , RightSide.first + 1 to RightSide.second + 1
                                , Solution, BoatRouting.RIGHT
                                , depth
                            )
                        ) {

                            // One missionary and one cannibal cross left to right.
                            if (MissionariesAndCannibalsBacktracking(
                                LeftSide.first - 1 to LeftSide.second - 1
                                , RightSide.first + 1 to RightSide.second + 1
                                , 1 to 1
                                , BoatRouting.RIGHT
                                , depth + 1
                                , Solution.also {
                                    // Add Next State To Memory
                                        it[depth] = State(
                                            LeftSide.first - 1 to LeftSide.second - 1
                                            , RightSide.first + 1 to RightSide.second + 1
                                            , 1 to 1
                                            , BoatRouting.RIGHT
                                        )
                                }
                                )
                            ) {
                            }

                        }


                        if (isPromising(
                                LeftSide.first - 1 to LeftSide.second
                                , RightSide.first + 1 to RightSide.second
                                , Solution, BoatRouting.RIGHT
                                , depth
                            )
                        ) {

                            // One missionary crosses left to right.
                            if (MissionariesAndCannibalsBacktracking(
                                LeftSide.first - 1 to LeftSide.second
                                , RightSide.first + 1 to RightSide.second
                                , 1 to 0
                                , BoatRouting.RIGHT
                                , depth + 1
                                , Solution.also {
                                    // Add Next State To Memory
                                        it[depth] = State(
                                            LeftSide.first - 1 to LeftSide.second
                                            , RightSide.first + 1 to RightSide.second
                                            , 1 to 0
                                            , BoatRouting.RIGHT
                                        )
                                }
                                )
                            ) {
                            }

                        }


                        if (isPromising(
                                LeftSide.first to LeftSide.second - 1
                                , RightSide.first to RightSide.second + 1
                                , Solution, BoatRouting.RIGHT
                                , depth
                            )
                        ) {

                            // One cannibal crosses left to right.
                            if (MissionariesAndCannibalsBacktracking(
                                LeftSide.first to LeftSide.second - 1
                                , RightSide.first to RightSide.second + 1
                                , 0 to 1
                                , BoatRouting.RIGHT
                                , depth + 1
                                , Solution.also {
                                    // Add Next State To Memory
                                        it[depth] = State(
                                            LeftSide.first to LeftSide.second - 1
                                            , RightSide.first to RightSide.second + 1
                                            , 0 to 1
                                            , BoatRouting.RIGHT
                                        )
                                }
                                )
                            ) {
                            }

                        }

                    } else {

                        if (isPromising(
                                LeftSide.first + 2 to LeftSide.second
                                , RightSide.first - 2 to RightSide.second
                                , Solution, BoatRouting.LEFT
                                , depth
                            )
                        ) {

                            // Two missionaries cross right to left.
                            if (MissionariesAndCannibalsBacktracking(
                                LeftSide.first + 2 to LeftSide.second
                                , RightSide.first - 2 to RightSide.second
                                , 2 to 0
                                , BoatRouting.LEFT
                                , depth + 1
                                , Solution.also {
                                    // Add Next State To Memory
                                        it[depth] = State(
                                            LeftSide.first + 2 to LeftSide.second
                                            , RightSide.first - 2 to RightSide.second
                                            , 2 to 0
                                            , BoatRouting.LEFT
                                        )
                                }
                                )
                            ) {
                            }

                        }

                        if (isPromising(
                                LeftSide.first to LeftSide.second + 2
                                , RightSide.first to RightSide.second - 2
                                , Solution, BoatRouting.LEFT
                                , depth
                            )
                        ) {

                            // Two cannibals cross right to left.
                            if (MissionariesAndCannibalsBacktracking(
                                LeftSide.first to LeftSide.second + 2
                                , RightSide.first to RightSide.second - 2
                                , 0 to 2
                                , BoatRouting.LEFT
                                , depth + 1
                                , Solution.also {
                                    // Add Next State To Memory
                                        it[depth] = State(
                                            LeftSide.first to LeftSide.second + 2
                                            , RightSide.first to RightSide.second - 2
                                            , 0 to 2
                                            , BoatRouting.LEFT
                                        )
                                }
                                )
                            ) {
                            }
                        }

                        if (isPromising(
                                LeftSide.first + 1 to LeftSide.second + 1
                                , RightSide.first - 1 to RightSide.second - 1
                                , Solution, BoatRouting.LEFT
                                , depth
                            )
                        ) {

                            // One missionary and one cannibal cross right to left.
                            if (MissionariesAndCannibalsBacktracking(
                                LeftSide.first + 1 to LeftSide.second + 1
                                , RightSide.first - 1 to RightSide.second - 1
                                , 1 to 1
                                , BoatRouting.LEFT
                                , depth + 1
                                , Solution.also {
                                    // Add Next State To Memory
                                        it[depth] = State(
                                            LeftSide.first + 1 to LeftSide.second + 1
                                            , RightSide.first - 1 to RightSide.second - 1
                                            , 1 to 1
                                            , BoatRouting.LEFT
                                        )
                                }
                                )
                            ) {
                            }

                        }

                        if (isPromising(
                                LeftSide.first + 1 to LeftSide.second
                                , RightSide.first - 1 to RightSide.second
                                , Solution, BoatRouting.LEFT
                                , depth
                            )
                        ) {

                            // One missionary crosses right to left.
                            if (MissionariesAndCannibalsBacktracking(
                                LeftSide.first + 1 to LeftSide.second
                                , RightSide.first - 1 to RightSide.second
                                , 1 to 0
                                , BoatRouting.LEFT
                                , depth + 1
                                , Solution.also {
                                    // Add Next State To Memory
                                        it[depth] = State(
                                            LeftSide.first + 1 to LeftSide.second
                                            , RightSide.first - 1 to RightSide.second
                                            , 1 to 0
                                            , BoatRouting.LEFT
                                        )
                                }
                                )
                            ) {
                            }
                        }

                        if (isPromising(
                                LeftSide.first to LeftSide.second + 1
                                , RightSide.first to RightSide.second - 1
                                , Solution, BoatRouting.LEFT
                                , depth
                            )
                        ) {

                            // One cannibal crosses right to left.
                            if (MissionariesAndCannibalsBacktracking(
                                LeftSide.first to LeftSide.second + 1
                                , RightSide.first to RightSide.second - 1
                                , 0 to 1
                                , BoatRouting.LEFT
                                , depth + 1
                                , Solution.also {
                                    // Add Next State To Memory
                                        it[depth] = State(
                                            LeftSide.first to LeftSide.second + 1
                                            , RightSide.first to RightSide.second - 1
                                            , 0 to 1
                                            , BoatRouting.LEFT
                                        )
                                }
                                )
                            ) {
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
        , SolutionMap: MutableList<State>
        , boat: BoatRouting
        , depth: Int
    )
            : Boolean {

        val stateCheck = (LeftSide.first >= 0 && RightSide.first >= 0 && LeftSide.second >= 0 && RightSide.second >= 0
                && (LeftSide.first == 0 || LeftSide.first >= LeftSide.second)
                && (RightSide.first == 0 || RightSide.first >= RightSide.second))


        var isExistBefore = false


        for (i in 0 until depth) {
            if (boat == BoatRouting.LEFT) {
                if (SolutionMap[i].boatRouting == BoatRouting.LEFT)
                    isExistBefore = SolutionMap[i].LeftSide == LeftSide
            } else {
                if (SolutionMap[i].boatRouting == BoatRouting.RIGHT)
                    isExistBefore = SolutionMap[i].RightSide == RightSide
            }
        }

        return stateCheck && !isExistBefore

    }

    private fun isEnd(LeftSide: Pair<Int, Int>, boat: BoatRouting): Boolean {
        return LeftSide.first == 0 && LeftSide.second == 0 && boat == BoatRouting.RIGHT
    }

    private fun InitList(Solution: MutableList<State>, size: Int) {
        for (i in 0..size)
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