import Logarithmic.LN
import Logarithmic.Log
import Trigonometry.*
import kotlin.math.*

fun Sin.stubCalc(x: Double): Double {
    return sin(x)
}

fun Cos.stubCalc(x: Double): Double {
    return cos(x)
}

fun Tan.stubCalc(x: Double): Double {
    return tan(x)
}

fun Cot.stubCalc(x: Double): Double {
    return cos(x) / sin(x)
}

fun CSC.stubCalc(x: Double): Double {
    return 1 / sin(x)
}

fun LN.stubCalc(x: Double): Double {
    return ln(x)
}

fun Log.stubCalc(x: Double): Double {
    return log(x, base)
}