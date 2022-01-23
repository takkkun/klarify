package org.usagram.klarify.stage

import org.usagram.klarify.constraint.Constraints

interface ValidatorLike<in T> {

    fun toConstraints(): Constraints<T>

    fun <U : T> asValidator(): Validator<U> =
        Validator(toConstraints())

    operator fun <U : T> plus(other: ValidatorLike<U>): Validator<U> =
        Validator(toConstraints() + other.toConstraints())
}
