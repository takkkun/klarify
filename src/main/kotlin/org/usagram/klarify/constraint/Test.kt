package org.usagram.klarify.constraint

import org.usagram.klarify.Reason
import org.usagram.klarify.Reasons

sealed interface Test {

    operator fun plus(other: Test): Test

    object Passed : Test {

        override fun plus(other: Test): Test =
            when (other) {
                Passed -> Passed
                is Violated -> other
            }

        override fun toString(): String =
            "Test.Passed"
    }

    class Violated(val reasons: Reasons) : Test {

        override fun plus(other: Test): Test =
            when (other) {
                Passed -> this
                is Violated -> Violated(reasons + other.reasons)
            }

        override fun toString(): String =
            "Test.Violated(${reasons.joinToString(", ")})"
    }

    companion object {

        internal fun passed(): Test =
            Passed

        internal fun violated(vararg reasons: Reason): Test =
            Violated(reasons.toList())

        internal fun violatedIf(vararg reasons: Reason, test: () -> Boolean): Test =
            if (test()) violated(*reasons) else passed()
    }
}
