package org.usagram.klarify.constraint

import org.usagram.klarify.stage.ValidatorLike

interface Constraint<in T> : (T) -> Test, ValidatorLike<T> {

    override fun toConstraints(): Constraints<T> =
        listOf(this)
}
