package org.etiya.business.abstracts;

import org.etiya.business.dtos.requests.CreateTransmissionRequest;
import org.etiya.business.dtos.responses.CreatedTransmissionResponse;
import org.etiya.business.dtos.responses.GetAllTransmissionResponse;

import java.util.List;

public interface TransmissionService {
    CreatedTransmissionResponse add(CreateTransmissionRequest createTransmissionRequest);
    List<GetAllTransmissionResponse> getAll();
}
