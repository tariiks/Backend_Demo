package org.etiya.dataAccess.abstracts;

import org.etiya.entities.Fuel;

import java.util.List;
import java.util.Optional;

public interface FuelRepository {
    Fuel add(Fuel fuel);
    List<Fuel> getAll();
    Optional<Fuel> getByName(String name);
}
