package com.dart69.core.observers;

@FunctionalInterface
public interface Observer<T> {
    void onChanged(T value);
}
