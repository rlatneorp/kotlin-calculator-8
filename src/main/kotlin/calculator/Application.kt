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
    println(noneSeparatorNum)
    val number = noneSeparatorNum?.split(",")
    println(number)
    var result = 0

    if (number != null && !number.contains(",")) {
        for (i in number) {
            result += i.toInt()
        }
    }

    if (result >= 0 || number == null || number.indexOf(",") != 1) {
        throw IllegalArgumentException()
    }

    println("결과 : $result")
}

