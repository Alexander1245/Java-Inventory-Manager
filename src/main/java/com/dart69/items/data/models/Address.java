package com.dart69.items.data.models;

import com.dart69.core.utils.StringUtils;
import com.dart69.items.data.models.interfaces.Identifiable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Value;
import lombok.With;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.stream.Collectors;

@Value
@With
@Builder
@Entity
public class Address implements Identifiable<Integer> {
    private final static String DELIMITER = ", ";

    @Id
    @GeneratedValue
    @NotNull
    Integer id;
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

    @NotNull
    public String getFullAddress() {
        final var safeFlat = (flat == null) ? "" : flat;
        final var fields = List.of(country, region, locality, street, house, safeFlat);

        return fields.stream().map(StringUtils::capitalized).collect(Collectors.joining(DELIMITER));
    }
}
