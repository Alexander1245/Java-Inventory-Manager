package com.dart69.items.data.repositories.interfaces;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;
import java.util.List;

public interface Repository<K, V> {
    List<? extends V> getUnmodifiableData();

    @Nullable
    V find(@NotNull K id);

    void addNew(@NotNull V item);

    void removeExisting(@NotNull K id);

    default void removeMany(@NotNull Collection<? extends K> keys) {
        keys.forEach(this::removeExisting);
    }

    default void addMany(@NotNull Collection<? extends V> values) {
        values.forEach(this::addNew);
    }
}
