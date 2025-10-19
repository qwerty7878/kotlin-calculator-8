package calculator.model

class Number {
    fun sumList(array: List<String>): Int {
        val numbers = parseStringToInt(array)
        return numbers.sum()
    }

    private fun parseStringToInt(array: List<String>): List<Int> {
        var numbers = mutableListOf<Int>()
        for (strNumber in array) {
            val number = strNumber.toIntOrNull()
            val validateNumber = numberValidate(number)
            numbers.add(validateNumber)
        }
        return numbers
    }

    //    잘못된 입력 검증 검증
    private fun numberValidate(number: Int?): Int{
        require(number != null) { NOT_NUMBER_ERROR_MESSAGE }
        require(number >= 0) { MINUS_NUMBER_ERROR_MESSAGE }
        return number
    }

    companion object {
        private const val MINUS_NUMBER_ERROR_MESSAGE = "음수입니다. 다른 값을 입력해주세요."
        private const val NOT_NUMBER_ERROR_MESSAGE = "숫자가 아닙니다. 다른 값을 입력해주세요."
    }
}