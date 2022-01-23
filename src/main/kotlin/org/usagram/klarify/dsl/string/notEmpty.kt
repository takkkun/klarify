package org.usagram.klarify.dsl.string

import org.usagram.klarify.builtin.validator.NotEmpty
import org.usagram.klarify.dsl.Dsl
import org.usagram.klarify.validator.Validator

val Dsl<String>.notEmpty: Validator<String>
    get() = NotEmpty
