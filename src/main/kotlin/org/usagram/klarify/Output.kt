package org.usagram.klarify

sealed interface Output<out T> {

    fun <R> flatMap(f: (T) -> Output<R>): Output<R>

    class Completed<T>(val value: T) : Output<T> {

        override fun <R> flatMap(f: (T) -> Output<R>): Output<R> =
            f(value)

        override fun toString(): String =
            "Output.Completed($value)"
    }

    class Aborted(val reasons: Reasons) : Output<Nothing> {

        override fun <R> flatMap(f: (Nothing) -> Output<R>): Output<R> =
            this

        override fun toString(): String =
            "Output.Aborted(${reasons.joinToString(", ")})"
    }

    companion object {

        internal fun <T> completed(value: T): Output<T> =
            Completed(value)

        internal fun <T> aborted(vararg reasons: Reason): Output<T> =
            Aborted(reasons.toList())
    }
}
