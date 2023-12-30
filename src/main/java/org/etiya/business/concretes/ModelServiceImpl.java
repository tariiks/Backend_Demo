package org.etiya.business.concretes;

import org.etiya.business.abstracts.ModelService;
import org.etiya.business.dtos.requests.CreateModelRequest;
import org.etiya.business.dtos.responses.CreatedModelResponse;
import org.etiya.business.dtos.responses.GetAllModelResponse;
import org.etiya.business.rules.ModelBusinessRules;
import org.etiya.core.utilities.abstracts.ModelMapperService;
import org.etiya.dataAccess.abstracts.ModelRepository;
import org.etiya.entities.Model;

import java.util.List;
import java.util.stream.Collectors;

public class ModelServiceImpl implements ModelService {

    ModelRepository modelRepository;
    ModelMapperService modelMapperService;
    ModelBusinessRules modelBusinessRules;

    public ModelServiceImpl(ModelRepository modelRepository, ModelMapperService modelMapperService,
                            ModelBusinessRules modelBusinessRules) {
        this.modelRepository = modelRepository;
        this.modelMapperService = modelMapperService;
        this.modelBusinessRules = modelBusinessRules;
    }

    @Override
    public CreatedModelResponse add(CreateModelRequest createModelRequest) {
        modelBusinessRules.modelNameCanNotBeDuplicate(createModelRequest.getName());
        Model model = modelMapperService.forRequest().map(createModelRequest,Model.class);
        Model createdModel = modelRepository.add(model);
        CreatedModelResponse createdModelResponse = modelMapperService.forResponse().map(createdModel,CreatedModelResponse.class);
        return createdModelResponse;
    }

    @Override
    public List<GetAllModelResponse> getAll() {
        var result = modelRepository.getAll();
        List<GetAllModelResponse> responses =
                result.stream().map(model -> modelMapperService.forResponse().map(model,GetAllModelResponse.class)).collect(Collectors.toList());
        return responses;
    }
}
