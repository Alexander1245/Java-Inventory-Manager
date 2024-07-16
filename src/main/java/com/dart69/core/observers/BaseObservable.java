package com.dart69.core.observers;

import lombok.ToString;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

@ToString
public abstract class BaseObservable<T> implements Observable<T> {
    private final @NotNull List<Observer<T>> observers;

    protected BaseObservable(@NotNull List<Observer<T>> observers) {
        this.observers = observers;
    }

    protected BaseObservable() {
        this(new ArrayList<>());
    }

    public void triggerAll(@NotNull T value) {
        observers.forEach((observer) -> observer.onChanged(value));
    }

    @Override
    public boolean addObserver(@NotNull Observer<T> observer) {
        return observers.add(observer);
    }

    @Override
    public boolean removeObserver(@NotNull Observer<T> observer) {
        return observers.remove(observer);
    }

    public void clear() {
        observers.clear();
    }
}
