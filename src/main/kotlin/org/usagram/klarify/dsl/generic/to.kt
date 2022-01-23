package org.usagram.klarify.dsl.generic

import org.usagram.klarify.Output
import org.usagram.klarify.builtin.converter.To
import org.usagram.klarify.converter.Converter
import org.usagram.klarify.dsl.Dsl

fun <I, O> Dsl<I>.to(convert: (I) -> Output<O>): Converter<I, O> =
    To(convert)
