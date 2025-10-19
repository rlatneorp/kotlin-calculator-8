# kotlin-calculator-precourse
# 기능 요구 사항 만들기

### 1. **입출력 요구 사항 만들기**

```swift
덧셈할 문자열을 입력해 주세요.

결과 : 
```

### 2. 입력받은 문자열에서 숫자만 추출합니다

- 쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리합니다
    - 예: "" => 0, "1,2" => 1,2 "1,2,3" => 1,2,3  "1,2:3" => 1,2,3
- 앞의 기본 구분자(쉼표, 콜론) 외에 커스텀 구분자를 지정할 수 있습니다. 커스텀 구분자는 문자열 앞부분의 "//"와 "\n" 사이에 위치하는 문자를 커스텀 구분자로 사용합니다
    - 예를 들어 "//;\n1;2;3"과 같이 값을 입력할 경우 커스텀 구분자는 세미콜론(;)이며, 추출된 숫자는 1,2,3.

### 3. 잘못된 값을 사용자가 입력할 경우 `IllegalArgumentException`을 발생시킨 후 애플리케이션은 종료 합니다

### 4. 추출된 숫자로 덧셈 계산기를 구현합니다

# 작성한 코드의 사용 이유

### 1. “;” 가 입력된 상황

```kotlin
if (choiceNum.contains(";")) {
    noneSeparatorNum = choiceNum?.replace(";", ",")
}
```

구분자 “;” 를 “,” 로 바꿔서 나중에 구분자 “,”를 기준으로 배열을 만들려고  `replace()`를 사용하여 구분자를 통일 했습니다.

### 2. 커스텀 구분자가 입력된 상황

```kotlin
if (choiceNum.contains("//") && choiceNum.contains("""\n""")) {
        val customStr = choiceNum[2].toString()
        noneSeparatorNum = (choiceNum.substring(5 until choiceNum.length)).replace(customStr, ",")
    }
```

“//”와 “\n” 사이에 들어간 문자가 커스텀 구분자가 돼야하기 때문에, 

커스텀구분자를 만들기 위한 문자열이 포함돼 있는지 조건문을 만들고, 

인덱스 2번째에 들어간 문자를 추출하였습니다. 

그것을 `substring()`을 이용하여 커스텀 구간이 아닌 숫자들이 나오는 첫 인덱스인 5번째를 기점의 문자열에서 끝까지 잘라내고,

`replace()` 를 이용하여 구분자만 “,”로 변환하였습니다.

### 3. 구분자 “,”를 기점으로 컬렉션 만들기

```kotlin
var numbers: List<String>? = noneSeparatorNum?.split(",")
```

`split()` 를 이용하여 구분자 “,”를 기점으로 컬렉션을 만들었습니다.

### 4. 덧셈 계산기

```kotlin
if (numbers != null) {
    for (number in numbers) {
        if (number.toIntOrNull() != null) {
            result += number.toInt()
        }
    }
}
```

변수 result에 컬렉션 number가 null이 아닐때 for문을 돌려 덧셈이 되도록 하였습니다.

`toIntOrNull()` 를 이용하여 null이 아닐 경우 즉, Int일때,

number가 String이였기 때문에 `toInt()` 를 이용하여 수로 변환해주었습니다.

### 4. 예외 처리기

```kotlin
if (result <= 0 || number == null) {
    throw IllegalArgumentException()
}
```

result(계산 결과) 값이 0이 아니거나 큰 양수일 때와

number(입력한 숫자를 모아둔 컬렉션)이 null이 아닐때와

noneSeparatorNum(구분자가 통일된 구분자인 “,”일때)의 첫번째 인덱스에 온 문자가 “,”가 아닐때

`throw`를 통해 `IllegalArgumentException()` 예외를 발생시켜 프로그램을 종료시켰습니다.