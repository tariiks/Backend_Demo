package org.etiya.business.abstracts;

import org.etiya.business.dtos.requests.CreateBrandRequest;
import org.etiya.business.dtos.responses.CreatedBrandResponse;
import org.etiya.business.dtos.responses.GetAllBrandResponse;

import java.util.List;

public interface BrandService {
    CreatedBrandResponse add(CreateBrandRequest createBrandRequest);
    List<GetAllBrandResponse> getAll();
}
