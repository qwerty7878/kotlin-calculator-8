package calculator.model

class Calculator {
    private val delimiter: Delimiter = Delimiter()

    fun calculate(input: String?): Int {
        if (input.isNullOrEmpty()) return 0
        if (input.startsWith(PREFIX_CUSTOM_DELIMITER))
            return delimiter.calculateCustomDelimiter(input)
        return delimiter.calculateDefaultDelimiter(input)
    }

    companion object {
        private const val PREFIX_CUSTOM_DELIMITER = "//"
    }
}