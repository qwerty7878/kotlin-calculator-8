package calculator

import calculator.model.StringCalculator
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CalculatorTest {
    private val calculator = StringCalculator()

    @Test
    fun `빈 문자열 입력 시 0 반환`() {
        assertEquals(0, calculator.calculate(""))
    }

    @Test
    fun `null 입력 시 0 반환`() {
        assertEquals(0, calculator.calculate(null))
    }
}