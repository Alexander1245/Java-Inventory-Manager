package com.dart69.items.data.models;

import com.dart69.items.data.models.interfaces.Item;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Value;
import lombok.With;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Value
@With
@Builder
@Entity
public class Product implements Item {
    @Id
    @GeneratedValue
    @NotNull
    Integer id;
    @NotNull
    String name;
    @Nullable
    String details;
}
