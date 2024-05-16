package com.controller;

import com.model.dto.CustomerDto;
import com.service.serviceinterfaces.CustomerMasterServiceInterface;
import com.service.serviceinterfaces.CustomerTempServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.security.Principal;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

@Controller
//@RequestMapping("/maker")
public class UpdateController {

    @Autowired
    CustomerTempServiceInterface customerTempService ;

    @Autowired
    CustomerMasterServiceInterface customerMasterService ;

    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @RequestMapping("/update")
    public ModelAndView updateCustomerForm(@RequestParam("customerCode") String customerCode,
                                           @RequestParam("status") String status, Model model){
        ModelAndView modelAndView = null;

        if(status.equals("A")){
            modelAndView = new ModelAndView("modified-update-form");

            CustomerDto customerMaster =
                    customerMasterService.callGetByIdMasterDao(customerCode);

            model.addAttribute("customer", customerMaster);
        }
        else {
            modelAndView = new ModelAndView("new-update-form");

            CustomerDto customerTemp = customerTempService.callGetByIdTempDao(customerCode);

            model.addAttribute("customer12", customerTemp);
        }

        return modelAndView;
    }

    @PostMapping(path = "/updated")
    public ModelAndView updateCustomer(@Valid @ModelAttribute("customer12") CustomerDto customer,
                                       BindingResult bindingResult, Principal principal) {
        java.time.LocalDate date = LocalDate.now();

        if(customer.getRecordStatus().equals("A")){
            if (!bindingResult.hasErrors()) {
                customer.setRecordStatus("M");
                customer.setModifiedDate(LocalDate.of(date.getYear(), date.getMonth(),
                        date.getDayOfMonth()));
                customer.setModifiedBy(principal.getName());

                customerTempService.callInsertTempDao(customer);
                return new ModelAndView("redirect:maker-index");
            }
            else {
                return new ModelAndView("modified-update-form");
            }
        }
        else {
            if (!bindingResult.hasErrors()) {
                customer.setRecordStatus("M");
                customer.setModifiedDate(LocalDate.of(date.getYear(), date.getMonth(), date.getDayOfMonth()));
                customer.setModifiedBy(principal.getName());

                customerTempService.callUpdateTempDao(customer);
                return new ModelAndView("redirect:maker-index");
            }
            else {
                return new ModelAndView("new-update-form");
            }
        }
    }

}
