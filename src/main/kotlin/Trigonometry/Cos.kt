package Trigonometry

import FunctionI
import kotlin.math.PI
import kotlin.math.pow
import kotlin.math.sqrt

open class Cos(override var esp: Double = 0.00001) :FunctionI {
    var sin:Sin = Sin()

    override val tabularVal: Map<Double, Double> = mutableMapOf(
        0.0 to 1.0,
//        PI/6 to sqrt(3.0)/2.0,
//        PI/4 to sqrt(2.0)/2,
//        PI/3 to 1.0/2,
        PI /2 to 0.0,
        -PI /2 to 0.0,
        -PI to -1.0,
        PI to -1.0,
    )

    override fun calc(x:Double):Double{
        return sin.calc(x+PI/2)
    }
}