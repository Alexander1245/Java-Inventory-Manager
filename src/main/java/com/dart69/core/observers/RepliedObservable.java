package com.dart69.core.observers;

import lombok.ToString;
import org.jetbrains.annotations.NotNull;

@ToString
public final class RepliedObservable<T> extends CachedObservable<T> {
    @Override
    public boolean addObserver(@NotNull Observer<T> observer) {
        ifCached(observer::onChanged);
        return super.addObserver(observer);
    }
}
