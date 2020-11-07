package com.example.lab3;

import androidx.annotation.NonNull;
import androidx.room.Entity;

import org.jetbrains.annotations.NotNull;

@Entity(tableName = "person_address", primaryKeys = {"name", "address"})
public class PersonAddress implements IPerson{
    @NonNull
    private final String name;
    @NonNull
    private final String address;

    public PersonAddress(@NotNull String name, @NotNull String address) {
        this.name = name;
        this.address = address;
    }

    public @NotNull String getName() {
        return name;
    }

    public @NotNull String getAddress() {
        return address;
    }

    @Override
    public int getType() {
        return 2;
    }
}