package org.etiya.dataAccess.abstracts;

import org.etiya.entities.Transmission;

import java.util.List;
import java.util.Optional;

public interface TransmissionRepository {
    Transmission add(Transmission transmission);
    List<Transmission> getAll();
    Optional<Transmission> getByName(String name);
}
