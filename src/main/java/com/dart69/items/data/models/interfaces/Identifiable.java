package com.dart69.items.data.models.interfaces;

import org.jetbrains.annotations.NotNull;

import java.io.Serializable;

public interface Identifiable<T> extends Serializable {
    @NotNull
    T getId();
}
