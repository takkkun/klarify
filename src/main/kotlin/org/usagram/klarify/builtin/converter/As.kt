package org.usagram.klarify.builtin.converter

import org.usagram.klarify.Output
import org.usagram.klarify.converter.Converter

class As<A, B>(
    private val convert: (A) -> Output<B>
) : Converter<A, B> {

    override fun invoke(value: A): Output<B> =
        convert(value)

    override fun toString(): String =
        "As($convert)"
}
