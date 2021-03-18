import Logarithmic.LN
import Logarithmic.Log
import Trigonometry.*
import kotlin.math.PI
import kotlin.math.abs
import kotlin.math.pow

class SystemFunction(override var esp: Double = 0.0001) : FunctionI {
    override var tabularVal: Map<Double, Double> = mapOf(
//        -PI to Double.NaN,
//        0.0 to Double.NaN,
//        -PI / 2 to Double.NaN,
//        1.0 to Double.NaN,
//        -1.56 to -0.01079,
//        -0.2 to -124.986,
//        0.1 to 18.6471,
//        0.99 to 9.1284,
//        1.01 to 9.06016,
        2.5 to 6.23645
    )
    var sin = Sin()
    var cos = Cos()
    var tan = Tan()
    var csc = CSC()
    var cot = Cot()
    var ln = LN()
    var log2 = Log(2.0)
    var log3 = Log(3.0)
    var log5 = Log(5.0)
    var log10 = Log(10.0)


    override fun calc(x: Double): Double {
        val result: Double
        if (x <= 0) {
            println("TEST $x || ${abs(x % (PI / 2))}")
            if (abs(x % (PI / 2)) == 0.0)
                return Double.NaN
            result = ((((cot.calc(x) * csc.calc(x)) + (tan.calc(x) / sin.calc(x))) / tan.calc(x)) * cos.calc(x))
        }
        else {
            if (x == 1.0) return Double.NaN
            result = (log2.calc(x) / log3.calc(x) +
                    log10.calc(x) - ln.calc(x) + log5.calc(x) / log10.calc(x))
                .pow(2.0)
        }
        return result
    }
}
