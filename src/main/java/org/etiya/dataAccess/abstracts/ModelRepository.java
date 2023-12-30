package org.etiya.dataAccess.abstracts;

import org.etiya.entities.Model;

import java.util.List;
import java.util.Optional;

public interface ModelRepository {
    Model add(Model model);
    List<Model> getAll();
    Optional<Model> getByName(String name);
}
