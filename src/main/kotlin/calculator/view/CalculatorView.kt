package calculator.view

import camp.nextstep.edu.missionutils.Console

const val START_MSG = "덧셈할 문자열을 입력해 주세요."

class CalculatorView {
    fun inputView(): String {
        print(START_MSG)
        return Console.readLine()
    }
}