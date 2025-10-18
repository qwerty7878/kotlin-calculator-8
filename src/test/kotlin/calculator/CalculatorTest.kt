package calculator

import calculator.model.StringCalculator
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

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

    @Test
    fun `커스텀 구분자 형식이 올바르지 않은 경우 예외처리 슬래시가 하나인 경우`() {
//        기본 구분자로 분류가 됨 바로 정수변환이 되는게 아닌 '/' 이 포함되어 있기 때문에 이를 처리할 로직을 구현해야함
        assertThrows<IllegalArgumentException> {
            calculator.calculate("/;\\n1;2;3")
        }
    }

    @Test
    fun `커스텀 구분자 형식이 올바르지 않은 경우 예외처리 커스텀 구분자가 없는 경우`() {
        assertThrows<IllegalArgumentException> {
            calculator.calculate("//\\n1;2;3")
        }
    }

    @Test
    fun `커스텀 구분자 형식이 올바르지 않은 경우 예외처리 여러개의 앞 구분자만 있는 경우`() {
        assertThrows<IllegalArgumentException> {
            calculator.calculate("////\\n1;2;3")
        }
    }

    @Test
    fun `커스텀 구분자 형식이 올바르지 않은 경우 예외처리 여러개의 뒷 구분자가 있는 경우`() {
        assertThrows<IllegalArgumentException> {
            calculator.calculate("//")
        }
    }

    @Test
    fun `커스텀 구분자 형식이 올바르지 않은 경우 예외처리 앞 구분자만 있는 경우`() {
        assertThrows<IllegalArgumentException> {
            calculator.calculate("//\\n\\n1;2;3")
        }
    }


    @Test
    fun `커스텀 구분자 형식이 올바르지 않은 경우 예외처리 뒷 구분자가 없는 경우`() {
        assertThrows<IllegalArgumentException> {
            calculator.calculate("//;1;2;3")
        }
    }

    @Test
    fun `커스텀 구분자로 문자열 분리`() {
        var array = calculator.calculate("//;\\n1;2;3")
        assertEquals(6, array)
    }

    @Test
    fun `기본 구분자(쉼표) 로 문자열 분리`() {
        var array = calculator.calculate("1,2,3")
        assertEquals(6,array)
    }

    @Test
    fun `기본 구분자(콤마) 로 문자열 분리`() {
        var array = calculator.calculate("1:2:3")
        assertEquals(6,array)
    }

    @Test
    fun `기본 구분자(쉼표 + 콤마) 로 문자열 분리`() {
        var array = calculator.calculate("1,2:3")
        assertEquals(6,array)
    }

    @Test
    fun `음수 입력 시 IllegalArgumentException 발생`() {
        assertThrows<IllegalArgumentException> {
            calculator.calculate("-1;2;3")
        }
    }
}