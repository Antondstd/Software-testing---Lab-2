package Trigonometry

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class TrigonometryTest {
    val sin = Sin()
    val cos = Cos()
    val tan = Tan()
    val csc = CSC()
    val cot = Cot()

    @Test
    fun `sin(x) based on Taylor series`() =
        sin.tabularVal.forEach { (key, value) ->
            assertEquals(value, sin.calc(key), 0.0001)
        }

    @Test
    fun `cos(x) based on sin(x)`() = cos.tabularVal.forEach { (key, value) ->
        assertEquals(value, cos.calc(key), 0.0001)
    }

    @Test
    fun `tan(x) based on sin(x) and cos(x)`() =
        tan.tabularVal.forEach { (key, value) ->
            assertEquals(value, tan.calc(key), 0.0001)
        }

    @Test
    fun `cot(x) based on cos(x) and sin(x)`() =
        cot.tabularVal.forEach { (key, value) ->
            assertEquals(value, cot.calc(key), 0.0001)
        }

    @Test
    fun `csc(x) base on sin(x)`() {
        csc.tabularVal.forEach { (key, value) ->
            assertEquals(value, csc.calc(key), 0.0001)
        }
    }
}