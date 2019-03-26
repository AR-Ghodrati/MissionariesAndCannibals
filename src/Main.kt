
enum class BoatRouting{
    LEFT , RIGHT
}


fun main(){


    println("Enter Number Of People : ")


    val size = readLine()?.toInt()

    if (size != null)

        // Initial Data
        MissionariesAndCannibalsTracer(
             size
            ,size
            ,0
            ,0
            ,BoatRouting.LEFT
        )




}

fun MissionariesAndCannibalsTracer(missionaryLeft : Int , cannibalLeft : Int,
                                   missionaryRight : Int , cannibalRight : Int
                                   ,boat : BoatRouting) {


    println("($missionaryLeft,$cannibalLeft) ... ($missionaryRight,$cannibalRight)")

    // Break Point
    if (isEnd(missionaryLeft,cannibalLeft)) {

    }
    else {

        if(isPromising(missionaryLeft,missionaryRight,cannibalLeft,cannibalRight)) {

            if(boat == BoatRouting.LEFT) {

                MissionariesAndCannibalsTracer(
                    missionaryLeft - 2, cannibalLeft
                    , missionaryRight + 2, cannibalRight
                    , BoatRouting.RIGHT
                )


                MissionariesAndCannibalsTracer(
                    missionaryLeft, cannibalLeft - 2
                    , missionaryRight, cannibalRight + 2
                    , BoatRouting.RIGHT
                )

                MissionariesAndCannibalsTracer(
                    missionaryLeft - 1, cannibalLeft - 1
                    , missionaryRight + 1, cannibalRight + 1
                    , BoatRouting.RIGHT
                )


                MissionariesAndCannibalsTracer(
                    missionaryLeft - 1, cannibalLeft
                    , missionaryRight + 1, cannibalRight
                    , BoatRouting.RIGHT
                )

                MissionariesAndCannibalsTracer(
                    missionaryLeft, cannibalLeft - 1
                    , missionaryRight, cannibalRight + 1
                    , BoatRouting.RIGHT
                )

            }
            // =====================

            if(boat == BoatRouting.RIGHT) {


                MissionariesAndCannibalsTracer(
                    missionaryLeft + 2, cannibalLeft
                    , missionaryRight - 2, cannibalRight
                    , BoatRouting.LEFT
                )

                MissionariesAndCannibalsTracer(
                    missionaryLeft, cannibalLeft + 2
                    , missionaryRight, cannibalRight - 2
                    , BoatRouting.LEFT
                )

                MissionariesAndCannibalsTracer(
                    missionaryLeft + 1, cannibalLeft + 1
                    , missionaryRight - 1, cannibalRight - 1
                    , BoatRouting.LEFT
                )

                MissionariesAndCannibalsTracer(
                    missionaryLeft + 1, cannibalLeft
                    , missionaryRight - 1, cannibalRight
                    , BoatRouting.LEFT
                )

                MissionariesAndCannibalsTracer(
                    missionaryLeft, cannibalLeft + 1
                    , missionaryRight, cannibalRight - 1
                    , BoatRouting.LEFT
                )

            }

        }





    }

}


private fun isPromising(missionaryLeft : Int , missionaryRight : Int
            ,cannibalLeft : Int  , cannibalRight : Int): Boolean {
    return (missionaryLeft >= 0 && missionaryRight >= 0 && cannibalLeft >= 0 && cannibalRight >= 0
            && (missionaryLeft == 0 || missionaryLeft >= cannibalLeft)
            && (missionaryRight == 0 || missionaryRight >= cannibalRight))
}

private fun isEnd(missionaryLeft : Int ,cannibalLeft : Int) : Boolean{
    return missionaryLeft == 0 && cannibalLeft == 0
}


