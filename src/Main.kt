import Provider.MissionariesAndCannibalsProvider


fun main(){


    println("Enter Number Of NextState : ")

    val size = readLine()?.toInt()

    if (size != null) {
        val f = System.currentTimeMillis()
        MissionariesAndCannibalsProvider.exec(size)
        val l = System.currentTimeMillis()
        println("Time Escaped : ${l - f} in Millis")
    }

}

