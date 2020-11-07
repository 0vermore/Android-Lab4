package com.example.lab3;

import androidx.annotation.NonNull;
import androidx.room.Entity;

import org.jetbrains.annotations.NotNull;

@Entity(tableName = "person_phones", primaryKeys = {"name", "phone"})
public class PersonPhone implements IPerson {
    @NonNull
    private final String name;
    @NonNull
    private final String phone;

    public PersonPhone(@NotNull String name, @NotNull String phone) {
        this.name = name;
        this.phone = phone;
    }

    public @NotNull String getName() {
        return name;
    }

    public @NotNull String getPhone() {
        return phone;
    }

    @Override
    public int getType() {
        return 1;
    }
}