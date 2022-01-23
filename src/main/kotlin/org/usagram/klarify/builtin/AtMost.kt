package org.usagram.klarify.builtin

import org.usagram.klarify.Constraint
import org.usagram.klarify.Dsl
import org.usagram.klarify.Reason
import org.usagram.klarify.Test
import org.usagram.klarify.Validator

class AtMost(private val n: Int) : Constraint<String> {

    override fun invoke(value: String): Test =
        Test.violatedIf(TooLong(n)) { value.length > n }

    override fun toString(): String =
        "AtMost($n)"
}

fun Dsl<String>.atMost(n: Int): Validator<String> =
    AtMost(n).asValidator()

class TooLong(private val n: Int) : Reason {

    override fun toString(): String =
        "TooLong($n)"
}
