package org.usagram.klarify.dsl.generic

import org.usagram.klarify.builtin.NotNull
import org.usagram.klarify.dsl.Dsl
import org.usagram.klarify.stage.Converter

val <T> Dsl<T?>.notNull: Converter<T?, T>
    get() = NotNull()
