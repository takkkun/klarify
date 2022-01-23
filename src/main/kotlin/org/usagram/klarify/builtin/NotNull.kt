package org.usagram.klarify.builtin

import org.usagram.klarify.Converter
import org.usagram.klarify.Dsl
import org.usagram.klarify.Output
import org.usagram.klarify.Reason

class NotNull<T> : Converter<T?, T> {

    override fun invoke(value: T?): Output<T> =
        if (value != null) {
            Output.completed(value)
        } else {
            Output.aborted(Null)
        }

    override fun toString(): String =
        "NotNull"
}

val <T> Dsl<T?>.notNull: Converter<T?, T>
    get() = NotNull()

object Null : Reason {

    override fun toString(): String =
        "Null"
}
