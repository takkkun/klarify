package org.usagram.klarify

interface Constraint<in T> : (T) -> Test, ValidatorLike<T> {

    override fun toConstraints(): Constraints<T> =
        Constraints(this)
}
