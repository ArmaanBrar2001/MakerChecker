package com.service.serviceimplementations;

import com.model.dao.daointerface.CustomerTempDaoInterface;
import com.model.dto.CustomerDto;
import com.service.serviceinterfaces.ConverterInterface;
import com.service.serviceinterfaces.CustomerTempServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("CustomerTempService")
public class CustomerTempService implements CustomerTempServiceInterface {

    @Autowired
    CustomerTempDaoInterface customerTempDao;

    @Override
    public void callInsertTempDao(CustomerDto customerDto){
        customerTempDao.createCustomer(customerDto);
    }

    @Override
    public void callUpdateTempDao(CustomerDto customerDto){
        customerTempDao.updateCustomer(customerDto);
    }

    @Override
    public void callDeleteTempDao(CustomerDto customerDto){
        customerTempDao.deleteCustomer(customerDto);
    }

    @Override
    public CustomerDto callGetByIdTempDao(String customerCode){
        return customerTempDao.getById(customerCode);
    }

    @Override
    public List<CustomerDto> callGetAllCustomersTempDao(){
        return customerTempDao.getAllCustomer();
    }

}
