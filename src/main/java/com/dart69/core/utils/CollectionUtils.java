package com.dart69.core.utils;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;

public final class CollectionUtils {
    private CollectionUtils() {
    }

    public static <K, V> Map<K, V> groupBy(Iterable<? extends V> iterable, Function<? super V, ? extends K> keyProvider) {
        final var result = new HashMap<K, V>();
        iterable.forEach((value) -> result.put(keyProvider.apply(value), value));
        return result;
    }

    public static <V> V findFirst(Collection<? extends V> collection, Predicate<? super V> predicate) {
        return collection.stream().filter(predicate).findFirst().orElseThrow();
    }
}
