import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class SystemFunctionTest {
    val sysFun = SystemFunction()


    @Test
    fun `test full system`() {
        sysFun.tabularVal.forEach { (key, value) ->
            assertEquals(value, sysFun.calc(key), 0.01)
        }
    }

//    @Test
//    fun `test trigonometry when x less 0`() {
//        assertAll(
//            { assertEquals(-37.0165, sysFun.calc(-0.3), 0.01) },
//            { assertEquals(-124.986, sysFun.calc(-0.2), 0.01) },
//            { assertEquals(Double.NaN, sysFun.calc(-PI / 2), 0.01) },
//            { assertEquals(Double.NaN, sysFun.calc(0.0), 0.01) },
//            { assertEquals(-0.01079, sysFun.calc(-1.56), 0.01) },
//            { assertEquals(Double.NaN, sysFun.calc(-PI), 0.01) },
//        )
//    }
//
//    @Test
//    fun `test when x greater than 0`() {
//        assertAll(
//            { assertEquals(Double.NaN, sysFun.calc(1.0), 0.01) },
//            { assertEquals(18.6471, sysFun.calc(0.1), 0.01) },
//            { assertEquals(9.1284, sysFun.calc(0.99), 0.01) },
//            { assertEquals(9.06016, sysFun.calc(1.01), 0.01) },
//            { assertEquals(6.23645, sysFun.calc(2.5), 0.01) },
//        )
//
//    }
}