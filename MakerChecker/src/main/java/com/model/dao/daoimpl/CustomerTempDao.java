package com.model.dao.daoimpl;

import com.model.dao.daointerface.CustomerTempDaoInterface;
import com.model.dto.CustomerDto;
import com.model.entity.Temp_Customer_16892;
import com.service.serviceimplementations.HibernateUtil;
import com.service.serviceinterfaces.ConverterInterface;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository("CustomerTempDao")
public class CustomerTempDao implements CustomerTempDaoInterface {

    @Autowired
    public ConverterInterface converter;

    SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    @Override
    public void createCustomer(CustomerDto customerDto) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Temp_Customer_16892 tempCustomer = converter.dtoToTemp(customerDto);
        session.save(tempCustomer);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void updateCustomer(CustomerDto customerDto) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Temp_Customer_16892 tempCustomer16892 = converter.dtoToTemp(customerDto);

        tempCustomer16892.setCustomerCode(customerDto.getCustomerCode());
        tempCustomer16892.setCustomerName(customerDto.getCustomerName());
        tempCustomer16892.setCustomerAddress1(customerDto.getCustomerAddress1());
        tempCustomer16892.setCustomerAddress2(customerDto.getCustomerAddress2());
        tempCustomer16892.setCustomerPinCode(customerDto.getCustomerPinCode());
        tempCustomer16892.setContactNumber(customerDto.getContactNumber());
        tempCustomer16892.setContactPerson(customerDto.getContactPerson());
        tempCustomer16892.setFlag(customerDto.getFlag());
        tempCustomer16892.setModifiedDate(customerDto.getModifiedDate());
        tempCustomer16892.setModifiedBy(customerDto.getModifiedBy());

        session.update(tempCustomer16892);

        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void deleteCustomer(CustomerDto customerDto) {
        Session session = sessionFactory.openSession();
        Temp_Customer_16892 tempCustomer = converter.dtoToTemp(customerDto);

        session.beginTransaction();
        session.delete(tempCustomer);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public CustomerDto getById(String customerCode) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Temp_Customer_16892 customer = session.get(Temp_Customer_16892.class, customerCode);
        session.close();
//        System.out.println(customer);
        return converter.TempToDto(customer);
    }

    @Override
    public List<CustomerDto> getAllCustomer() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        List<Temp_Customer_16892> allCustomers =
                session.createQuery("FROM Temp_Customer_16892").getResultList();

        List<CustomerDto> customerDtoList = new ArrayList<>();

        for(Temp_Customer_16892 customer : allCustomers){
            CustomerDto customerDto = converter.TempToDto(customer);
            customerDtoList.add(customerDto);
        }

        session.close();
        return customerDtoList;
    }

}
