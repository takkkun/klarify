package org.usagram.klarify.builtin.converter

import org.usagram.klarify.Output
import org.usagram.klarify.builtin.converter.reason.Null
import org.usagram.klarify.converter.Converter

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
