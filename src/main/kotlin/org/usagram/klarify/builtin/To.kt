package org.usagram.klarify.builtin

import org.usagram.klarify.stage.Converter
import org.usagram.klarify.stage.Output

class To<I, O>(
    private val convert: (I) -> Output<O>
) : Converter<I, O> {

    override fun invoke(value: I): Output<O> =
        convert(value)

    override fun toString(): String =
        "To($convert)"
}
