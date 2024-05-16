package com.service.serviceinterfaces;

import com.model.dto.CustomerDto;
import com.model.entity.Master_Customer_16892;
import com.model.entity.Temp_Customer_16892;

public interface ConverterInterface {

    public Temp_Customer_16892 dtoToTemp(CustomerDto customerDto);

    public CustomerDto TempToDto(Temp_Customer_16892 tempCustomer16892);

    public Master_Customer_16892 dtoToMaster(CustomerDto customerDto);

    public CustomerDto MasterToDto(Master_Customer_16892 customer);

}
