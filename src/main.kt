import java.util.Scanner

open class Base {
    fun sum(a: Int, b: Int): Int {
        return a + b
    }
}
class print : Base() {
    fun K_print(sum : Any) {
        println("Result")
        println("< " + sum + " > ")
    }
}

fun maxOf(a: Int, b: Int) : Int {
    if (a > b) {
        return a
    }
    else {
        return b
    }
}


fun printProduct(arg1: String, arg2: String) {
    // nullable
    val x: Int? = Integer.parseInt(arg1)
    val y: Int? = Integer.parseInt(arg2)

    if (x != null && y != null) {
        println(x * y)
    } else {
        println("eithe '$arg1' or '$arg2' is not a number")
    }
}

// 자동 타입 변환
// Any는 object의 최상위 객체
fun getStringLength(obj: Any): Int?{
    if (obj is String) {
        // obj가 자동으로 string 타입으로 변환
        return obj.length
    }
    return null
}

//when
fun describe(obj: Any): String {
    val a = when (obj) {
        1 -> "One"
        "Hello" -> "Greeting"
        is Long -> "Long"
        !is String -> "Not a string"
        else -> "Unknown"
    }
    return a
}

fun main(src:Array<String>) {
    var i : Int
    var j : Int
    var a = 1
    var b = 2
    var sum: Int

    println("\n< 상속 >")
    var pClass = print()
    pClass.K_print(pClass.sum(3, 2))

    println("\n< 문자열 템플릿 >")
    val s1 = "a is $a"
    println(s1)
    a = 2
    val s2 = "${s1.replace("is", "was")} \nbut now a is $a"
    println(s2)

    println("\n< 조건문 >")

    sum = maxOf(a, b)
    println("case $a, $b")
    println("result : $sum")

    println("\n< while문 >")
    val items = listOf("first index", "second index", "third index")
    var index = 0
    while (index < items.size) {
        println("item at $index is ${items[index]}")
        index++
    }

    println("\n< when문 >")
    print("1 : ")
    println(describe(1))
    print("Hello : ")
    println(describe("Hello"))
    print("Unknwn : ")
    println(describe("unknwn"))

    println("\n< ranges >")
    val x = 15
    println("x : $x, {1 ~ 10}")
    if (x in 1..10) {
        println("in range")
    }
    else {
        println("Not in range")
    }
    for(y in 1..5) println(y)

    println("\n< collection >")
    for (item in items) {
        println(item)
    }
    when {
        "zero index" in items -> println("items have index 0")
        "second index" in items -> println("items have index 2")
    }

    val fruits = listOf("banana", "avocado", "apple", "kiwi")
    fruits
            .filter { it.startsWith("a") }
            .sortedBy { it }
            .map { it.toUpperCase() }
            .forEach { println(it) }
}