package calculator.model

const val PREFIX_CUSTOM_DELIMETER = "//"
const val POSTFIX_CUSTOM_DELIMETER = "\n"
const val FORMAT_ERROR_MESSAGE = "올바른 형식이 아닙니다. 다른 값을 입력해주세요."
const val MINUS_NUMBER_ERROR_MESSAGE = "음수입니다. 다른 값을 입력해주세요."
const val NOT_NUMBER_ERROR_MESSAGE = "숫자가 아닙니다. 다른 값을 입력해주세요."
const val DEFAULT_DELIMETER_COMMA = ","
const val DEFAULT_DELIMETER_COLON = ":"

class StringCalculator {
    fun calculate(input: String?): Int {
        if (input.isNullOrEmpty()) return 0
        if (input.startsWith(PREFIX_CUSTOM_DELIMETER))
            return calculateCustomDelimeter(input)
        return calculateDefaultDelimeter(input)
    }

    private fun calculateDefaultDelimeter(input: String): Int {
        val defaultArray = splitDefaultDelimeter(input)
        return sumList(defaultArray)
    }

    private fun calculateCustomDelimeter(input: String): Int{
        val customDelimeterIndex = findEndIndex(input)
        formatValidation(customDelimeterIndex)

        val customDelimeter = extractCustmDelimeter(input, customDelimeterIndex)
        val numberPart = extractNumberPart(input, customDelimeterIndex)

//        커스텀 구분자에 따른 문자열 분리
        val customArray = splitCustomDelimeter(numberPart, customDelimeter)
        return sumList(customArray)
    }

    private fun sumList(array: List<String>): Int {
        val numbers = parseStringToInt(array)
        return numbers.sum()
    }

    private fun parseStringToInt(array: List<String>): List<Int> {
        var numbers = mutableListOf<Int>()
        for (strNumber in array) {
            val number = strNumber.toIntOrNull()
            val validateNumber = numberValidation(number, strNumber)
            numbers.add(validateNumber)
        }
        return numbers
    }

//    커스텀 구분자 파악을 위한 인덱스 추출
//    '\n'보다 한 칸 앞에 위치해 있으므로
//    만약 인덱스가 없어서 -1이라면 예외처리를 위해
    private fun findEndIndex(input: String): Int {
        return input.indexOf(POSTFIX_CUSTOM_DELIMETER)
    }

//    커스텀 구분자 추출
    private fun extractCustmDelimeter(input: String, endIndex: Int): String {
        return input.substring(2, endIndex)
    }

//    커스텀 구분자 이후 숫자 부분 추출
    private fun extractNumberPart(input: String, endIndex: Int): String {
        return input.substring(endIndex + 1)
    }

//    커스텀 배열 쪼개기
    private fun splitCustomDelimeter(input: String, customDelimeter: String): List<String> {
        return input.split(customDelimeter)
    }

//    기본 구분자에 따른 문자열 분리
    private fun splitDefaultDelimeter(input: String): List<String> {
        val delimeterArray = arrayOf(DEFAULT_DELIMETER_COLON, DEFAULT_DELIMETER_COMMA)
        return input.split(*delimeterArray)
    }

//      "//"로 시작하고 "\n"이 없는 형식 오류 판별
//      자체적으로 IllegalArgumentException를 던짐
    private fun formatValidation(index: Int) {
        require(index != -1) { FORMAT_ERROR_MESSAGE }
    }

//    잘못된 입력 검증 검증
    private fun numberValidation(number: Int?, strNumber: String): Int{
        require(number != null) { NOT_NUMBER_ERROR_MESSAGE }
        require(number >= 0) { MINUS_NUMBER_ERROR_MESSAGE }
        return number
    }
}