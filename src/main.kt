open class Base {
    fun sum(a: Int, b: Int): Int {
        return a + b
    }
}

class print : Base() {
    fun K_print(sum: Any) {
        println("Result")
        println("< " + sum + " > ")
    }
}

fun maxOf(a: Int, b: Int): Int {
    if (a > b) {
        return a
    } else {
        return b
    }
}


fun printProduct(arg1: String, arg2: String): Unit {
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
fun getStringLength(obj: Any): Int? {
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

data class Fruit(val name: String, val num: Int)

fun sum(a: Int, b: Int) = a + b
fun mul(a: Int, b: Int) = a * b

enum class Color(val r: Int, val g: Int, val b: Int) {
    RED(255, 0, 0), ORANGE(255, 165, 0), YELLOW(255, 255, 0),
    GREEN(0, 255, 0), BLUE(0, 0, 255),
    INDIGO(75, 0, 130), VIOLET(238, 130, 238);

    fun rgb() = (r * 256 + g) * 256 + b
}

//setter
class test {
    var save: String = ""
        private set(value) {
            field = value
        }
        get

}

fun main(src: Array<String>) {
    var i: Int
    var j: Int
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
    } else {
        println("Not in range")
    }
    for (y in 1..5) println(y)

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

    val fruit = listOf(Fruit("banana", 12), Fruit("avocado", 5), Fruit("apple", 13))
    println(fruit.maxBy { it.num })

    val res1 = sum(3, 2)
    val res2 = mul(sum(3, 3), 3) // mul 함수의 인자로 sum 함수의 반환 값 전달

    println("res1 : $res1, res2 : $res2")

    println(Color.BLUE.rgb())

    var test = test()
    test.save = "setter"
    print("Value: " + test.save)
}
