package org.usagram.klarify.converter

import org.usagram.klarify.Output
import org.usagram.klarify.pipeline.Pipeline
import org.usagram.klarify.validator.Validator

interface Converter<in I, out O> : (I) -> Output<O> {

    infix fun then(other: Validator<O>): Pipeline<I, O> =
        Pipeline.from(this) then Pipeline.from(other)

    infix fun <R> then(other: Converter<O, R>): Pipeline<I, R> =
        Pipeline.from(this) then Pipeline.from(other)

    infix fun <R> then(other: Pipeline<O, R>): Pipeline<I, R> =
        Pipeline.from(this) then other
}
