import Enums.BoatRouting
import Utils.PrintUtil

const val MAX_DEPTH = 20
const val INIT_VALUE = 0


fun main(){


    println("Enter Number Of People : ")

    val size = readLine()?.toInt()

    if (size != null) {

        // Initial Data
        MissionariesAndCannibalsBacktracking(
            size to size
            , INIT_VALUE to INIT_VALUE
            , INIT_VALUE to INIT_VALUE
            , BoatRouting.LEFT
            , INIT_VALUE
        )

    }
}

/*
LeftSide : River LeftSide = First is Missionaries & Second is Cannibals
RightSide : River RightSide = First is Missionaries & Second is Cannibals
PickUpPair : People in Boat = First is Missionaries & Second is Cannibals
boat : BoatRouting
 */

fun MissionariesAndCannibalsBacktracking(
    LeftSide: Pair<Int, Int>
    , RightSide: Pair<Int, Int>
    , PickUpPair: Pair<Int, Int>
    , boat: BoatRouting, depth: Int
)
        : Boolean {

    // Break Point
    when {

        isEnd(LeftSide, boat) -> {
            PrintUtil.printState(LeftSide, RightSide, PickUpPair, boat)
            return true
        }

        depth == MAX_DEPTH -> {
            return false
        }

        else -> {

            if (isPromising(LeftSide, RightSide)) {

                PrintUtil.printState(LeftSide, RightSide, PickUpPair, boat)

                if (boat == BoatRouting.LEFT) {

                    // Two missionaries cross left to right.
                    return MissionariesAndCannibalsBacktracking(
                        LeftSide.first - 2 to LeftSide.second
                        , RightSide.first + 2 to RightSide.second
                        , 2 to 0
                        , BoatRouting.RIGHT
                        , depth + 1
                    )

                            ||

                            // Two cannibals cross left to right.
                            MissionariesAndCannibalsBacktracking(
                                LeftSide.first to LeftSide.second - 2
                                , RightSide.first to RightSide.second + 2
                                , 0 to 2
                                , BoatRouting.RIGHT
                                , depth + 1
                            )

                            ||

                            // One missionary and one cannibal cross left to right.
                            MissionariesAndCannibalsBacktracking(
                                LeftSide.first - 1 to LeftSide.second - 1
                                , RightSide.first + 1 to RightSide.second + 1
                                , 1 to 1
                                , BoatRouting.RIGHT
                                , depth + 1
                            )

                            ||

                            // One missionary crosses left to right.
                            MissionariesAndCannibalsBacktracking(
                                LeftSide.first - 1 to LeftSide.second
                                , RightSide.first + 1 to RightSide.second
                                , 1 to 0
                                , BoatRouting.RIGHT
                                , depth + 1
                            )

                            ||

                            // One cannibal crosses left to right.
                            MissionariesAndCannibalsBacktracking(
                                LeftSide.first to LeftSide.second - 1
                                , RightSide.first to RightSide.second + 1
                                , 0 to 1
                                , BoatRouting.RIGHT
                                , depth + 1
                            )

                } else {

                    // Two missionaries cross right to left.
                    return MissionariesAndCannibalsBacktracking(
                        LeftSide.first + 2 to LeftSide.second
                        , RightSide.first - 2 to RightSide.second
                        , 2 to 0
                        , BoatRouting.LEFT
                        , depth + 1
                    )

                            ||

                            // Two cannibals cross right to left.
                            MissionariesAndCannibalsBacktracking(
                                LeftSide.first to LeftSide.second + 2
                                , RightSide.first to RightSide.second - 2
                                , 0 to 2
                                , BoatRouting.LEFT
                                , depth + 1
                            )

                            ||

                            // One missionary and one cannibal cross right to left.
                            MissionariesAndCannibalsBacktracking(
                                LeftSide.first + 1 to LeftSide.second + 1
                                , RightSide.first - 1 to RightSide.second - 1
                                , 1 to 1
                                , BoatRouting.LEFT
                                , depth + 1
                            )

                            ||

                            // One missionary crosses right to left.
                            MissionariesAndCannibalsBacktracking(
                                LeftSide.first + 1 to LeftSide.second
                                , RightSide.first - 1 to RightSide.second
                                , 1 to 0
                                , BoatRouting.LEFT
                                , depth + 1
                            )

                            ||

                            // One cannibal crosses right to left.
                            MissionariesAndCannibalsBacktracking(
                                LeftSide.first to LeftSide.second + 1
                                , RightSide.first to RightSide.second - 1
                                , 0 to 1
                                , BoatRouting.LEFT
                                , depth + 1
                            )


                }
            }
            return false
        }
    }
}


private fun isPromising(LeftSide: Pair<Int, Int>, RightSide: Pair<Int, Int>): Boolean {
    return (LeftSide.first >= 0 && RightSide.first >= 0 && LeftSide.second >= 0 && RightSide.second >= 0
            && (LeftSide.first == 0 || LeftSide.first >= LeftSide.second)
            && (RightSide.first == 0 || RightSide.first >= RightSide.second))
}

private fun isEnd(LeftSide: Pair<Int, Int>, boat: BoatRouting): Boolean {
    return LeftSide.first == 0 && LeftSide.second == 0 && boat == BoatRouting.RIGHT
}





