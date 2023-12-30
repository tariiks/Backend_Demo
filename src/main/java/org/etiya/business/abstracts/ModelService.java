package org.etiya.business.abstracts;

import org.etiya.business.dtos.requests.CreateModelRequest;
import org.etiya.business.dtos.responses.CreatedModelResponse;
import org.etiya.business.dtos.responses.GetAllModelResponse;

import java.util.List;

public interface ModelService {
    CreatedModelResponse add(CreateModelRequest createModelRequest);
    List<GetAllModelResponse> getAll();
}
