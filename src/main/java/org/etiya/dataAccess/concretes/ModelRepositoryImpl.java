package org.etiya.dataAccess.concretes;

import org.etiya.dataAccess.abstracts.ModelRepository;
import org.etiya.entities.Model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ModelRepositoryImpl implements ModelRepository {

    List<Model> models = new ArrayList<Model>();

    @Override
    public Model add(Model model) {
        model.setId(1); // static number due to non db connection
        model.setCreatedDate(LocalDateTime.now()); // static date due to non db connection
        models.add(model);
        return model;
    }

    @Override
    public List<Model> getAll() {
        return models;
    }

    @Override
    public Optional<Model> getByName(String name) {
        Optional<Model> currentModel = models.stream().filter(model -> model.getName().equals(name)).findFirst();
        return currentModel;
    }
}
