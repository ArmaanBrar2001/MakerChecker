package com.model.dao.daoimpl;

import com.model.dao.daointerface.CustomerMasterDaoInterface;
import com.model.dto.CustomerDto;
import com.model.entity.Master_Customer_16892;
import com.service.serviceimplementations.HibernateUtil;
import com.service.serviceinterfaces.ConverterInterface;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository("CustomerMasterDao")
public class CustomerMasterDao implements CustomerMasterDaoInterface {

    @Autowired
    public ConverterInterface converter;

    SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    @Override
    public void insert(CustomerDto customerDto) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(converter.dtoToMaster(customerDto));
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void deleteCustomer(CustomerDto customerDto) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(converter.dtoToMaster(customerDto));
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public CustomerDto getCustomerById(String customerCode){
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Master_Customer_16892 customer = session.get(Master_Customer_16892.class, customerCode);

        session.close();
        return converter.MasterToDto(customer);
    }

    @Override
    public List<CustomerDto> getAllCustomer() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        List<Master_Customer_16892> allCustomers = session.createQuery("FROM " +
                "Master_Customer_16892").getResultList();

        List<CustomerDto> customerDtoList = new ArrayList<>();

        for(Master_Customer_16892 customer : allCustomers){
            CustomerDto customerDto = converter.MasterToDto(customer);
            customerDtoList.add(customerDto);
        }
        session.close();
        return customerDtoList;
    }

    @Override
    public void updateCustomer(CustomerDto customerDto) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Master_Customer_16892 masterCustomer16892 = converter.dtoToMaster(customerDto);

        masterCustomer16892.setCustomerCode(customerDto.getCustomerCode());
        masterCustomer16892.setCustomerName(customerDto.getCustomerName());
        masterCustomer16892.setCustomerAddress1(customerDto.getCustomerAddress1());
        masterCustomer16892.setCustomerAddress2(customerDto.getCustomerAddress2());
        masterCustomer16892.setCustomerPinCode(customerDto.getCustomerPinCode());
        masterCustomer16892.setContactNumber(customerDto.getContactNumber());
        masterCustomer16892.setContactPerson(customerDto.getContactPerson());
        masterCustomer16892.setFlag(customerDto.getFlag());
        masterCustomer16892.setModifiedDate(customerDto.getModifiedDate());
        masterCustomer16892.setModifiedBy(customerDto.getModifiedBy());

        session.update(masterCustomer16892);

        session.getTransaction().commit();
        session.close();
    }

}
