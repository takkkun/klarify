package org.usagram.klarify.builtin

import org.usagram.klarify.Constraint
import org.usagram.klarify.Dsl
import org.usagram.klarify.Test
import org.usagram.klarify.Validator

object AlwaysPassed : Constraint<Any?> {

    override fun invoke(value: Any?): Test =
        Test.passed()

    override fun toString(): String =
        "AlwaysPassed"
}

val <T> Dsl<T>.alwaysPassed: Validator<T>
    get() = AlwaysPassed.asValidator()
