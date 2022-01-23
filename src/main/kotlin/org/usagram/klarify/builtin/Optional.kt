package org.usagram.klarify.builtin

import org.usagram.klarify.stage.Converter
import org.usagram.klarify.stage.Output
import org.usagram.klarify.stage.Stage

class Optional<I, O>(
    private val stage: Stage<I, O>
) : Converter<I?, O?> {

    override fun invoke(value: I?): Output<O?> =
        value?.let(stage) ?: Output.completed(null)

    override fun toString(): String =
        "Optional($stage)"
}
