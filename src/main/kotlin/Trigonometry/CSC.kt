package Trigonometry

import FunctionI
import kotlin.math.PI

open class CSC(override var esp: Double = 0.00001) : FunctionI {
    var sin = Sin()
    override val tabularVal: Map<Double, Double> = mutableMapOf(
        0.0 to Double.NaN,
        PI / 6 to 2.0,
        -PI / 6 to -2.0,
//        PI / 4 to sqrt(2.0),
//        PI / 3 to 2*sqrt(3.0)/3,
        PI / 2 to 1.0,
        -PI / 2 to -1.0,
        5 * PI / 6 to 2.0,
        -5 * PI / 6 to -2.0

    )

    override fun calc(x: Double): Double {
        if (x == 0.0 || x % PI == 0.0) return Double.NaN
        return 1 / sin.calc(x)
    }
}