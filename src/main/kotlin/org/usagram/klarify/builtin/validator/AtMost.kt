package org.usagram.klarify.builtin.validator

import org.usagram.klarify.Validity
import org.usagram.klarify.builtin.validator.reason.TooLong
import org.usagram.klarify.validator.Validator

class AtMost(private val n: Int) : Validator<String> {

    override fun invoke(value: String): Validity =
        Validity.invalidIf(TooLong(n)) { value.length > n }

    override fun toString(): String =
        "AtMost($n)"
}
