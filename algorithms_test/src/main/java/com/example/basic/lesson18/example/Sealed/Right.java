package com.example.basic.lesson18.example.Sealed;

public record Right<E, R>(R value) implements Either<E, R> {
    @Override
    public R right() {
        return value;
    }
}
