package calculator.model

const val PREFIX_CUSTOM_DELIMETER = "//"
const val POSTFIX_CUSTOM_DELIMETER = "\n"
const val FORMAT_ERROR_MESSAGE = "올바른 형식이 아닙니다."

class StringCalculator {
    fun calculate(input: String?): Int {
//        0 구분 여부
        if (input.isNullOrEmpty()) return 0
//        문자열 파싱
//        커스텀 구분자구분
        if (input.startsWith(PREFIX_CUSTOM_DELIMETER)) {
            extractCustmDelimeter(input)
        }
//        커스텀 구분자라면 형식 올바른지 확인하고 구분자 확인 후 구분자에 따라 배열 쪼개기
//        기본 구분자라면 구분자에 따라 쪼개기
        return 0
    }

    private fun extractCustmDelimeter(input: String): String {
        val customDelimeterIndex = input.indexOf(POSTFIX_CUSTOM_DELIMETER)
        formatValidation(customDelimeterIndex)

        val customDelimeter = input.substring(2, customDelimeterIndex)
        return customDelimeter
    }

//      "//"로 시작하고 "\n"이 없는 형식 오류 판별
//      자체적으로 IllegalArgumentException를 던짐
    private fun formatValidation(index: Int) {
        require(index != -1) { FORMAT_ERROR_MESSAGE }
    }
}