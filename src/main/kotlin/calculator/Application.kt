package calculator

import camp.nextstep.edu.missionutils.Console

fun main() {
    // TODO: 프로그램 구현
    println("덧셈할 문자열을 입력해 주세요.")
    val choiceNum = Console.readLine()
    val customStr = choiceNum[2].toString()
    println(customStr)
    var noneSeparatorNum: String? = ""
    if (choiceNum.contains(";")) {
        noneSeparatorNum = choiceNum?.replace(";", ",")
    }
    if (!choiceNum.contains(",")) {
        noneSeparatorNum = (choiceNum.substring(5 until choiceNum.length)).replace(customStr, ",")
    }

    val number = noneSeparatorNum?.split(",")
    var result = 0

    if (number != null) {
        for (i in number) {
            result += i.toInt()
        }
    }
    println("결과 : $result")
}

