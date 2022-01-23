package org.usagram.klarify.dsl.string

import org.usagram.klarify.builtin.validator.AtLeast
import org.usagram.klarify.dsl.Dsl
import org.usagram.klarify.validator.Validator

fun Dsl<String>.atLeast(n: Int): Validator<String> =
    AtLeast(n)
