package org.etiya.business.concretes;

import org.etiya.business.abstracts.FuelService;
import org.etiya.business.dtos.requests.CreateFuelRequest;
import org.etiya.business.dtos.responses.CreatedFuelResponse;
import org.etiya.business.dtos.responses.GetAllFuelResponse;
import org.etiya.business.rules.FuelBusinessRules;
import org.etiya.core.utilities.abstracts.ModelMapperService;
import org.etiya.dataAccess.abstracts.FuelRepository;
import org.etiya.entities.Fuel;

import java.util.List;
import java.util.stream.Collectors;

public class FuelServiceImpl implements FuelService {
    FuelRepository fuelRepository;
    ModelMapperService modelMapperService;
    FuelBusinessRules fuelBusinessRules;

    public FuelServiceImpl(FuelRepository fuelRepository, ModelMapperService modelMapperService,
                           FuelBusinessRules fuelBusinessRules) {
        this.fuelRepository = fuelRepository;
        this.modelMapperService = modelMapperService;
        this.fuelBusinessRules = fuelBusinessRules;
    }

    @Override
    public CreatedFuelResponse add(CreateFuelRequest createFuelRequest) {
        fuelBusinessRules.fuelNameCanNotBeDuplicate(createFuelRequest.getName());
        Fuel fuel = modelMapperService.forRequest().map(createFuelRequest,Fuel.class);
        Fuel createdFuel = fuelRepository.add(fuel);
        CreatedFuelResponse createdFuelResponse = modelMapperService.forResponse().map(createdFuel,CreatedFuelResponse.class);
        return createdFuelResponse;
    }

    @Override
    public List<GetAllFuelResponse> getAll() {
        var result = fuelRepository.getAll();
        List<GetAllFuelResponse> responses =
                result.stream().map(fuel -> modelMapperService.forResponse().map(fuel, GetAllFuelResponse.class)).collect(Collectors.toList());
        return responses;
    }
}
