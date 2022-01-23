package org.usagram.klarify.dsl

import org.usagram.klarify.converter.Converter
import org.usagram.klarify.pipeline.Pipeline
import org.usagram.klarify.validator.Validator

class Dsl<T> {

    infix fun <I, O> Validator<I>.then(build: Dsl<I>.() -> Pipeline<I, O>): Pipeline<I, O> =
        this then Dsl<I>().build()

    infix fun <I, O, R> Converter<I, O>.then(build: Dsl<O>.() -> Pipeline<O, R>): Pipeline<I, R> =
        this then Dsl<O>().build()

    infix fun <I, O, R> Pipeline<I, O>.then(build: Dsl<O>.() -> Pipeline<O, R>): Pipeline<I, R> =
        this then Dsl<O>().build()
}
