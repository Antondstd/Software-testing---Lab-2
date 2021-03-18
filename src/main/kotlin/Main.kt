import Logarithmic.LN
import Logarithmic.Log
import Trigonometry.*

fun main(args: Array<String>) {
    var isCycle = true
    var isDummy = false
    var isAddFunc: Boolean
    var readFunc: String
    val sin = Sin()
    val cos = Cos()
    val tan = Tan()
    val csc = CSC()
    val cot = Cot()
    val sysfun = SystemFunction()
    val ln = LN()
    var base: Double?
    val listOfFunc: MutableSet<FunctionI> = mutableSetOf<FunctionI>()
    while (isCycle) {
        isAddFunc = true
        println("Enter the mode of the program: true - using modules || false - dummy tables")
        isDummy = !readLine().toBoolean()
        while (isAddFunc) {
            println(
                "Add function to use: sin || cos || tan || csc || cot \n " +
                        "ln || log \n " +
                        "sysfun \n " +
                        "// to continue enter 'next'"
            )
            readFunc = readLine().toString()
            when (readFunc) {
                "sin" -> listOfFunc.add(sin)
                "cos" -> listOfFunc.add(cos)
                "tan" -> listOfFunc.add(tan)
                "csc" -> listOfFunc.add(csc)
                "cot" -> listOfFunc.add(cot)
                "ln" -> listOfFunc.add(ln)
                "log" -> {
                    println("Enter the base of log")
                    try{base = readLine()?.toDouble()
                        listOfFunc.add(Log(base!!))}
                    catch (e:Exception){
                        println("Base should be an Integer")
                        continue
                    }
                }
                "sysfun" -> listOfFunc.add(sysfun)
                else -> if (listOfFunc.size == 0) println("You should add at least one function") else isAddFunc = false
            }
        }
        if(isDummy)
            СsvWriter.write(listOfFunc)
        else {
            println("Enter precision:")
            var precision:Double = Double.NaN
            while (precision.isNaN()) {
                try {
                    precision = readLine().toString().toDouble()
                }
                catch (exc:Exception){
                    println("Precision should be a number")
                }
            }

            for (func in listOfFunc)
                func.esp = precision
            println("Enter the start, end and step to count functions")
            var (begin, end, step) = readLine()!!.split(' ').map(String::toDouble)
            СsvWriter.write(listOfFunc, begin, end, step)
        }
    }

}
