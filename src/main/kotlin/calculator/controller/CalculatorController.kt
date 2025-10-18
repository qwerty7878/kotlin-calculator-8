package calculator.controller

import calculator.model.StringCalculator
import calculator.view.CalculatorView

class CalculatorController {
    private val inputView: CalculatorView = CalculatorView()
    private val outputView: CalculatorView = CalculatorView()
    private val calculator: StringCalculator = StringCalculator()

    fun run() {
        val input = inputView.inputView()
        val result = calculator.calculate(input)
        outputView.outputView(result)
    }
}