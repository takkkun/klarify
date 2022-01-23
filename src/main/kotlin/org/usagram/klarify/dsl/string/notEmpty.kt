package org.usagram.klarify.dsl.string

import org.usagram.klarify.builtin.NotEmpty
import org.usagram.klarify.dsl.Dsl
import org.usagram.klarify.stage.Validator

val Dsl<String>.notEmpty: Validator<String>
    get() = NotEmpty.asValidator()
