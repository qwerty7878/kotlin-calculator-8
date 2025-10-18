package calculator.view

import camp.nextstep.edu.missionutils.Console

const val START_MSG = "덧셈할 문자열을 입력해 주세요."
const val OUTPUT_MESSAGE = "결과 : "

class CalculatorView {
    fun inputView(): String {
        printMessage()
        return Console.readLine()
    }

    fun outputView(result: Int) {
        println(OUTPUT_MESSAGE + "$result")
    }

    private fun printMessage() {
        println(START_MSG)
    }
}