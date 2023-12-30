package org.etiya.dataAccess.abstracts;

import org.etiya.entities.Brand;

import java.util.List;
import java.util.Optional;

public interface BrandRepository {
    Brand add(Brand brand);
    List<Brand> getAll();
    Optional<Brand> getByName(String name);
}
