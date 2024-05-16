package com.service.serviceimplementations;

import com.model.dto.CustomerDto;
import com.model.entity.Master_Customer_16892;
import com.model.entity.Temp_Customer_16892;
import com.service.serviceinterfaces.ConverterInterface;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class Converter implements ConverterInterface {

    @Autowired
    private ModelMapper modelMapper;

    public Temp_Customer_16892 dtoToTemp(CustomerDto customerDto){
        return modelMapper.map(customerDto, Temp_Customer_16892.class);
    }

    public CustomerDto TempToDto(Temp_Customer_16892 tempCustomer16892){
        return modelMapper.map(tempCustomer16892, CustomerDto.class);
    }

    public Master_Customer_16892 dtoToMaster(CustomerDto customerDto){
        return this.modelMapper.map(customerDto, Master_Customer_16892.class);
    }

    public CustomerDto MasterToDto(Master_Customer_16892 customer){
        return this.modelMapper.map(customer, CustomerDto.class);
    }

}
