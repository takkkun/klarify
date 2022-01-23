package org.usagram.klarify.dsl.string

import org.usagram.klarify.builtin.AtLeast
import org.usagram.klarify.dsl.Dsl
import org.usagram.klarify.stage.Validator

fun Dsl<String>.atLeast(n: Int): Validator<String> =
    AtLeast(n).asValidator()
