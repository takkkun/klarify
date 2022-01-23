package org.usagram.klarify.builtin

import org.usagram.klarify.Converter
import org.usagram.klarify.Dsl
import org.usagram.klarify.Output
import org.usagram.klarify.Stage

class Optional<I, O>(
    private val stage: Stage<I, O>
) : Converter<I?, O?> {

    override fun invoke(value: I?): Output<O?> =
        value?.let(stage) ?: Output.completed(null)

    override fun toString(): String =
        "Optional($stage)"
}

fun <I, O> Dsl<I?>.optional(build: Dsl<I>.() -> Stage<I, O>): Converter<I?, O?> =
    Optional(Dsl<I>().build())
