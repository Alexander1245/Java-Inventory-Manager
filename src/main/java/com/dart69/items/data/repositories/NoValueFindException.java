package com.dart69.items.data.repositories;

import org.jetbrains.annotations.NotNull;

public class NoValueFindException extends Exception{
    public NoValueFindException(@NotNull String message) {
        super(message);
    }
}
