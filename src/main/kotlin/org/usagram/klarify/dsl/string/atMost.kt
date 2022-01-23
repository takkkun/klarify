package org.usagram.klarify.dsl.string

import org.usagram.klarify.builtin.validator.AtMost
import org.usagram.klarify.dsl.Dsl
import org.usagram.klarify.validator.Validator

fun Dsl<String>.atMost(n: Int): Validator<String> =
    AtMost(n)
