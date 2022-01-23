package org.usagram.klarify.builtin

import org.usagram.klarify.constraint.Constraint
import org.usagram.klarify.constraint.Test

object NotEmpty : Constraint<String> {

    override fun invoke(value: String): Test =
        Test.violatedIf(Empty) { value.isEmpty() }

    override fun toString(): String =
        "NotEmpty"
}
