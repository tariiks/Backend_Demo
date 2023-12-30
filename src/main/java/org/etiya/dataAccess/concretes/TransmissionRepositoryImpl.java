package org.etiya.dataAccess.concretes;

import org.etiya.dataAccess.abstracts.TransmissionRepository;
import org.etiya.entities.Transmission;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TransmissionRepositoryImpl implements TransmissionRepository {

    List<Transmission> transmissions = new ArrayList<Transmission>();

    @Override
    public Transmission add(Transmission transmission) {
        transmission.setId(1); // static number due to non db connection
        transmission.setCreatedDate(LocalDateTime.now()); // static date due to non db connection
        transmissions.add(transmission);
        return transmission;
    }

    @Override
    public List<Transmission> getAll() {
        return transmissions;
    }

    @Override
    public Optional<Transmission> getByName(String name) {
        Optional<Transmission> currentTransmission = transmissions.stream().filter(transmission -> transmission.equals(name)).findFirst();
        return currentTransmission;
    }
}
