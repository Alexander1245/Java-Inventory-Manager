package com.dart69.items.data.models;

import com.dart69.items.data.models.interfaces.Building;
import lombok.Builder;
import lombok.Value;
import lombok.With;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;

@Value
@With
@Builder
public class Warehouse implements Building {
    Integer id;
    @NotNull
    String name;
    @Nullable
    String details;
    double square;
    @NotNull
    Address address;
    @NotNull
    Collection<Product> products;
}
