package Model

import Enums.BoatRouting

class State(
    var LeftSide: Pair<Int, Int>
    , var RightSide: Pair<Int, Int>
    , var PickUpPair: Pair<Int, Int>
    , var boatRouting: BoatRouting
) {



    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as State

        if (LeftSide != other.LeftSide) return false
        if (RightSide != other.RightSide) return false
        if (PickUpPair != other.PickUpPair) return false
        if (boatRouting != other.boatRouting) return false

        return true
    }

    override fun hashCode(): Int {
        var result = LeftSide.hashCode()
        result = 31 * result + RightSide.hashCode()
        result = 31 * result + PickUpPair.hashCode()
        result = 31 * result + boatRouting.hashCode()
        return result
    }

    override fun toString(): String {
        return "State(LeftSide=$LeftSide, RightSide=$RightSide, PickUpPair=$PickUpPair, boatRouting=$boatRouting)"
    }
}