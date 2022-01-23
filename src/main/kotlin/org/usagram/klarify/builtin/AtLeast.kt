package org.usagram.klarify.builtin

import org.usagram.klarify.Constraint
import org.usagram.klarify.Dsl
import org.usagram.klarify.Reason
import org.usagram.klarify.Test
import org.usagram.klarify.Validator

class AtLeast(private val n: Int) : Constraint<String> {

    override fun invoke(value: String): Test =
        Test.violatedIf(TooShort(n)) { value.length < n }

    override fun toString(): String =
        "AtLeast($n)"
}

fun Dsl<String>.atLeast(n: Int): Validator<String> =
    AtLeast(n).asValidator()

class TooShort(private val n: Int) : Reason {

    override fun toString(): String =
        "TooShort($n)"
}
