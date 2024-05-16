package com.service.serviceimplementations;

import com.model.dao.daointerface.CustomerMasterDaoInterface;
import com.model.dto.CustomerDto;
import com.service.serviceinterfaces.ConverterInterface;
import com.service.serviceinterfaces.CustomerMasterServiceInterface;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("CustomerMasterService")
public class CustomerMasterService implements CustomerMasterServiceInterface {

    Logger logger = (Logger) LogManager.getLogger(ManageTempLogs.class);

    @Autowired
    CustomerMasterDaoInterface customerMasterDao;

    @Autowired
    ConverterInterface converter;

    @Override
    public void callInsertMasterDao(CustomerDto customerDto){
        customerMasterDao.insert(customerDto);
    }

    @Override
    public void callUpdateCustomerMasterDao(CustomerDto customerDto){
        customerMasterDao.updateCustomer(customerDto);
    }

    @Override
    public void callDeleteMasterDao(CustomerDto customerDto){
        customerMasterDao.deleteCustomer(customerDto);
    }

    @Override
    public CustomerDto callGetByIdMasterDao(String customerCode){
        return customerMasterDao.getCustomerById(customerCode);
    }

    @Override
    public List<CustomerDto> callGetAllCustomersMasterDao(){
        return customerMasterDao.getAllCustomer();
    }

}
