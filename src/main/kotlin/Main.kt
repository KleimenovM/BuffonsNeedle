import java.lang.Math.random
import kotlin.math.PI
import kotlin.math.sqrt

fun throwANeedle(length: Double, paper: Paper): Needle{
    val x = random() * paper.xSize
    val y = random() * paper.ySize
    val phi = random() * PI
    return Needle(
        length = length,
        center = DPair(x, y),
        phi = phi
    )
}

fun main() {
    // create a sheet of paper
    val paperSize = DPair(10.0, 15.0)  // cm
    val paperLineDist = 1.0  // cm
    val paper = Paper(
        xSize = paperSize.first,
        ySize = paperSize.second,
        lineDist = paperLineDist
    )

    // set needle length
    val needleLength = 1.0  // cm

    // set number of throws
    val n = 1000

    // set two counters and history lists
    var eventCounter = 0
    var positiveCounter = 0

    val eventList = emptyList<Int>().toMutableList()
    val positiveList = emptyList<Int>().toMutableList()

    for (i in 0 until n){
        val newNeedle = throwANeedle(needleLength, paper)

        // check if the needle is fully on the sheet
        if (!paper.ifOn(newNeedle)) continue

        eventCounter += 1

        // check if there's a crossing
        if (paper.ifCross(newNeedle))
            positiveCounter += 1

        eventList.add(eventCounter)
        positiveList.add(positiveCounter)

        println("toss No. ${i+1} event No. $eventCounter last result No. $positiveCounter")
    }

    println("Expected answer: ${2 / PI}")
    println("Experimental answer: ${positiveCounter.toDouble() / eventCounter} pm ${1 / sqrt(positiveCounter.toDouble())}")

}