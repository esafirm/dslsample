@DslMarker
annotation class TableMarker

@TableMarker
class Table {
    var name: String? = null
}

@TableMarker
class Tr {
    var name: String? = null
}


fun table(block: Table.() -> Unit) {

}

fun Table.tr(block: Tr.() -> Unit) {

}

fun main() {
    table {
        name = "Table keren"
        tr {
            name = "Tr keren"
        }
    }
}