package com.dart69.core.observers;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.ToString;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.function.Consumer;

@ToString
public class CachedObservable<T> extends BaseObservable<T> {
    @Getter(AccessLevel.PROTECTED)
    private @Nullable T cachedValue;

    @Override
    public void triggerAll(@NotNull T value) {
        super.triggerAll(value);
        cachedValue = value;
    }

    public void triggerLastValue() {
        ifCached(this::triggerAll);
    }

    public void clearLastValue() {
        cachedValue = null;
    }

    protected final void ifCached(@NotNull Consumer<T> consumer) {
        final var lastValue = getCachedValue();
        if (lastValue != null) {
            consumer.accept(lastValue);
        }
    }
}
