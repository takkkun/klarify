package org.usagram.klarify

interface Stage<in I, out O> : (I) -> Output<O> {

    infix fun <R> then(other: Stage<O, R>): Stage<I, R> =
        Pipeline(this, other)
}
