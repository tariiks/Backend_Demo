package org.etiya;

import org.etiya.business.concretes.BrandServiceImpl;
import org.etiya.business.dtos.requests.CreateBrandRequest;
import org.etiya.business.dtos.responses.CreatedBrandResponse;
import org.etiya.business.dtos.responses.GetAllBrandResponse;
import org.etiya.business.rules.BrandBusinessRules;
import org.etiya.core.utilities.concretes.ModelMapperManager;
import org.etiya.dataAccess.concretes.BrandRepositoryImpl;
import org.modelmapper.ModelMapper;

import java.util.List;

public class Main {
    public static void main(String[] args) {


        CreateBrandRequest request = new CreateBrandRequest();
        request.setName("Audi");
        BrandServiceImpl brandService =
                new BrandServiceImpl
                        (new BrandRepositoryImpl(),
                                new ModelMapperManager(new ModelMapper()),
                                new BrandBusinessRules(new BrandRepositoryImpl()));
        CreatedBrandResponse response = brandService.add(request);
        System.out.println(response.getName());
        System.out.println("--------------------------------------");

        List<GetAllBrandResponse> lists = brandService.getAll();
        for (var list:lists){
            System.out.println(list.getId() + " " + list.getName() + " " + list.getCreatedDate());
        }
    }
}
