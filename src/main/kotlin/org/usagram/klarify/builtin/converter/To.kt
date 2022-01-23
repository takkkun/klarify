package org.usagram.klarify.builtin.converter

import org.usagram.klarify.Output
import org.usagram.klarify.converter.Converter

class To<I, O>(
    private val convert: (I) -> Output<O>
) : Converter<I, O> {

    override fun invoke(value: I): Output<O> =
        convert(value)

    override fun toString(): String =
        "To($convert)"
}
