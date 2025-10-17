package calculator

import camp.nextstep.edu.missionutils.Console

fun main() {
    // TODO: 프로그램 구현
    println("덧셈할 문자열을 입력해 주세요.")
    val choiceNum = Console.readLine()
    val noneSeparatorNum = choiceNum?.replace(";", ",")
    println(noneSeparatorNum)
    val number = noneSeparatorNum?.split(",")
    println(number)
    var result = 0
    if (number != null) {
        for (i in number) {
            result += i.toInt()
        }
    }
    print(result)
}
