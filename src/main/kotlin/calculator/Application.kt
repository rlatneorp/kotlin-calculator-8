package calculator

import camp.nextstep.edu.missionutils.Console

fun main() {
    // TODO: 프로그램 구현
    println("덧셈할 문자열을 입력해 주세요.")
    val choiceNum = Console.readLine()
    val noneSeparatorNum = choiceNum?.replace(";", ",")
    val number = noneSeparatorNum?.split(",")
    print(number)
}
