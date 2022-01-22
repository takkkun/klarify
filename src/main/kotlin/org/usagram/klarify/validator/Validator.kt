package org.usagram.klarify.validator

import org.usagram.klarify.Validity
import org.usagram.klarify.converter.Converter
import org.usagram.klarify.pipeline.Pipeline

interface Validator<in I> : (I) -> Validity {

    operator fun <T : I> plus(other: Validator<T>): Validator<T> =
        CompositeValidator(this, other)

    infix fun <T : I> then(other: Validator<T>): Pipeline<T, T> =
        Pipeline.from<T>(this) then Pipeline.from(other)

    infix fun <T : I, O> then(other: Converter<T, O>): Pipeline<T, O> =
        Pipeline.from<T>(this) then Pipeline.from(other)

    infix fun <T : I, O> then(other: Pipeline<T, O>): Pipeline<T, O> =
        Pipeline.from<T>(this) then other
}
