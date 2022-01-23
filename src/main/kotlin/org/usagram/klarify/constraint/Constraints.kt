package org.usagram.klarify.constraint

class Constraints<in T> private constructor(
    private val constraints: List<Constraint<T>>
) : (T) -> Test {

    internal constructor(constraint: Constraint<T>) : this(listOf(constraint))

    override fun invoke(value: T): Test {
        val identityElement: Test = Test.Passed
        return constraints.fold(identityElement) { test, constraint -> test + constraint(value) }
    }

    override fun toString(): String =
        when (constraints.size) {
            0 -> "[]"
            1 -> constraints.single().toString()
            else -> constraints.joinToString(", ", "[", "]")
        }

    operator fun <U : T> plus(other: Constraints<U>): Constraints<U> =
        Constraints(constraints + other.constraints)
}
