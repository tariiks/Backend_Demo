package org.etiya.business.concretes;

import org.etiya.business.abstracts.TransmissionService;
import org.etiya.business.dtos.requests.CreateTransmissionRequest;
import org.etiya.business.dtos.responses.CreatedTransmissionResponse;
import org.etiya.business.dtos.responses.GetAllTransmissionResponse;
import org.etiya.business.rules.TransmissionBusinessRules;
import org.etiya.core.utilities.abstracts.ModelMapperService;
import org.etiya.dataAccess.abstracts.TransmissionRepository;
import org.etiya.entities.Transmission;

import java.util.List;
import java.util.stream.Collectors;

public class TransmissionServiceImpl implements TransmissionService {

    TransmissionRepository transmissionRepository;
    ModelMapperService modelMapperService;
    TransmissionBusinessRules transmissionBusinessRules;

    public TransmissionServiceImpl(TransmissionRepository transmissionRepository, ModelMapperService modelMapperService,
                                   TransmissionBusinessRules transmissionBusinessRules) {
        this.transmissionRepository = transmissionRepository;
        this.modelMapperService = modelMapperService;
        this.transmissionBusinessRules = transmissionBusinessRules;
    }

    @Override
    public CreatedTransmissionResponse add(CreateTransmissionRequest createTransmissionRequest) {
        transmissionBusinessRules.transmissionNameCanNotBeDuplicate(createTransmissionRequest.getName());
        Transmission transmission = modelMapperService.forRequest().map(createTransmissionRequest,Transmission.class);
        Transmission createdTransmission = transmissionRepository.add(transmission);
        CreatedTransmissionResponse createdTransmissionResponse = modelMapperService.forResponse().map(createdTransmission,CreatedTransmissionResponse.class);
        return createdTransmissionResponse;
    }

    @Override
    public List<GetAllTransmissionResponse> getAll() {
        var result = transmissionRepository.getAll();
        List<GetAllTransmissionResponse> responses =
                result.stream().map(transmission -> modelMapperService.forResponse().map(transmission,GetAllTransmissionResponse.class)).collect(Collectors.toList());
        return responses;
    }
}
