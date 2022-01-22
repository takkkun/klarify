package org.usagram.klarify

sealed interface Validity {

    operator fun plus(other: Validity): Validity

    fun <T> outputAs(value: T): Output<T>

    object Valid : Validity {

        override fun plus(other: Validity): Validity =
            when (other) {
                Valid -> Valid
                is Invalid -> other
            }

        override fun <T> outputAs(value: T): Output<T> =
            Output.Completed(value)

        override fun toString(): String =
            "Validity.Valid"
    }

    class Invalid(val reasons: Reasons) : Validity {

        override fun plus(other: Validity): Validity =
            when (other) {
                Valid -> this
                is Invalid -> Invalid(reasons + other.reasons)
            }

        override fun <T> outputAs(value: T): Output<T> =
            Output.Aborted(reasons)

        override fun toString(): String =
            "Validity.Invalid(${reasons.joinToString(", ")})"
    }

    companion object {

        internal fun valid(): Validity =
            Valid

        internal fun invalid(vararg reasons: Reason): Validity =
            Invalid(reasons.toList())

        internal fun invalidIf(vararg reasons: Reason, test: () -> Boolean): Validity =
            if (test()) invalid(*reasons) else valid()
    }
}
