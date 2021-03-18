package Trigonometry

import Logarithmic.LN
import Logarithmic.Log
import SystemFunction
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.mockito.Mockito
import org.mockito.Mockito.anyDouble
import stubCalc

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class IntegrityTests {
    val sinStub = Mockito.mock(Sin::class.java)
    val cosStub = Mockito.mock(Cos::class.java)
    val tanStub = Mockito.mock(Tan::class.java)
    val cscStub = Mockito.mock(CSC::class.java)
    val cotStub = Mockito.mock(Cot::class.java)
    val lnStub = Mockito.mock(LN::class.java)
    val logStub2 = Mockito.mock(Log::class.java)
    val logStub3 = Mockito.mock(Log::class.java)
    val logStub5 = Mockito.mock(Log::class.java)
    val logStub10 = Mockito.mock(Log::class.java)

    @BeforeAll
    fun `init stubs`() {
        logStub2.base = 2.0
        logStub3.base = 3.0
        logStub5.base = 5.0
        logStub10.base = 10.0
        Mockito.`when`(sinStub.calc(anyDouble())).thenAnswer { i -> sinStub.stubCalc(i.arguments[0] as Double) }
        Mockito.`when`(cosStub.calc(anyDouble())).thenAnswer { i -> cosStub.stubCalc(i.arguments[0] as Double) }
        Mockito.`when`(tanStub.calc(anyDouble())).thenAnswer { i -> tanStub.stubCalc(i.arguments[0] as Double) }
        Mockito.`when`(cscStub.calc(anyDouble())).thenAnswer { i -> cscStub.stubCalc(i.arguments[0] as Double) }
        Mockito.`when`(cotStub.calc(anyDouble())).thenAnswer { i -> cotStub.stubCalc(i.arguments[0] as Double) }
        Mockito.`when`(lnStub.calc(anyDouble())).thenAnswer { i -> lnStub.stubCalc(i.arguments[0] as Double) }
        Mockito.`when`(logStub2.calc(anyDouble())).thenAnswer { i -> logStub2.stubCalc(i.arguments[0] as Double) }
        Mockito.`when`(logStub3.calc(anyDouble())).thenAnswer { i -> logStub3.stubCalc(i.arguments[0] as Double) }
        Mockito.`when`(logStub5.calc(anyDouble())).thenAnswer { i -> logStub5.stubCalc(i.arguments[0] as Double) }
        Mockito.`when`(logStub10.calc(anyDouble())).thenAnswer { i -> logStub10.stubCalc(i.arguments[0] as Double) }
    }

    @Test
    fun `test cos`() {
        val cos = Cos()
        cos.sin = sinStub
        val cos2 = Cos()
        cos.tabularVal.forEach { (key, value) ->
            assertEquals(value, cos.calc(key), 0.0001)
        }
    }

    @Test
    fun `test tan with sin`() {
        val tan = Tan()
        tan.sin = sinStub
        tan.tabularVal.forEach { (key, value) ->
            assertEquals(value, tan.calc(key), 0.0001)
        }
    }

    @Test
    fun `test tan with cos`() {
        val tan = Tan()
        tan.cos = cosStub
        tan.tabularVal.forEach { (key, value) ->
            assertEquals(value, tan.calc(key), 0.0001)
        }
    }

    @Test
    fun `test cot with sin`() {
        val cot = Cot()
        cot.sin = sinStub
        cot.tabularVal.forEach { (key, value) ->
            assertEquals(value, cot.calc(key), 0.0001)
        }
    }

    @Test
    fun `test cot with cos`() {
        val cot = Cot()
        cot.cos = cosStub
        cot.tabularVal.forEach { (key, value) ->
            assertEquals(value, cot.calc(key), 0.0001)
        }
    }

    @Test
    fun `test csc with sin`() {
        val csc = CSC()
        csc.sin = sinStub
        csc.tabularVal.forEach { (key, value) ->
            assertEquals(value, csc.calc(key), 0.0001)
        }
    }

    @Test
    fun `test log with ln`() {
        val log2 = Log(2.0)
        log2.ln = lnStub
        val log3 = Log(3.0)
        log3.ln = lnStub
        val log5 = Log(5.0)
        log5.ln = lnStub
        val log10 = Log(10.0)
        log10.ln = lnStub
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

    @Test
    fun `test full system`() {
        val sysFun = SystemFunction()
        sysFun.sin = sinStub
        sysFun.cos = cosStub
        sysFun.tan = tanStub
        sysFun.cot = cotStub
        sysFun.csc = cscStub
        sysFun.ln = lnStub
        sysFun.log2 = logStub2
        sysFun.log3 = logStub3
        sysFun.log5 = logStub5
        sysFun.log10 = logStub10
        sysFun.tabularVal.forEach { (key, value) ->
            assertEquals(value, sysFun.calc(key), 0.01)
        }
    }
}
