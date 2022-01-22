package org.usagram.klarify.builtin.validator.reason

import org.usagram.klarify.Reason

class TooShort(private val n: Int) : Reason {

    override fun toString(): String =
        "TooShort($n)"
}
