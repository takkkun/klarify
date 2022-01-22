package org.usagram.klarify.builtin.validator

import org.usagram.klarify.Validity
import org.usagram.klarify.builtin.validator.reason.Fail
import org.usagram.klarify.validator.Validator

object AlwaysFail : Validator<Any> {

    override fun invoke(value: Any): Validity =
        Validity.invalid(Fail)

    override fun toString(): String =
        "AlwaysFail"
}
