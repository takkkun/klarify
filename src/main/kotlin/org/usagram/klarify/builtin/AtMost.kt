package org.usagram.klarify.builtin

import org.usagram.klarify.constraint.Constraint
import org.usagram.klarify.constraint.Test

class AtMost(private val n: Int) : Constraint<String> {

    override fun invoke(value: String): Test =
        Test.violatedIf(TooLong(n)) { value.length > n }

    override fun toString(): String =
        "AtMost($n)"
}
