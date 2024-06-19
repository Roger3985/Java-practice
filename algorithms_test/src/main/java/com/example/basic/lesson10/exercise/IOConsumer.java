package com.example.basic.lesson10.exercise;

import java.io.IOException;

public interface IOConsumer<T> {
    void accept(T t) throws IOException;
}
