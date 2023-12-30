package org.etiya.dataAccess.concretes;

import org.etiya.dataAccess.abstracts.FuelRepository;
import org.etiya.entities.Fuel;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FuelRepositoryImpl implements FuelRepository {

    List<Fuel> fuels = new ArrayList<Fuel>();
    @Override
    public Fuel add(Fuel fuel) {
        fuel.setId(1); // static number due to non db connection
        fuel.setCreatedDate(LocalDateTime.now()); // static date due to non db connection
        fuels.add(fuel);
        return fuel;
    }

    @Override
    public List<Fuel> getAll() {
        return fuels;
    }

    @Override
    public Optional<Fuel> getByName(String name) {
        Optional<Fuel> currentFuel = fuels.stream().filter(fuel -> fuel.getName().equals(name)).findFirst();
        return currentFuel;
    }
}
