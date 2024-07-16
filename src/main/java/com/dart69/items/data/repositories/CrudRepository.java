package com.dart69.items.data.repositories;

import com.dart69.core.observers.BaseObservable;
import com.dart69.core.observers.Observable;
import com.dart69.core.observers.RepliedObservable;
import com.dart69.core.utils.CollectionUtils;
import com.dart69.items.data.models.interfaces.Identifiable;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class CrudRepository<K, V extends Identifiable<K>> implements Observable<V> {
    private final Map<K, V> data;
    private final BaseObservable<V> observable;

    private CrudRepository(Map<K, V> initial, BaseObservable<V> observable) {
        this.data = initial;
        this.observable = observable;
    }

    protected CrudRepository(List<V> initial, BaseObservable<V> observable) {
        this(CollectionUtils.groupBy(initial, V::getId), observable);
    }

    protected CrudRepository() {
        this(new HashMap<>(), new RepliedObservable<>());
    }

    public List<? extends V> getUnmodifiableData() {
        return List.copyOf(data.values());
    }

    public V find(K id) throws NoValueFindException {
        return CollectionUtils.findFirst(data.values(), (value) -> value.getId().equals(id));
    }

    public void addNew(V item) {
        data.put(item.getId(), item);
        observable.triggerAll(item);
    }

    public void removeExisting(K id) {
        try {
            observable.triggerAll(find(id));
        } catch (NoValueFindException ignored) {
        }
    }
}
