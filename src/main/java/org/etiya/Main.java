package org.etiya;

import org.etiya.business.concretes.BrandServiceImpl;
import org.etiya.business.concretes.FuelServiceImpl;
import org.etiya.business.concretes.ModelServiceImpl;
import org.etiya.business.concretes.TransmissionServiceImpl;
import org.etiya.business.dtos.requests.CreateBrandRequest;
import org.etiya.business.dtos.requests.CreateFuelRequest;
import org.etiya.business.dtos.requests.CreateModelRequest;
import org.etiya.business.dtos.requests.CreateTransmissionRequest;
import org.etiya.business.dtos.responses.*;
import org.etiya.business.rules.BrandBusinessRules;
import org.etiya.business.rules.FuelBusinessRules;
import org.etiya.business.rules.ModelBusinessRules;
import org.etiya.business.rules.TransmissionBusinessRules;
import org.etiya.core.utilities.concretes.ModelMapperServiceImpl;
import org.etiya.dataAccess.concretes.BrandRepositoryImpl;
import org.etiya.dataAccess.concretes.FuelRepositoryImpl;
import org.etiya.dataAccess.concretes.ModelRepositoryImpl;
import org.etiya.dataAccess.concretes.TransmissionRepositoryImpl;
import org.modelmapper.ModelMapper;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        System.out.println("--------------------------------------");

        CreateBrandRequest brandRequest = new CreateBrandRequest();
        brandRequest.setName("Audi");
        BrandServiceImpl brandService = new BrandServiceImpl (
                new BrandRepositoryImpl(),
                new ModelMapperServiceImpl(new ModelMapper()),
                new BrandBusinessRules(new BrandRepositoryImpl()));
        CreatedBrandResponse brandResponse = brandService.add(brandRequest);
        System.out.println(brandResponse.getName());
        System.out.println("--------------------------------------");

        List<GetAllBrandResponse> brandResponseList = brandService.getAll();
        for (var list:brandResponseList){
            System.out.println(list.getId() + " " + list.getName() + " " + list.getCreatedDate());
        }
        System.out.println("--------------------------------------");

        CreateFuelRequest fuelRequest = new CreateFuelRequest();
        fuelRequest.setName("Diesel");
        FuelServiceImpl fuelService = new FuelServiceImpl(
                new FuelRepositoryImpl(),
                new ModelMapperServiceImpl(new ModelMapper()),
                new FuelBusinessRules(new FuelRepositoryImpl()));
        CreatedFuelResponse fuelResponse = fuelService.add(fuelRequest);
        System.out.println(fuelResponse.getName());
        System.out.println("--------------------------------------");

        List<GetAllFuelResponse> fuelResponseList = fuelService.getAll();
        for (var list:fuelResponseList){
            System.out.println(list.getId() + " " + list.getName() + " " + list.getCreatedDate());
        }
        System.out.println("--------------------------------------");

        CreateModelRequest modelRequest = new CreateModelRequest();
        modelRequest.setName("A5 SportBack");
        ModelServiceImpl modelService = new ModelServiceImpl(
                new ModelRepositoryImpl(),
                new ModelMapperServiceImpl(new ModelMapper()),
                new ModelBusinessRules(new ModelRepositoryImpl()));
        CreatedModelResponse modelResponse = modelService.add(modelRequest);
        System.out.println(modelResponse.getName());
        System.out.println("--------------------------------------");

        List<GetAllModelResponse> modelResponseList = modelService.getAll();
        for (var list:modelResponseList){
            System.out.println(list.getId() + " " + list.getName() + " " + list.getCreatedDate());
        }
        System.out.println("--------------------------------------");

        CreateTransmissionRequest transmissionRequest = new CreateTransmissionRequest();
        transmissionRequest.setName("Manual Transmission");
        TransmissionServiceImpl transmissionService = new TransmissionServiceImpl(
                new TransmissionRepositoryImpl(),
                new ModelMapperServiceImpl(new ModelMapper()),
                new TransmissionBusinessRules(new TransmissionRepositoryImpl()));
        CreatedTransmissionResponse transmissionResponse = transmissionService.add(transmissionRequest);
        System.out.println(transmissionResponse.getName());
        System.out.println("--------------------------------------");

        List<GetAllTransmissionResponse> transmissionResponseList = transmissionService.getAll();
        for (var list:transmissionResponseList){
            System.out.println(list.getId() + " " + list.getName() + " " + list.getCreatedDate());
        }
        System.out.println("--------------------------------------");
    }
}
