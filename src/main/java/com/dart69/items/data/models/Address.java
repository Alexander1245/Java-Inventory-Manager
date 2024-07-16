package com.dart69.items.data.models;

import lombok.Builder;
import lombok.Value;
import lombok.With;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Value
@With
@Builder
public class Address {
    int id;
    @NotNull
    String country;
    @NotNull
    String region;
    @NotNull
    String locality;
    @NotNull
    String street;
    @NotNull
    String house;
    @Nullable
    String flat;
}
