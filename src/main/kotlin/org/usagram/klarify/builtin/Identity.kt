package org.usagram.klarify.builtin

import org.usagram.klarify.stage.Converter
import org.usagram.klarify.stage.Output

class Identity<T> : Converter<T, T> {

    override fun invoke(value: T): Output<T> =
        Output.completed(value)

    override fun toString(): String =
        "Identity"
}
