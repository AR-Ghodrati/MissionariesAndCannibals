package Model

import Enums.BoatRouting

class State(var People: Pair<Int, Int>, var boatRouting: BoatRouting) {


    override fun toString(): String {
        return "State(People=$People, boatRouting=$boatRouting)"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as State

        if (People != other.People) return false
        if (boatRouting != other.boatRouting) return false

        return true
    }

    override fun hashCode(): Int {
        var result = People.hashCode()
        result = 31 * result + boatRouting.hashCode()
        return result
    }
}