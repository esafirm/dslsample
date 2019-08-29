typealias Builder = GraphQLBuilder.() -> Unit

class GraphQLBuilder(private val name: String) {
    val childs = mutableListOf<GraphQLBuilder>()

    override fun toString(): String {
        val parent = nodeAsString()
        val child = childs.fold("") { acc, graphQLBuilder ->
            "$acc\n$graphQLBuilder"
        }
        return parent.format(child)
    }

    private fun nodeAsString(): String {
        if (childs.isNotEmpty()) {
            return "{$name\n%s}"
        }
        return name
    }
}

fun GraphQLBuilder.query(name: String, block: GraphQLBuilder.() -> Unit = {}): GraphQLBuilder {
    return GraphQLBuilder(name).apply(block).also {
        this.childs.add(it)
    }
}

internal operator fun String.invoke(block: GraphQLBuilder.() -> Unit): GraphQLBuilder {
    return GraphQLBuilder(this).apply(block)
}

fun main() {
    val builder = "users" {
        query("name")
        query("address") {
            query("city")
            query("postCode")
        }
    }

    println(builder.toString())
}