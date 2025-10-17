package calculator

import camp.nextstep.edu.missionutils.Console

fun main() {
    // TODO: 프로그램 구현
    println("덧셈할 문자열을 입력해 주세요.")
    val choiceNum = Console.readLine()
    val customStr = customSeparator(choiceNum)
    val noneSeparatorNum = choiceNum?.replace(";", ",")
    val number = noneSeparatorNum?.split(",")
    var result = 0
    if (number != null) {
        for (i in number) {
            result += i.toInt()
        }
    }
    print(result)
}

fun customSeparator(choiceNum: String): String {
    val customStr = choiceNum.substring(2)
    return customStr
}