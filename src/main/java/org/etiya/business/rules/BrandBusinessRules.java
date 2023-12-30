package org.etiya.business.rules;

import org.etiya.dataAccess.abstracts.BrandRepository;

public class BrandBusinessRules {
    BrandRepository brandRepository;

    public BrandBusinessRules(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    public void brandNameCanNotBeDuplicate(String name){
        brandRepository.getByName(name).ifPresentOrElse(brand ->
        {throw new RuntimeException("Brand name can not be duplicate");},()->{});
    }
}
