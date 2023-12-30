package org.etiya.business.abstracts;

import org.etiya.business.dtos.requests.CreateFuelRequest;
import org.etiya.business.dtos.responses.CreatedFuelResponse;
import org.etiya.business.dtos.responses.GetAllFuelResponse;

import java.util.List;

public interface FuelService {
    CreatedFuelResponse add(CreateFuelRequest createFuelRequest);
    List<GetAllFuelResponse> getAll();
}
