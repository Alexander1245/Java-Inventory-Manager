package com.dart69.core.observers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class RepliedObservableTest {
    private RepliedObservable<Integer> observable;

    @BeforeEach
    public void beforeEach() {
        observable = new RepliedObservable<>();
    }

    @Test
    public void testNotifiers() {
        final var expected = List.of(1, 2, 3);
        final var expectedLast = expected.get(expected.size() - 1);
        final var first = new ArrayList<Integer>();
        final var second = new ArrayList<Integer>();
        final var cached = new ArrayList<Integer>();

        observable.addObserver(first::add);
        observable.addObserver(second::add);

        expected.forEach(observable::triggerAll);

        observable.addObserver(cached::add);

        Assertions.assertIterableEquals(expected, first);
        Assertions.assertIterableEquals(expected, second);
        Assertions.assertEquals(expectedLast, cached.stream().findFirst().orElse(Integer.MIN_VALUE));
    }

    @Test
    public void testTriggerLastValueWhenNotPresent() {
        final var first = new ArrayList<Integer>();
        final var second = new ArrayList<Integer>();

        observable.addObserver(first::add);
        observable.addObserver(second::add);

        observable.triggerLastValue();

        Assertions.assertTrue(first.isEmpty() && second.isEmpty());
    }

    @Test
    public void testTriggerLastValue() {
        final var expected = List.of(3, 3);
        final var first = new ArrayList<Integer>();
        final var second = new ArrayList<Integer>();

        expected.forEach(observable::triggerAll);

        observable.addObserver(first::add);
        observable.addObserver(second::add);

        observable.triggerLastValue();

        Assertions.assertIterableEquals(expected, first);
        Assertions.assertIterableEquals(expected, second);
    }

    @Test
    public void testRemoveObserver() {
        final var expected = List.of(1, 2);

        final var lastIndex = expected.size() - 1;
        final var firstItemList = expected.subList(0, lastIndex);

        final var first = new ArrayList<Integer>();
        final var second = new ArrayList<Integer>();

        final Observer<Integer> secondObserver = second::add;

        observable.triggerAll(expected.stream().findFirst().orElseThrow());

        observable.addObserver(first::add);
        observable.addObserver(secondObserver);

        Assertions.assertTrue(observable.removeObserver(secondObserver));

        observable.triggerAll(expected.get(lastIndex));

        Assertions.assertIterableEquals(expected, first);
        Assertions.assertIterableEquals(firstItemList, second);
    }

    @Test
    public void testClear() {
        final var expected = List.of(1, 2);

        final var lastIndex = expected.size() - 1;
        final var firstItemList = expected.subList(0, lastIndex);

        final var first = new ArrayList<Integer>();
        final var second = new ArrayList<Integer>();

        observable.triggerAll(expected.stream().findFirst().orElseThrow());

        observable.addObserver(first::add);
        observable.addObserver(second::add);

        observable.clear();

        observable.triggerAll(expected.get(lastIndex));

        Assertions.assertIterableEquals(firstItemList, first);
        Assertions.assertIterableEquals(firstItemList, second);
    }
}