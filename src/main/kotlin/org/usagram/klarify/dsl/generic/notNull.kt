package org.usagram.klarify.dsl.generic

import org.usagram.klarify.builtin.converter.NotNull
import org.usagram.klarify.converter.Converter
import org.usagram.klarify.dsl.Dsl

val <T> Dsl<T?>.notNull: Converter<T?, T>
    get() = NotNull()
