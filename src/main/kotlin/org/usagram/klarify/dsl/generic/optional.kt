package org.usagram.klarify.dsl.generic

import org.usagram.klarify.builtin.Optional
import org.usagram.klarify.dsl.Dsl
import org.usagram.klarify.stage.Converter
import org.usagram.klarify.stage.Stage

fun <I, O> Dsl<I?>.optional(build: Dsl<I>.() -> Stage<I, O>): Converter<I?, O?> =
    Optional(Dsl<I>().build())
