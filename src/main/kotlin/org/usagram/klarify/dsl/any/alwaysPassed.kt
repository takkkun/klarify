package org.usagram.klarify.dsl.any

import org.usagram.klarify.builtin.AlwaysPassed
import org.usagram.klarify.dsl.Dsl
import org.usagram.klarify.stage.Validator

val <T> Dsl<T>.alwaysPassed: Validator<T>
    get() = AlwaysPassed.asValidator()
