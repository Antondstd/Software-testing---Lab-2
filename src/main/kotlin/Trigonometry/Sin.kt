package Trigonometry

import java.math.BigDecimal
import java.math.RoundingMode
import FunctionI
import kotlin.math.*

open class Sin(override var esp: Double = 0.00001) : FunctionI {

    override val tabularVal: Map<Double, Double> = mutableMapOf(
        0.0 to 0.0,
//        PI / 6 to 1.0 / 2.0,
//        PI / 4 to sqrt(2.0) / 2,
//        PI / 3 to sqrt(3.0) / 2,
        PI / 2 to 1.0,
        -PI / 2 to -1.0,
        -PI to 0.0,
        PI to 0.0
    )

    override fun calc(x: Double): Double {

        var result: Double = Double.MAX_VALUE
        var n = 1.0
        var topFact: Double = 1.0
        var botFact: Double = 1.0
        var newResult: Double = x

        while (abs(result - newResult) > esp) {
            result = newResult
            topFact = Math.pow(-1.0, n) * x.pow(2 * n + 1)
            botFact *= (2 * n) * (2 * n + 1)
            newResult += topFact / botFact
            n++
        }
        return BigDecimal(newResult).setScale(6, RoundingMode.HALF_EVEN).toDouble()
    }
}
