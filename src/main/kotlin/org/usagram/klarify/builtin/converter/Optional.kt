package org.usagram.klarify.builtin.converter

import org.usagram.klarify.Output
import org.usagram.klarify.converter.Converter
import org.usagram.klarify.pipeline.Pipeline

class Optional<I, O>(
    private val pipeline: Pipeline<I, O>
) : Converter<I?, O?> {

    override fun invoke(value: I?): Output<O?> =
        value?.let(pipeline) ?: Output.completed(null)

    override fun toString(): String =
        "Optional($pipeline)"
}
