package calculator

import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class ApplicationTest : NsTest() {
    @Test
    fun `커스텀 구분자 사용 1개인 경우`() {
        assertSimpleTest {
            run("//;\\n1")
            assertThat(output()).contains("결과 : 1")
        }
    }

    @Test
    fun `커스텀 구분자 사용 2개인 경우`() {
        assertSimpleTest {
            run("//;\\n1;2")
            assertThat(output()).contains("결과 : 3")
        }
    }

    @Test
    fun `커스텀 구분자 사용 3개인 경우`() {
        assertSimpleTest {
            run("//;\\n1;2;3")
            assertThat(output()).contains("결과 : 6")
        }
    }

    @Test
    fun `기본 구분자 사용(콤마) 1개인 경우`() {
        assertSimpleTest {
            run("1")
            assertThat(output()).contains("결과 : 1")
        }
    }

    @Test
    fun `기본 구분자 사용(콤마) 2개인 경우`() {
        assertSimpleTest {
            run("1,2")
            assertThat(output()).contains("결과 : 3")
        }
    }

    @Test
    fun `기본 구분자 사용(콤마) 3개인 경우`() {
        assertSimpleTest {
            run("1,2,3")
            assertThat(output()).contains("결과 : 6")
        }
    }

    @Test
    fun `기본 구분자 사용(콜론) 1개인 경우`() {
        assertSimpleTest {
            run("1")
            assertThat(output()).contains("결과 : 1")
        }
    }

    @Test
    fun `기본 구분자 사용(콜론) 2개인 경우`() {
        assertSimpleTest {
            run("1:2")
            assertThat(output()).contains("결과 : 3")
        }
    }

    @Test
    fun `기본 구분자 사용(콜론) 3개인 경우`() {
        assertSimpleTest {
            run("1:2:3")
            assertThat(output()).contains("결과 : 6")
        }
    }

    @Test
    fun `기본 구분자 사용(종합) 1개인 경우`() {
        assertSimpleTest {
            run("1")
            assertThat(output()).contains("결과 : 1")
        }
    }

    @Test
    fun `기본 구분자 사용(종합) 2개인 경우`() {
        assertSimpleTest {
            run("1,2")
            assertThat(output()).contains("결과 : 3")
        }
    }

    @Test
    fun `기본 구분자 사용(종합) 3개인 경우`() {
        assertSimpleTest {
            run("1,2:3")
            assertThat(output()).contains("결과 : 6")
        }
    }

    @Test
    fun `음수 예외 테스트`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("-1,2,3") }
        }
    }

    @Test
    fun `정수 이외의 문자 예외 테스트`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("/1,2,3") }
        }
    }

    @Test
    fun `정수 이외의 문자 예외 테스트 커스텀 구분자로 시작하는 경우`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("///1,2,3") }
        }
    }

    override fun runMain() {
        main()
    }
}
