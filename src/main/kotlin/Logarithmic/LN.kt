package Logarithmic

import FunctionI
import java.math.BigDecimal
import java.math.RoundingMode
import kotlin.math.*

open class LN(override var esp: Double = 0.00001) :FunctionI {


    override val tabularVal: Map<Double, Double> = mutableMapOf(
        E to 1.0,
        E*E to 2.0,
        E.pow(3) to 3.0

    )


    override fun calc(x: Double): Double {
        if (x < 0) return Double.NaN

        var result: Double = Double.MAX_VALUE
        var n = 1.0
        var newResult: Double = 0.0

        while (abs(result - newResult) > esp) {
            result = newResult
            newResult += (((x - 1) / (x + 1)).pow(2 * n - 1)) / (2 * n - 1)
            n++
        }
        return BigDecimal(2 * newResult).setScale(6, RoundingMode.HALF_EVEN).toDouble()
    }
}