import java.lang.Math.random
import kotlin.math.PI

typealias DTriple = Triple<Double, Double, Double>


class TrowNeedle(
    val length: Double,
    private val paper: Paper
) {
    fun toss(): DTriple {
        val xSize = paper.xSize
        val ySize = paper.ySize

        // toss needle mass center position
        val x = random() * xSize
        val y = random() * ySize

        // toss needle rotation
        val phi = random() * 2 * PI  // angle

        return Triple(x, y, phi)
    }
}