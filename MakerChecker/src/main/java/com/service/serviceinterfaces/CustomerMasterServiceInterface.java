package com.service.serviceinterfaces;

import com.model.dto.CustomerDto;
import com.model.entity.Master_Customer_16892;
import org.springframework.stereotype.Component;

import java.util.List;

public interface CustomerMasterServiceInterface {

    public void callInsertMasterDao(CustomerDto customerDto);

    public void callUpdateCustomerMasterDao(CustomerDto customerDto);

    public void callDeleteMasterDao(CustomerDto customerDto);

    public CustomerDto callGetByIdMasterDao(String customerCode);

    public List<CustomerDto> callGetAllCustomersMasterDao();

}
