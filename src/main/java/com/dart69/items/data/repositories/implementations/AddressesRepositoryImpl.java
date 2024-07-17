package com.dart69.items.data.repositories.implementations;

import com.dart69.items.data.models.Address;
import com.dart69.items.data.repositories.interfaces.AddressesRepository;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.stream.Collectors;

public final class AddressesRepositoryImpl extends CrudRepository<Integer, Address> implements AddressesRepository {
    @Override
    public @NotNull List<Address> filterBy(@NotNull String query) {
        return getUnmodifiableData().stream()
                .filter((address) -> address.getFullAddress().equalsIgnoreCase(query))
                .collect(Collectors.toList());
    }
}
