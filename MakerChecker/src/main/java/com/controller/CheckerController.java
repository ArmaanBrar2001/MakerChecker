package com.controller;

import com.model.dto.CustomerDto;
import com.service.serviceinterfaces.ConverterInterface;
import com.service.serviceinterfaces.CustomerMasterServiceInterface;
import com.service.serviceinterfaces.CustomerTempServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.List;

@Controller
//@RequestMapping("/checker")
public class CheckerController {

    @Autowired
    CustomerTempServiceInterface customerTempService;

    @Autowired
    CustomerMasterServiceInterface customerMasterService;

    @RequestMapping("/approve")
    public ModelAndView approveNewCustomer(@RequestParam("customerCode") String customerCode,
                                           @RequestParam("status") String status,
                                           Principal principal, Model model){
        CustomerDto customerDto = customerTempService.callGetByIdTempDao(customerCode);

        if (status.equals("M")) {
            if(customerMasterService.callGetAllCustomersMasterDao().contains(customerMasterService.callGetByIdMasterDao(customerCode))) {
                customerDto.setAuthorizeDate(java.time.LocalDate.now());
                customerDto.setAuthorizedBy(principal.getName());
                customerDto.setRecordStatus("A");
                customerMasterService.callUpdateCustomerMasterDao(customerDto);
            }
            else {
                customerDto.setAuthorizeDate(java.time.LocalDate.now());
                customerDto.setAuthorizedBy(principal.getName());
                customerDto.setRecordStatus("A");
                customerMasterService.callInsertMasterDao(customerDto);
            }

            customerTempService.callDeleteTempDao(customerDto);
        }
        else if(status.equals("D")) {
            customerMasterService.callDeleteMasterDao(customerDto);

            customerTempService.callDeleteTempDao(customerDto);
        }
        else {
            customerDto.setAuthorizeDate(java.time.LocalDate.now());
            customerDto.setAuthorizedBy(principal.getName());
            customerDto.setRecordStatus("A");
            customerMasterService.callInsertMasterDao(customerDto);

            customerTempService.callDeleteTempDao(customerDto);
        }

        List<CustomerDto> customersList = customerTempService.callGetAllCustomersTempDao();
        model.addAttribute("customersList", customersList);

        return new ModelAndView("redirect:checker-index");
    }

    @RequestMapping(value = "/reject")
    public ModelAndView getChecker(@RequestParam("customerCode") String customerCode,
                                   @RequestParam("status") String status, Principal principal,
                                   Model model){
        CustomerDto customerDto = customerTempService.callGetByIdTempDao(customerCode);
        customerDto.setAuthorizeDate(java.time.LocalDate.now());
        customerDto.setAuthorizedBy(principal.getName());

        if(status.equals("N")){
            customerDto.setRecordStatus("NR");

            customerTempService.callUpdateTempDao(customerDto);
        }
        else if (status.equals("M")){
            customerDto.setRecordStatus("MR");

            customerTempService.callUpdateTempDao(customerDto);
        }
        else{
            customerDto.setRecordStatus("DR");

            customerTempService.callUpdateTempDao(customerDto);
        }

        List<CustomerDto> customersList = customerTempService.callGetAllCustomersTempDao();
        model.addAttribute("customersList", customersList);

        return new ModelAndView("redirect:checker-index");
    }



}
