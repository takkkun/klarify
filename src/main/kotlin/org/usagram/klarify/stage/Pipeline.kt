package org.usagram.klarify.stage

internal class Pipeline<I, L, O>(
    private val stage1: Stage<I, L>,
    private val stage2: Stage<L, O>
) : Stage<I, O> {

    override fun invoke(value: I): Output<O> =
        stage1(value).flatMap(stage2)

    override fun toString(): String =
        "$stage1 -> $stage2"
}
