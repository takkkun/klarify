package org.usagram.klarify.dsl.generic

import org.usagram.klarify.builtin.To
import org.usagram.klarify.dsl.Dsl
import org.usagram.klarify.stage.Converter
import org.usagram.klarify.stage.Output

fun <I, O> Dsl<I>.to(convert: (I) -> Output<O>): Converter<I, O> =
    To(convert)
