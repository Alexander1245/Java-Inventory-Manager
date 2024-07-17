package com.dart69.items.data.models;

import com.dart69.items.data.models.interfaces.Item;
import lombok.Builder;
import lombok.Value;
import lombok.With;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Value
@With
@Builder
public class Product implements Item {
    @NotNull
      Integer id;
    @NotNull
    String name;
    @Nullable
    String details;
}
