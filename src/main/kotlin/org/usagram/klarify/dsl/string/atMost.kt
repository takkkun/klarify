package org.usagram.klarify.dsl.string

import org.usagram.klarify.builtin.AtMost
import org.usagram.klarify.dsl.Dsl
import org.usagram.klarify.stage.Validator

fun Dsl<String>.atMost(n: Int): Validator<String> =
    AtMost(n).asValidator()
