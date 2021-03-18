import Logarithmic.Log
import java.io.FileWriter
import java.math.BigDecimal
import java.math.RoundingMode

object СsvWriter {

    fun write(functions: Set<FunctionI>, begin: Double, end: Double, step: Double) {
        var x: Double
        var result: Double
        val file = FileWriter(System.getProperty("user.dir") + "\\test.csv", false)
        for (func in functions) {
            x = begin
            while (x <= end) {
                result = func.calc(x)
                if (result.isNaN()) {
                    x += step
                    continue
                }
                x = BigDecimal(x).setScale(6, RoundingMode.HALF_EVEN).toDouble()
                if (func is Log)
                    file.write("$x;$result;${func::class.java.simpleName}_${func.base}($x)\n")
                else
                    file.write("$x;$result;${func::class.java.simpleName}($x)\n")
                x += step
            }
        }
        file.close()
        println("FIle saved in ${System.getProperty("user.dir")}\\test.csv")
    }

    fun write(functions: Set<FunctionI>) {
        var x: Double
        var result: Double
        val file = FileWriter(System.getProperty("user.dir") + "\\test.csv", false)
        for (func in functions) {
            if (func is Log)
                func.tabularVal.forEach {(key,value) ->
                    file.write("$key;$value;${func::class.java.simpleName}_${func.base}($key)\n")
                }
            else {
                func.tabularVal.forEach { (key, value) ->
                    file.write("$key;$value;${func::class.java.simpleName}($key)\n")
                }
            }
        }
        file.close()
    }
}