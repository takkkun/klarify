package org.usagram.klarify.builtin

import org.usagram.klarify.Constraint
import org.usagram.klarify.Dsl
import org.usagram.klarify.Reason
import org.usagram.klarify.Test
import org.usagram.klarify.Validator

object AlwaysViolated : Constraint<Any?> {

    override fun invoke(value: Any?): Test =
        Test.violated(Fail)

    override fun toString(): String =
        "AlwaysViolated"
}

val <T> Dsl<T>.alwaysViolated: Validator<T>
    get() = AlwaysViolated.asValidator()

object Fail : Reason {

    override fun toString(): String =
        "Fail"
}
