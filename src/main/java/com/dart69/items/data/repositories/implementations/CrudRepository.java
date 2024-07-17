package com.dart69.items.data.repositories.implementations;

import com.dart69.core.observers.BaseObservable;
import com.dart69.core.observers.Observable;
import com.dart69.core.observers.Observer;
import com.dart69.core.observers.RepliedObservable;
import com.dart69.core.utils.CollectionUtils;
import com.dart69.items.data.models.interfaces.Identifiable;
import com.dart69.items.data.repositories.interfaces.Repository;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.*;
import java.util.stream.Collectors;

public abstract class CrudRepository<K, V extends Identifiable<K>> implements Observable<List<V>>, Repository<K, V> {
    private final Map<K, V> data;
    private final BaseObservable<List<V>> observable;

    private CrudRepository(Map<K, V> initial, BaseObservable<List<V>> observable) {
        this.data = initial;
        this.observable = observable;
    }

    protected CrudRepository(List<V> initial, BaseObservable<List<V>> observable) {
        this(CollectionUtils.groupBy(initial, V::getId), observable);
    }

    protected CrudRepository() {
        this(new HashMap<>(), new RepliedObservable<>());
    }

    @Override
    public @NotNull List<V> getUnmodifiableData() {
        return List.copyOf(data.values());
    }

    @Override
    public @Nullable V find(@NotNull K id) {
        return data.get(id);
    }

    @Override
    public void addNew(@NotNull V item) {
        final var id = item.getId();
        if(find(id) != null) {
            throw new IllegalArgumentException("There is a value associated with an actual id: " + id);
        }
        data.put(item.getId(), item);
        observable.triggerAll(getUnmodifiableData());
    }

    @Override
    public void removeExisting(@NotNull K id) {
        data.remove(id);
        observable.triggerAll(getUnmodifiableData());
    }

    @Override
    public boolean addObserver(@NotNull Observer<List<V>> observer) {
        return observable.addObserver(observer);
    }

    @Override
    public boolean removeObserver(@NotNull Observer<List<V>> observer) {
        return observable.removeObserver(observer);
    }
}
