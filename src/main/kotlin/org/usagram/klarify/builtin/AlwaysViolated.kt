package org.usagram.klarify.builtin

import org.usagram.klarify.constraint.Constraint
import org.usagram.klarify.constraint.Test

object AlwaysViolated : Constraint<Any?> {

    override fun invoke(value: Any?): Test =
        Test.violated(Fail)

    override fun toString(): String =
        "AlwaysViolated"
}
