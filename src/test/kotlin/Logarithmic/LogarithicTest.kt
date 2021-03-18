package Logarithmic

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class LogarithicTest {
    val ln = LN()
    val log2 = Log(2.0)
    val log3 = Log(3.0)
    val log5 = Log(5.0)
    val log10 = Log(10.0)


    @Test
    fun `test ln`() {
        ln.tabularVal.forEach { (key, value) ->
            assertEquals(value, ln.calc(key), 0.0001)
        }
    }

    @Test
    fun `test log with different base`(){
        log2.tabularVal.forEach { (key, value) ->
            assertEquals(value, log2.calc(key), 0.01)
        }
        log3.tabularVal.forEach { (key, value) ->
            assertEquals(value, log3.calc(key), 0.01)
        }
        log5.tabularVal.forEach { (key, value) ->
            assertEquals(value, log5.calc(key), 0.01)
        }
        log10.tabularVal.forEach { (key, value) ->
            assertEquals(value, log10.calc(key), 0.01)
        }
    }
}