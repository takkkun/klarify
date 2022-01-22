package org.usagram.klarify.builtin.validator

import org.usagram.klarify.Validity
import org.usagram.klarify.validator.Validator

object AlwaysPass : Validator<Any> {

    override fun invoke(value: Any): Validity =
        Validity.valid()

    override fun toString(): String =
        "AlwaysPass"
}
