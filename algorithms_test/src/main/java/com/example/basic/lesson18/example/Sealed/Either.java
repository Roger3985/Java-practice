package com.example.basic.lesson18.example.Sealed;

public sealed interface Either<E, R> permits Left, Right {
    default E left() {
        throw new IllegalStateException("nothing left");
    }
    default R right() {
        throw new IllegalStateException("nothing right");
    }
}
