package org.etiya.business.concretes;

import org.etiya.business.abstracts.BrandService;
import org.etiya.business.dtos.requests.CreateBrandRequest;
import org.etiya.business.dtos.responses.CreatedBrandResponse;
import org.etiya.business.dtos.responses.GetAllBrandResponse;
import org.etiya.business.rules.BrandBusinessRules;
import org.etiya.core.utilities.abstracts.ModelMapperService;
import org.etiya.dataAccess.abstracts.BrandRepository;
import org.etiya.entities.Brand;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class BrandServiceImpl implements BrandService {

    BrandRepository brandRepository;
    ModelMapperService modelMapperService;

    BrandBusinessRules brandBusinessRules;

    public BrandServiceImpl(BrandRepository brandRepository, ModelMapperService modelMapperService,
                            BrandBusinessRules brandBusinessRules) {
        this.brandRepository = brandRepository;
        this.modelMapperService = modelMapperService;
        this.brandBusinessRules = brandBusinessRules;
    }

    @Override
    public CreatedBrandResponse add(CreateBrandRequest createBrandRequest) {
        Brand brand = modelMapperService.forRequest().map(createBrandRequest,Brand.class);
        Brand createdBrand = brandRepository.add(brand);
        CreatedBrandResponse createdBrandResponse = modelMapperService.forResponse().map(createdBrand,CreatedBrandResponse.class);
        return createdBrandResponse;
    }

    @Override
    public List<GetAllBrandResponse> getAll() {
        var result = brandRepository.getAll();
        List<GetAllBrandResponse> responses =
                result.stream().map(brand -> modelMapperService.forResponse().map(brand,GetAllBrandResponse.class)).collect(Collectors.toList());
        return responses;
    }

    /*.
    // CreatedBrandResponse other type
    // Entry data each all
    @Override
    public CreatedBrandResponse add(CreateBrandRequest createBrandRequest) {
        Brand brand = new Brand();
        brand.setName(createBrandRequest.getName());
        brand.setId((int)Math.random());
        brand.setCreatedDate(LocalDateTime.now());
        Brand createdBrand = brandRepository.add(brand);
        CreatedBrandResponse createdBrandResponse = new CreatedBrandResponse();
        createdBrandResponse.setName(createdBrand.getName());
        createdBrandResponse.setId(createdBrand.getId());
        createdBrandResponse.setCreatedDate(createdBrand.getCreatedDate());
        return createdBrandResponse;
    }
    .*/

}
