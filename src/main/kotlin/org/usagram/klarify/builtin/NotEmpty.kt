package org.usagram.klarify.builtin

import org.usagram.klarify.Constraint
import org.usagram.klarify.Dsl
import org.usagram.klarify.Reason
import org.usagram.klarify.Test
import org.usagram.klarify.Validator

object NotEmpty : Constraint<String> {

    override fun invoke(value: String): Test =
        Test.violatedIf(Empty) { value.isEmpty() }

    override fun toString(): String =
        "NotEmpty"
}

val Dsl<String>.notEmpty: Validator<String>
    get() = NotEmpty.asValidator()

object Empty : Reason {

    override fun toString(): String =
        "Empty"
}
