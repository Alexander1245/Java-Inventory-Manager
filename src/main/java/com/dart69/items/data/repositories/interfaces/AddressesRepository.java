package com.dart69.items.data.repositories.interfaces;

import com.dart69.items.data.models.Address;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public interface AddressesRepository extends Repository<Integer, Address> {
    @NotNull
    List<Address> filterBy(@NotNull String query);
}
