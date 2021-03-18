package Trigonometry

import kotlin.math.PI
import kotlin.math.sqrt
import FunctionI
import kotlin.math.abs

open class Tan(override var esp: Double = 0.00001)  : FunctionI {
    var sin = Sin()
    var cos = Cos()
    override val tabularVal: Map<Double, Double> = mutableMapOf(
        0.0 to 0.0,
//        PI / 6 to sqrt(3.0) / 3.0,
//        PI / 4 to 1.0,
//        PI / 3 to sqrt(3.0),
        PI / 2 to Double.NaN,
        -PI / 2 to Double.NaN,
        PI / 3 to sqrt(3.0),
        -PI / 3 to -sqrt(3.0)
    )

    override fun calc(x: Double): Double {
        if (abs(x) == PI/2) return Double.NaN
        return sin.calc(x) / cos.calc(x)
    }
}