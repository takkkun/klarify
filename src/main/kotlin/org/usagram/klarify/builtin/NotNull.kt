package org.usagram.klarify.builtin

import org.usagram.klarify.stage.Converter
import org.usagram.klarify.stage.Output

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
