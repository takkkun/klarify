package org.usagram.klarify.builtin.validator

import org.usagram.klarify.Validity
import org.usagram.klarify.builtin.validator.reason.Empty
import org.usagram.klarify.validator.Validator

object NotEmpty : Validator<String> {

    override fun invoke(value: String): Validity =
        Validity.invalidIf(Empty) { value.isEmpty() }

    override fun toString(): String =
        "NotEmpty"
}
