package com.dart69.items.data.models.interfaces;

import org.jetbrains.annotations.NotNull;

public interface Identifiable<T> {
    @NotNull
    T getId();
}
