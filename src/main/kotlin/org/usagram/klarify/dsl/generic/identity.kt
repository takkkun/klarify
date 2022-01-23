package org.usagram.klarify.dsl.generic

import org.usagram.klarify.builtin.converter.Identity
import org.usagram.klarify.converter.Converter
import org.usagram.klarify.dsl.Dsl

val <T> Dsl<T>.identity: Converter<T, T>
    get() = Identity()
