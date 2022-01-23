package org.usagram.klarify.dsl.any

import org.usagram.klarify.builtin.AlwaysViolated
import org.usagram.klarify.dsl.Dsl
import org.usagram.klarify.stage.Validator

val Dsl<*>.alwaysViolated: Validator<Any>
    get() = AlwaysViolated.asValidator()
