import kotlin.math.cos
import kotlin.math.sin

typealias DPair = Pair<Double, Double>

class Needle(
    private val length: Double,
    private val center: DPair,
    private val phi: Double
    ) {
    // crossing point
    private var ifCross = false
    private var crossPoint = DPair(.0, .0)

    fun getLowerEdgeCoordinates(): DPair {
        val x = center.first
        val y = center.second
        return DPair(x - length / 2 * cos(phi), y - length / 2 * sin(phi))
    }

    fun getUpperEdgeCoordinates(): DPair {
        val x = center.first
        val y = center.second
        return DPair(x + length / 2 * cos(phi), y + length / 2 * sin(phi))
    }

    fun setCrossing(point: DPair){
        ifCross = true
        crossPoint = point
    }
}