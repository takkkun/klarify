package org.usagram.klarify.validator

import org.usagram.klarify.Validity

internal class CompositeValidator<I>(
    private val validators: List<Validator<I>>
) : Validator<I> {

    override fun invoke(value: I): Validity =
        validators.fold(Validity.valid()) { validity, validator -> validity + validator(value) }

    override fun toString(): String =
        when (validators.size) {
            0 -> "[]"
            1 -> validators.single().toString()
            else -> validators.joinToString(", ", "[", "]")
        }

    companion object {

        operator fun <I> invoke(vararg validators: Validator<I>): CompositeValidator<I> =
            CompositeValidator(validators.flatMap { it.asList() })

        private fun <I> Validator<I>.asList(): List<Validator<I>> =
            when (this) {
                is CompositeValidator -> validators
                else -> listOf(this)
            }
    }
}
