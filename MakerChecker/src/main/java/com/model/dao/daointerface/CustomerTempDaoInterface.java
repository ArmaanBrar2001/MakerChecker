package com.model.dao.daointerface;

import com.model.dto.CustomerDto;

import java.util.List;

public interface CustomerTempDaoInterface {
    void createCustomer(CustomerDto customerDto);

    void updateCustomer(CustomerDto customerDto);

    void deleteCustomer(CustomerDto customerDto);

    CustomerDto getById(String customerCode);

    List<CustomerDto> getAllCustomer();
}
