package calculator.model

class Delimiter {
    private val number: Number = Number()

    fun calculateDefaultDelimiter(input: String): Int {
        val defaultArray = splitDefaultDelimiter(input)
        return number.sumList(defaultArray)
    }

    fun calculateCustomDelimiter(input: String): Int{
        val newInput = replaceDoubleSlash(input)
        val customDelimiterIndex = findEndIndex(newInput)
        formatValidate(customDelimiterIndex)

        val customDelimiter = extractCustmDelimiter(newInput, customDelimiterIndex)
        val numberPart = extractNumberPart(newInput, customDelimiterIndex)
        val customArray = splitCustomDelimiter(numberPart, customDelimiter)

        return number.sumList(customArray)
    }

    //    기본 구분자에 따른 문자열 분리
    private fun splitDefaultDelimiter(input: String): List<String> {
        val delimiterArray = arrayOf(DEFAULT_DELIMITER_COLON, DEFAULT_DELIMITER_COMMA)
        return input.split(*delimiterArray)
    }

    private fun replaceDoubleSlash(input: String): String {
        return input.replace(ORIGIN_POSTFIX_CUSTOM_DELIMITER, REPLACE_POSTFIX_CUSTOM_DELIMITER)
    }

    //    커스텀 구분자 파악을 위한 인덱스 추출
    private fun findEndIndex(input: String): Int {
        return input.indexOf(REPLACE_POSTFIX_CUSTOM_DELIMITER)
    }

    //    커스텀 구분자 추출
    private fun extractCustmDelimiter(input: String, endIndex: Int): String {
        return input.substring(2, endIndex)
    }

    //    커스텀 구분자 이후 숫자 부분 추출
    private fun extractNumberPart(input: String, endIndex: Int): String {
        return input.substring(endIndex + 2)
    }

    //    커스텀 배열 쪼개기
    private fun splitCustomDelimiter(input: String, customDelimiter: String): List<String> {
        return input.split(customDelimiter)
    }

    //      "//"로 시작하고 "\n"이 없는 형식 오류 판별
    private fun formatValidate(index: Int) {
        require(index != -1) { FORMAT_ERROR_MESSAGE }
    }

    companion object {
        private const val ORIGIN_POSTFIX_CUSTOM_DELIMITER = "\n"
        private const val REPLACE_POSTFIX_CUSTOM_DELIMITER = "\\n"
        private const val FORMAT_ERROR_MESSAGE = "올바른 형식이 아닙니다. 다른 값을 입력해주세요."
        private const val DEFAULT_DELIMITER_COMMA = ","
        private const val DEFAULT_DELIMITER_COLON = ":"
    }
}