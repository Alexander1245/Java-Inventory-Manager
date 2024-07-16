package com.dart69.items.data.models.interfaces;

import com.dart69.items.data.models.Address;
import org.jetbrains.annotations.NotNull;

public interface AddressOwner {
    @NotNull
    Address getAddress();
}
