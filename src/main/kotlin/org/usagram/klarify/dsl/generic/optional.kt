package org.usagram.klarify.dsl.generic

import org.usagram.klarify.builtin.converter.Optional
import org.usagram.klarify.converter.Converter
import org.usagram.klarify.dsl.Dsl
import org.usagram.klarify.pipeline.Pipeline

fun <I, O> Dsl<I?>.optional(build: Dsl<I>.() -> Pipeline<I, O>): Converter<I?, O?> =
    Optional(Dsl<I>().build())
