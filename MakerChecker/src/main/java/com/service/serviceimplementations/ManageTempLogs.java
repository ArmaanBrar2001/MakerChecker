package com.service.serviceimplementations;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Service;

@Aspect
@Service
public class ManageTempLogs {

    private static final Logger logger = LogManager.getLogger(ManageTempLogs.class);

    @After("execution(* com.service.serviceinterfaces.CustomerTempServiceInterface.callInsertTempDao" +
            "(..))")
    public void insertNewCustomer(JoinPoint joinPoint){
        logger.info("Customer Inserted in Temp");
    }

    @After("execution(* com.service.serviceinterfaces.CustomerTempServiceInterface.callUpdateTempDao" +
            "(..))")
    public void updateCustomer(JoinPoint joinPoint){
        logger.info("Customer Updated in Temp");
    }

    @After("execution(* com.service.serviceinterfaces.CustomerTempServiceInterface.callDeleteTempDao" +
            "(..))")
    public void deleteCustomer(JoinPoint joinPoint){
        logger.info("Customer Deleted from Temp");
    }

    @AfterReturning("execution(* com.service.serviceinterfaces.CustomerTempServiceInterface"  +
            ".callGetByIdTempDao(..))")
    public void getCustomerById(JoinPoint joinPoint) {
        logger.info("Customer Found");
    }

    @AfterReturning("execution(* com.service.serviceinterfaces.CustomerTempServiceInterface" +
            ".callGetAllCustomersTempDao(..))")
    public void getAllCustomers(JoinPoint joinPoint){
        logger.info("All Customers Found");
    }

}
