package calculator.view

import camp.nextstep.edu.missionutils.Console

class CalculatorView {
    fun inputView(): String {
        printMessage()
        return Console.readLine()
    }

    fun outputView(result: Int) {
        println(OUTPUT_MESSAGE + "$result")
    }

    private fun printMessage() {
        println(START_MESSAGE)
    }

    companion object{
        private const val START_MESSAGE = "덧셈할 문자열을 입력해 주세요."
        private const val OUTPUT_MESSAGE = "결과 : "
    }
}