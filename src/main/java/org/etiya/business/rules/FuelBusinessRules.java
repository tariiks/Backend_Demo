package org.etiya.business.rules;

import org.etiya.dataAccess.abstracts.FuelRepository;

public class FuelBusinessRules {
    FuelRepository fuelRepository;

    public FuelBusinessRules(FuelRepository fuelRepository) {
        this.fuelRepository = fuelRepository;
    }

    public void fuelNameCanNotBeDuplicate(String name){
        fuelRepository.getByName(name).ifPresentOrElse(fuel ->
        {throw new RuntimeException("Fuel name can not be duplicate");},()->{});
    }
}
