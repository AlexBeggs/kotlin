package demo

internal class Test {
    internal fun test() {
        var name = "$$$$"
        name = name.replaceAll("\\$[0-9]+", "\\$")

        val c = '$'
        println(c)

        val C = '$'
        println(C)
    }
}