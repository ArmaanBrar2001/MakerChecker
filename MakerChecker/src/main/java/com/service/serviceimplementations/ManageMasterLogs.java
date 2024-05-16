package com.service.serviceimplementations;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Service;

@Aspect
@Service
public class ManageMasterLogs {

    Logger logger = LogManager.getLogger(ManageMasterLogs.class);

    @After("execution(* com.service.serviceinterfaces.CustomerMasterServiceInterface.callInsertMasterDao" +
            "(..))")
    public void insertNewCustomer(JoinPoint joinPoint){
        logger.info("Customer Inserted in Master");
    }

    @After("execution(* com.service.serviceinterfaces.CustomerMasterServiceInterface" +
            ".callUpdateCustomerMasterDao(..))")
    public void updateCustomer(JoinPoint joinPoint){
        logger.info("Customer Updated in Master");
    }

    @After("execution(* com.service.serviceinterfaces.CustomerMasterServiceInterface.callDeleteMasterDao" +
            "(..))")
    public void deleteCustomer(JoinPoint joinPoint){
        logger.info("Customer Deleted From Master");
    }

    @AfterReturning("execution(* com.service.serviceinterfaces.CustomerMasterServiceInterface" +
            ".callGetByIdMasterDao(..))")
    public void getCustomerById(JoinPoint joinPoint) {
        logger.info("Customer Found");
    }

    @AfterReturning("execution(* com.service.serviceinterfaces.CustomerMasterServiceInterface" +
            ".callGetAllCustomersMasterDao(..))")
    public void getAllCustomers(JoinPoint joinPoint) {
        logger.info("All Customers Found");
    }

}
