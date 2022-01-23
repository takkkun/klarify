package org.usagram.klarify.dsl

import org.usagram.klarify.stage.Stage

class Dsl<T> {

    infix fun <I, O, R> Stage<I, O>.then(build: Dsl<O>.() -> Stage<O, R>): Stage<I, R> =
        this then Dsl<O>().build()
}
