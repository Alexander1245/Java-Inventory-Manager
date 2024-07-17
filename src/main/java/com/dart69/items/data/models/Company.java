package com.dart69.items.data.models;

import com.dart69.items.data.models.interfaces.Building;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Value;
import lombok.With;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;

@Value
@With
@Builder
@Entity
public class Company implements Building {
    @Id
    @GeneratedValue
    @NotNull
    Integer id;
    @NotNull
    String name;
    @Nullable
    String details;
    @NotNull
    Address address;
    @NotNull
    Collection<Warehouse> warehouses;
}
