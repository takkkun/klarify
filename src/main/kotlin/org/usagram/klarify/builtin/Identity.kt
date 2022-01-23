package org.usagram.klarify.builtin

import org.usagram.klarify.Converter
import org.usagram.klarify.Dsl
import org.usagram.klarify.Output

class Identity<T> : Converter<T, T> {

    override fun invoke(value: T): Output<T> =
        Output.completed(value)

    override fun toString(): String =
        "Identity"
}

val <T> Dsl<T>.identity: Converter<T, T>
    get() = Identity()
