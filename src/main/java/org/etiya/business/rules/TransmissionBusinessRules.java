package org.etiya.business.rules;

import org.etiya.dataAccess.abstracts.TransmissionRepository;

public class TransmissionBusinessRules {
    TransmissionRepository transmissionRepository;

    public TransmissionBusinessRules(TransmissionRepository transmissionRepository) {
        this.transmissionRepository = transmissionRepository;
    }

    public void transmissionNameCanNotBeDuplicate(String name){
        transmissionRepository.getByName(name).ifPresentOrElse(transmission ->
        {throw new RuntimeException("Transmission name can not be duplicate");},() -> {});
    }
}
