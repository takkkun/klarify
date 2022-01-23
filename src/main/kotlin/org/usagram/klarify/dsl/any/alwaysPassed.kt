package org.usagram.klarify.dsl.any

import org.usagram.klarify.builtin.AlwaysPassed
import org.usagram.klarify.dsl.Dsl
import org.usagram.klarify.stage.Validator

val Dsl<*>.alwaysPassed: Validator<Any>
    get() = AlwaysPassed.asValidator()
