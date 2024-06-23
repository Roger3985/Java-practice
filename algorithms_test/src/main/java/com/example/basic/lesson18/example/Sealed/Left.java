package com.example.basic.lesson18.example.Sealed;

public record Left<E, R>(E value) implements Either<E, R> {
    @Override
    public E left() {
        return value;
    }
}
