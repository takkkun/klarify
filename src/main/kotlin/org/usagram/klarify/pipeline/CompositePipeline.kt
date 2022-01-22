package org.usagram.klarify.pipeline

import org.usagram.klarify.Output

internal class CompositePipeline<I, L, O>(
    private val pipeline1: Pipeline<I, L>,
    private val pipeline2: Pipeline<L, O>
) : Pipeline<I, O> {

    override fun invoke(value: I): Output<O> =
        pipeline1(value).flatMap(pipeline2::invoke)

    override fun toString(): String =
        "$pipeline1 -> $pipeline2"
}
