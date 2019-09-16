infix fun Int.tambah(other: Int) = println(this + other)
infix fun Int.kurang(other: Int) = println(this - other)

class ConditionWrapper {
    var firstValue: Any? = null
    var secondValue: Any? = null
}

infix fun Unit.`if`(condition: Any): ConditionWrapper {
    print("Jika value pertama ")
    return ConditionWrapper().apply {
        firstValue = condition
    }
}

infix fun ConditionWrapper.`is`(condition: Any): ConditionWrapper {
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
            println("\nYour condition is right 👍")
        } else {
            println("\nYour condition is wrong 🙈")
        }

        this
    }
}

infix fun ConditionWrapper.then(condition: Any): ConditionWrapper {
    print("maka value kedua ")
    return apply { secondValue = condition }
}

val `👉` = Unit

fun main() {
    1 tambah 1
    2 kurang 1

    `👉` `if` 3 * 10 `is` 30 then 2 * 10 `is` 20
}