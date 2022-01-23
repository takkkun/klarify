package org.usagram.klarify.builtin

import org.usagram.klarify.Converter
import org.usagram.klarify.Dsl
import org.usagram.klarify.Output

class To<I, O>(
    private val convert: (I) -> Output<O>
) : Converter<I, O> {

    override fun invoke(value: I): Output<O> =
        convert(value)

    override fun toString(): String =
        "To($convert)"
}

fun <I, O> Dsl<I>.to(convert: (I) -> Output<O>): Converter<I, O> =
    To(convert)
