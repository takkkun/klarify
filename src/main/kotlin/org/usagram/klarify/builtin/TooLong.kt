package org.usagram.klarify.builtin

import org.usagram.klarify.Reason

class TooLong(private val n: Int) : Reason {

    override fun toString(): String =
        "TooLong($n)"
}
