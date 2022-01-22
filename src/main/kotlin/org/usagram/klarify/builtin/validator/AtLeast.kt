package org.usagram.klarify.builtin.validator

import org.usagram.klarify.Validity
import org.usagram.klarify.builtin.validator.reason.TooShort
import org.usagram.klarify.validator.Validator

class AtLeast(private val n: Int) : Validator<String> {

    override fun invoke(value: String): Validity =
        Validity.invalidIf(TooShort(n)) { value.length < n }

    override fun toString(): String =
        "AtLeast($n)"
}
