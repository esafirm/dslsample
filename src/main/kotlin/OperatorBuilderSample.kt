class TextBuilder(builder: TextBuilder.() -> Unit) {

    private val stringBuilder = StringBuilder()

    init {
        builder.invoke(this)
    }

    override fun toString(): String = stringBuilder.toString()

    operator fun String.unaryPlus() {
        stringBuilder.append(this).append("\n")
    }
}


fun main() {
    val builder = TextBuilder {
        +"Makan"
        +"Apa"
        +"""
            Hahahahaha
        """.trimIndent()
    }

    println(builder)
}
