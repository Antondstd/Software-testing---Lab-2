package Logarithmic

import FunctionI
import kotlin.math.E
import kotlin.math.PI
import kotlin.math.sqrt

open class Log(var base:Double,override var esp: Double = 0.00001):FunctionI {
    var ln = LN()
    override val tabularVal: Map<Double, Double>
    get(){
        when(base) {
            2.0 -> return mutableMapOf(
                2.0 to 1.0,
                4.0 to 2.0,
                8.0 to 3.0)
            3.0 -> return mutableMapOf(
                3.0 to 1.0,
                9.0 to 2.0,
                27.0 to 3.0)
            5.0 -> return mutableMapOf(
                5.0 to 1.0,
                25.0 to 2.0,
                125.0 to 3.0)
            10.0 -> return mutableMapOf(
                10.0 to 1.0,
                100.0 to 2.0,
                1000.0 to 3.0)
            else -> return mutableMapOf()
        }
    }



    override fun calc (x: Double):Double{
        if(x <=  0 || base <= 0) return Double.NaN
        return ln.calc(x)/ln.calc(base)
    }

    override fun equals(other: Any?): Boolean {
        return this.base == (other as Log).base
    }

}