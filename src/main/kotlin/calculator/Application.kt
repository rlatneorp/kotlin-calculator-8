package calculator

import camp.nextstep.edu.missionutils.Console

fun main() {
    // TODO: 프로그램 구현
    println("덧셈할 문자열을 입력해 주세요.")
    val choiceNum = Console.readLine()
    var noneSeparatorNum: String? = choiceNum

    if (choiceNum.contains(";")) {
        noneSeparatorNum = choiceNum?.replace(";", ",")
    }

    if (choiceNum.contains("//") && choiceNum.contains("""\n""")) {
        val customStr = choiceNum[2].toString()
        noneSeparatorNum = (choiceNum.substring(5 until choiceNum.length)).replace(customStr, ",")
    }
    println("noneSeparatorNum $noneSeparatorNum")
    var result = 0
    var numbers: List<String>? = noneSeparatorNum?.split(",")
    println(numbers)

    if (numbers != null) {
        for (number in numbers) {
            if (number.toIntOrNull() != null) {
                result += number.toInt()
            }
        }
    }

    if (result <= 0 || numbers == null) {
        throw IllegalArgumentException()
    }

    println("결과 : $result")
}

