package org.usagram.klarify.pipeline

import org.usagram.klarify.Output
import org.usagram.klarify.converter.Converter

internal class ConversionPipeline<I, O>(private val converter: Converter<I, O>) : Pipeline<I, O> {

    override fun invoke(value: I): Output<O> =
        converter(value)

    override fun toString(): String =
        converter.toString()
}
