package org.etiya.dataAccess.concretes;

import org.etiya.dataAccess.abstracts.BrandRepository;
import org.etiya.entities.Brand;
import org.etiya.entities.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BrandRepositoryImpl implements BrandRepository {

    List<Brand> brands = new ArrayList<Brand>();
    @Override
    public Brand add(Brand brand) {
        brand.setId(1); // static number due to non db connection
        brands.add(brand);
        return brand;
    }
    @Override
    public List<Brand> getAll() {
        return brands;
    }

    @Override
    public Optional<Brand> getByName(String name) {
        Optional<Brand> currentBrand = this.brands.stream().filter(brand -> brand.getName().equals(name)).findFirst();
        return currentBrand;
    }
}