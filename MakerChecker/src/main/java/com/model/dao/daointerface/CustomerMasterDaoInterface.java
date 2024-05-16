package com.model.dao.daointerface;

import com.model.dto.CustomerDto;

import java.util.List;

public interface CustomerMasterDaoInterface {

    void insert(CustomerDto customerDto);

    void deleteCustomer(CustomerDto customerDto);

    CustomerDto getCustomerById(String customerCode);

    List<CustomerDto> getAllCustomer();

    void updateCustomer(CustomerDto customerDto);

}
