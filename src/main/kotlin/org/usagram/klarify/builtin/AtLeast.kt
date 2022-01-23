package org.usagram.klarify.builtin

import org.usagram.klarify.constraint.Constraint
import org.usagram.klarify.constraint.Test

class AtLeast(private val n: Int) : Constraint<String> {

    override fun invoke(value: String): Test =
        Test.violatedIf(TooShort(n)) { value.length < n }

    override fun toString(): String =
        "AtLeast($n)"
}
