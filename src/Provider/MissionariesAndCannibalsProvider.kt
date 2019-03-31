package Provider

import Enums.BoatRouting
import Model.State
import Utils.PrintUtil

object MissionariesAndCannibalsProvider {

    private const val MAX_DEPTH = 10
    private const val INIT_VALUE = 0
    private lateinit var Solution: MutableList<State>

    fun exec(size: Int) {

        Solution = mutableListOf(
            State(size to size, BoatRouting.LEFT)
        )

        MissionariesAndCannibalsBacktracking(
            size to size
            , INIT_VALUE to INIT_VALUE
            , INIT_VALUE to INIT_VALUE
            , BoatRouting.LEFT
            , INIT_VALUE
            , Solution
        )

    }

    /*
LeftSide : River LeftSide = First is Missionaries & Second is Cannibals
RightSide : River RightSide = First is Missionaries & Second is Cannibals
PickUpPair : People in Boat = First is Missionaries & Second is Cannibals
boat : BoatRouting
 */

    private fun MissionariesAndCannibalsBacktracking(
        LeftSide: Pair<Int, Int>
        , RightSide: Pair<Int, Int>
        , PickUpPair: Pair<Int, Int>
        , boat: BoatRouting, depth: Int
        , Solution: MutableList<State>
    ) {

        // Break Point
        when {

            isEnd(LeftSide, boat) -> {
                PrintUtil.printState(LeftSide, RightSide, PickUpPair, boat)
            }

            depth == MAX_DEPTH -> {
            }

            else -> {

                PrintUtil.printState(LeftSide, RightSide, PickUpPair, boat)
                //println(Solution)

                    if (boat == BoatRouting.LEFT) {

                        // Check Is Next State Promising
                        if (isPromising(
                                LeftSide.first - 2 to LeftSide.second
                                , RightSide.first + 2 to RightSide.second
                                , Solution, BoatRouting.RIGHT
                            )
                        ) {

                            // Two missionaries cross left to right.
                            MissionariesAndCannibalsBacktracking(
                                LeftSide.first - 2 to LeftSide.second
                                , RightSide.first + 2 to RightSide.second
                                , 2 to 0
                                , BoatRouting.RIGHT
                                , depth + 1
                                , Solution.also {
                                    // Add Next State To Memory
                                    it.add(
                                        State(RightSide.first + 2 to RightSide.second, BoatRouting.RIGHT)
                                    )
                                }
                            )
                        }


                        if (isPromising(
                                LeftSide.first to LeftSide.second - 2
                                , RightSide.first to RightSide.second + 2
                                , Solution, BoatRouting.RIGHT
                            )
                        ) {

                            // Two cannibals cross left to right.
                            MissionariesAndCannibalsBacktracking(
                                LeftSide.first to LeftSide.second - 2
                                , RightSide.first to RightSide.second + 2
                                , 0 to 2
                                , BoatRouting.RIGHT
                                , depth + 1
                                , Solution.also {
                                    // Add Next State To Memory
                                    it.add(
                                        State(RightSide.first to RightSide.second + 2, BoatRouting.RIGHT)
                                    )
                                }
                            )
                        }

                        if (isPromising(
                                LeftSide.first - 1 to LeftSide.second - 1
                                , RightSide.first + 1 to RightSide.second + 1
                                , Solution, BoatRouting.RIGHT
                            )
                        ) {

                            // One missionary and one cannibal cross left to right.
                            MissionariesAndCannibalsBacktracking(
                                LeftSide.first - 1 to LeftSide.second - 1
                                , RightSide.first + 1 to RightSide.second + 1
                                , 1 to 1
                                , BoatRouting.RIGHT
                                , depth + 1
                                , Solution.also {
                                    // Add Next State To Memory
                                    it.add(
                                        State(RightSide.first + 1 to RightSide.second + 1, BoatRouting.RIGHT)
                                    )
                                }
                            )

                        }


                        if (isPromising(
                                LeftSide.first - 1 to LeftSide.second
                                , RightSide.first + 1 to RightSide.second
                                , Solution, BoatRouting.RIGHT
                            )
                        ) {

                            // One missionary crosses left to right.
                            MissionariesAndCannibalsBacktracking(
                                LeftSide.first - 1 to LeftSide.second
                                , RightSide.first + 1 to RightSide.second
                                , 1 to 0
                                , BoatRouting.RIGHT
                                , depth + 1
                                , Solution.also {
                                    // Add Next State To Memory
                                    it.add(
                                        State(RightSide.first + 1 to RightSide.second, BoatRouting.RIGHT)
                                    )
                                }
                            )

                        }


                        if (isPromising(
                                LeftSide.first to LeftSide.second - 1
                                , RightSide.first to RightSide.second + 1
                                , Solution, BoatRouting.RIGHT
                            )
                        ) {

                            // One cannibal crosses left to right.
                            MissionariesAndCannibalsBacktracking(
                                LeftSide.first to LeftSide.second - 1
                                , RightSide.first to RightSide.second + 1
                                , 0 to 1
                                , BoatRouting.RIGHT
                                , depth + 1
                                , Solution.also {
                                    // Add Next State To Memory
                                    it.add(
                                        State(RightSide.first to RightSide.second + 1, BoatRouting.RIGHT)
                                    )
                                }
                            )

                        }

                    } else {

                        if (isPromising(
                                LeftSide.first + 2 to LeftSide.second
                                , RightSide.first - 2 to RightSide.second
                                , Solution, BoatRouting.LEFT
                            )
                        ) {

                            // Two missionaries cross right to left.
                            MissionariesAndCannibalsBacktracking(
                                LeftSide.first + 2 to LeftSide.second
                                , RightSide.first - 2 to RightSide.second
                                , 2 to 0
                                , BoatRouting.LEFT
                                , depth + 1
                                , Solution.also {
                                    // Add Next State To Memory
                                    it.add(
                                        State(LeftSide.first + 2 to LeftSide.second, BoatRouting.LEFT)
                                    )
                                }
                            )

                        }

                        if (isPromising(
                                LeftSide.first to LeftSide.second + 2
                                , RightSide.first to RightSide.second - 2
                                , Solution, BoatRouting.LEFT
                            )
                        ) {

                            // Two cannibals cross right to left.
                            MissionariesAndCannibalsBacktracking(
                                LeftSide.first to LeftSide.second + 2
                                , RightSide.first to RightSide.second - 2
                                , 0 to 2
                                , BoatRouting.LEFT
                                , depth + 1
                                , Solution.also {
                                    // Add Next State To Memory
                                    it.add(
                                        State(LeftSide.first to LeftSide.second + 2, BoatRouting.LEFT)
                                    )
                                }
                            )
                        }

                        if (isPromising(
                                LeftSide.first + 1 to LeftSide.second + 1
                                , RightSide.first - 1 to RightSide.second - 1
                                , Solution, BoatRouting.LEFT
                            )
                        ) {

                            // One missionary and one cannibal cross right to left.
                            MissionariesAndCannibalsBacktracking(
                                LeftSide.first + 1 to LeftSide.second + 1
                                , RightSide.first - 1 to RightSide.second - 1
                                , 1 to 1
                                , BoatRouting.LEFT
                                , depth + 1
                                , Solution.also {
                                    // Add Next State To Memory
                                    it.add(
                                        State(LeftSide.first + 1 to LeftSide.second + 1, BoatRouting.LEFT)
                                    )
                                }
                            )

                        }

                        if (isPromising(
                                LeftSide.first + 1 to LeftSide.second
                                , RightSide.first - 1 to RightSide.second
                                , Solution, BoatRouting.LEFT
                            )
                        ) {

                            // One missionary crosses right to left.
                            MissionariesAndCannibalsBacktracking(
                                LeftSide.first + 1 to LeftSide.second
                                , RightSide.first - 1 to RightSide.second
                                , 1 to 0
                                , BoatRouting.LEFT
                                , depth + 1
                                , Solution.also {
                                    // Add Next State To Memory
                                    it.add(
                                        State(LeftSide.first + 1 to LeftSide.second, BoatRouting.LEFT)
                                    )
                                }
                            )
                        }

                        if (isPromising(
                                LeftSide.first to LeftSide.second + 1
                                , RightSide.first to RightSide.second - 1
                                , Solution, BoatRouting.LEFT
                            )
                        ) {

                            // One cannibal crosses right to left.
                            MissionariesAndCannibalsBacktracking(
                                LeftSide.first to LeftSide.second + 1
                                , RightSide.first to RightSide.second - 1
                                , 0 to 1
                                , BoatRouting.LEFT
                                , depth + 1
                                , Solution.also {
                                    // Add Next State To Memory
                                    it.add(
                                        State(LeftSide.first to LeftSide.second + 1, BoatRouting.LEFT)
                                    )
                                }
                            )

                        }
                    }
            }
        }
    }


    private fun isPromising(
        LeftSide: Pair<Int, Int>
        , RightSide: Pair<Int, Int>
        , SolutionMap: MutableList<State>
        , boat: BoatRouting
    )
            : Boolean {

        val stateCheck = (LeftSide.first >= 0 && RightSide.first >= 0 && LeftSide.second >= 0 && RightSide.second >= 0
                && (LeftSide.first == 0 || LeftSide.first >= LeftSide.second)
                && (RightSide.first == 0 || RightSide.first >= RightSide.second))


        var isExistBefore = false

        SolutionMap.forEach {
            if (boat == BoatRouting.LEFT) {
                if (it.boatRouting == BoatRouting.LEFT)
                    isExistBefore = it.People == LeftSide
            } else {
                if (it.boatRouting == BoatRouting.RIGHT)
                    isExistBefore = it.People == RightSide
            }
        }

        return stateCheck && !isExistBefore

    }

    private fun isEnd(LeftSide: Pair<Int, Int>, boat: BoatRouting): Boolean {
        return LeftSide.first == 0 && LeftSide.second == 0 && boat == BoatRouting.RIGHT
    }


}