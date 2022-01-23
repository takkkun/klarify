package org.usagram.klarify.stage

import org.usagram.klarify.constraint.Constraints
import org.usagram.klarify.constraint.Test

class Validator<T> internal constructor(
    private val constraints: Constraints<T>
) : Stage<T, T>, ValidatorLike<T> {

    override fun invoke(value: T): Output<T> =
        when (val test = constraints(value)) {
            Test.Passed -> Output.Completed(value)
            is Test.Violated -> Output.Aborted(test.reasons)
        }

    override fun toConstraints(): Constraints<T> =
        constraints

    override fun toString(): String =
        constraints.toString()
}
