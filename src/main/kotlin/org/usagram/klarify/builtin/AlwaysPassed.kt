package org.usagram.klarify.builtin

import org.usagram.klarify.constraint.Constraint
import org.usagram.klarify.constraint.Test

object AlwaysPassed : Constraint<Any> {

    override fun invoke(value: Any): Test =
        Test.passed()

    override fun toString(): String =
        "AlwaysPassed"
}
