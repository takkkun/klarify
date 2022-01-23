package org.usagram.klarify.stage

interface Stage<in I, out O> : (I) -> Output<O> {

    infix fun <R> then(other: Stage<O, R>): Stage<I, R> =
        Pipeline(this, other)
}
