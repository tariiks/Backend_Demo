package org.etiya.business.rules;

import org.etiya.dataAccess.abstracts.ModelRepository;

public class ModelBusinessRules {
    ModelRepository modelRepository;

    public ModelBusinessRules(ModelRepository modelRepository) {
        this.modelRepository = modelRepository;
    }

    public void modelNameCanNotBeDuplicate(String name){
        modelRepository.getByName(name).ifPresentOrElse(model ->
        {throw new RuntimeException("Model name can not be duplicate");},() -> {});
    }
}
