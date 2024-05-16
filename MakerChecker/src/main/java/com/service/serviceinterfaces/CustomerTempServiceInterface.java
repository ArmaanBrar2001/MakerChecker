package com.service.serviceinterfaces;

import com.model.dto.CustomerDto;
import org.hibernate.Session;
import org.springframework.stereotype.Component;

import java.util.List;

public interface CustomerTempServiceInterface {

    void callInsertTempDao(CustomerDto customerDto);

    public void callUpdateTempDao(CustomerDto customerDto);


    void callDeleteTempDao(CustomerDto customerDto);

    CustomerDto callGetByIdTempDao(String customerCode);

    List<CustomerDto> callGetAllCustomersTempDao();
}
