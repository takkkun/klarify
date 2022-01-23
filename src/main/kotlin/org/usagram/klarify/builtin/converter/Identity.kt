package org.usagram.klarify.builtin.converter

import org.usagram.klarify.Output
import org.usagram.klarify.converter.Converter

class Identity<T> : Converter<T, T> {

    override fun invoke(value: T): Output<T> =
        Output.completed(value)

    override fun toString(): String =
        "Identity"
}
