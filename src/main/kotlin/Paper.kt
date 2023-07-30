import kotlin.math.min
import kotlin.math.max

class Paper(
    val xSize: Double,
    val ySize: Double,
    private val lineDist: Double
) {
    private val lines = linesCoordinates()
    private fun linesCoordinates(): DoubleArray {
        val n = (ySize / lineDist).toInt() + 1
        return DoubleArray(n) { it * lineDist }
    }
    fun ifOn(needle: Needle): Boolean {
        val lowerEdge = needle.getLowerEdgeCoordinates()
        val upperEdge = needle.getUpperEdgeCoordinates()

        if (min(lowerEdge.first, upperEdge.first) < 0) return false
        if (max(lowerEdge.first, upperEdge.first) > xSize) return false

        if (lowerEdge.second < 0) return false
        if (upperEdge.second > ySize) return false

        return true
    }
    fun ifCross(needle: Needle): Boolean {
        val lowerEdge = needle.getLowerEdgeCoordinates()
        val upperEdge = needle.getUpperEdgeCoordinates()

        lines.forEach { lineY ->
            val t = (lineY - lowerEdge.second) / (upperEdge.second - lowerEdge.second)
            if (t > 0 && t < 1) {
                val xCross = lowerEdge.first + t * (upperEdge.first - lowerEdge.first)
                needle.setCrossing(DPair(xCross, lineY))
                return true
            }
        }

        return false
    }
}