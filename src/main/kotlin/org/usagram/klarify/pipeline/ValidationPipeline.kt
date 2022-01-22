package org.usagram.klarify.pipeline

import org.usagram.klarify.Output
import org.usagram.klarify.validator.Validator

internal class ValidationPipeline<I>(private val validator: Validator<I>) : Pipeline<I, I> {

    override fun invoke(value: I): Output<I> =
        validator(value).outputAs(value)

    override fun toString(): String =
        validator.toString()
}
