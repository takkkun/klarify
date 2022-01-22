package org.usagram.klarify.pipeline

import org.usagram.klarify.Output
import org.usagram.klarify.converter.Converter
import org.usagram.klarify.validator.Validator

interface Pipeline<in I, out O> : (I) -> Output<O> {

    operator fun <R> plus(other: Pipeline<O, R>): Pipeline<I, R> =
        CompositePipeline(this, other)

    infix fun then(other: Validator<O>): Pipeline<I, O> =
        this + from(other)

    infix fun <R> then(other: Converter<O, R>): Pipeline<I, R> =
        this + from(other)

    infix fun <R> then(other: Pipeline<O, R>): Pipeline<I, R> =
        this + other

    companion object {

        fun <I> from(validator: Validator<I>): Pipeline<I, I> =
            ValidationPipeline(validator)

        fun <I, O> from(converter: Converter<I, O>): Pipeline<I, O> =
            ConversionPipeline(converter)
    }
}
