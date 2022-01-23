package org.usagram.klarify.dsl.generic

import org.usagram.klarify.builtin.Identity
import org.usagram.klarify.dsl.Dsl
import org.usagram.klarify.stage.Converter

val <T> Dsl<T>.identity: Converter<T, T>
    get() = Identity()
