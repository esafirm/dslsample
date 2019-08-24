infix fun Int.tambah(other: Int) = println(this + other)
infix fun Int.kurang(other: Int) = println(this - other)

class JikaWrapper {
    var firstValue: Any? = null
    var secondValue: Any? = null
}

infix fun Unit.jika(condition: Any): JikaWrapper {
    print("Jika value pertama ")
    return JikaWrapper().apply {
        firstValue = condition
    }
}

infix fun JikaWrapper.adalah(condition: Any): JikaWrapper {
    print("adalah $condition ")
    return if (secondValue == null) {
        apply {
            firstValue = firstValue == condition
        }
    } else {
        apply {
            secondValue = secondValue == condition
        }

        if (firstValue == true && secondValue == true) {
            println("\nKondisi kamu sudah benar 👍")
        } else {
            println("\nKondisi kamu masih salah 🙈")
        }

        this
    }
}

infix fun JikaWrapper.maka(condition: Any): JikaWrapper {
    print("maka value kedua ")
    return apply { secondValue = condition }
}

val `👉` = Unit

fun main() {
    1 tambah 1
    2 kurang 1

    `👉` jika 3 * 10 adalah 30 maka 2 * 10 adalah 20
}