internal class A {
    private var d1 = 1.0
    private var d2 = 1.0
    private val d3 = 1.0
    private val d4 = 1.0
    private val d5 = 1.0
    private val d6 = 1.0
    private val d7 = Math.sqrt(2.0) - 1

    internal fun foo1(d: Double) {
    }

    internal fun foo2(d: Double?) {
    }

    internal fun bar() {
        foo1(1.0)
        foo1(1.0)
        foo1(1.0)
        foo2(1.0)
        d1 = 1.0
        d2 = 1.0
    }
}
