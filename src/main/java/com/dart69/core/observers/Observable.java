package com.dart69.core.observers;

import org.jetbrains.annotations.NotNull;

public interface Observable<T> {
    boolean addObserver(@NotNull Observer<T> observer);

    boolean removeObserver(@NotNull Observer<T> observer);
}
