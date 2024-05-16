package com.controller;

import com.model.dto.CustomerDto;
import com.model.dto.FileUploadDto;
import com.service.serviceinterfaces.CustomerMasterServiceInterface;
import com.service.serviceinterfaces.CustomerTempServiceInterface;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.security.Principal;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

//@MultipartConfig
@Controller
@Log4j2
public class MakerController {

    @Autowired
    CustomerTempServiceInterface customerTempService ;

    @Autowired
    CustomerMasterServiceInterface customerMasterService;

    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    public String logout() {
        return "index";
    }

    @RequestMapping("/unauthorized")
    public String unauthorized() {
        return "unauthorized-user";
    }

    @RequestMapping("/maker-index")
    public ModelAndView makerIndex(@Valid @ModelAttribute("customer") CustomerDto customer,
                                   BindingResult bindingResult, Model model, Principal principal) {
        List<CustomerDto> customersList = customerTempService.callGetAllCustomersTempDao();
        model.addAttribute("customersList", customersList);
        List<CustomerDto> masterCustomersList = customerMasterService.callGetAllCustomersMasterDao();
        model.addAttribute("masterCustomersList", masterCustomersList);
        model.addAttribute("makerName", principal.getName());

        java.time.LocalDate date = LocalDate.now();

        if (bindingResult.hasErrors()) {
            return new ModelAndView("maker-home", "customer", customer);
        }
        else {
            customer.setRecordStatus("N");
            customer.setCreateDate(LocalDate.of(date.getYear(), date.getMonth(), date.getDayOfMonth()));
            customer.setCreatedBy(principal.getName());
            customerTempService.callInsertTempDao(customer);
            return new ModelAndView("maker-home");
        }
    }

    @RequestMapping("/checker-index")
    public String checkerIndex(Model model, Principal principal) {
        List<CustomerDto> customersList = customerTempService.callGetAllCustomersTempDao();
        model.addAttribute("customersList", customersList);
        model.addAttribute("checkerName", principal.getName());
        return "checker-home";
    }

    @RequestMapping("/upload-file")
    public String uploadCustomers(@ModelAttribute("fileDto") FileUploadDto dto){

        log.error("file : upload");
        return "uploadFile";
    }

    @PostMapping("/upload")
    @ResponseBody
    public String uploadFile(@RequestParam CommonsMultipartFile myFile){


        System.out.println("dhgjcjcjgsdjhgszchgjd : "+myFile);
//        String fileName = String.valueOf(file);
//        if (!file.isEmpty()) {
//            try {
//                byte[] bytes = file.getBytes();
//                BufferedOutputStream stream =
//                        new BufferedOutputStream(new FileOutputStream(new File(fileName + "-uploaded")));
//                stream.write(bytes);
//                stream.close();
//                return new ModelAndView("redirect:maker-index");
//            } catch (Exception e) {
//                return new ModelAndView("redirect:upload-file");
//            }
//        } else {
//            return new ModelAndView("redirect:upload-file");
//        }

        return "done";
    }

    @RequestMapping("/form")
    public String form(Model model){
        model.addAttribute("customer", new CustomerDto());
        return "registration-form";
    }

    @PostMapping(value = "/registered")
    public ModelAndView addCustomer(@Validated @ModelAttribute("customer") CustomerDto customer,
                                         BindingResult bindingResult, Principal principal) {
        java.time.LocalDate date = LocalDate.now();
//        try {
            if (bindingResult.hasErrors()) {
                return new ModelAndView("redirect:maker-index", "customer", customer);
            }
            else {
                customer.setRecordStatus("N");
                customer.setCreateDate(LocalDate.of(date.getYear(), date.getMonth(), date.getDayOfMonth()));
                customer.setCreatedBy(principal.getName());
                customerTempService.callInsertTempDao(customer);
                return new ModelAndView("redirect:maker-index");
            }
//        }
//        catch(Exception e){
//            ModelAndView modelAndView = new ModelAndView("exception-occurred");
//            modelAndView.addObject("error", e.getClass());
//            modelAndView.addObject("message", e.getMessage());
//            return modelAndView;
//        }
    }

    @RequestMapping(path = "/delete")
    public ModelAndView deleteCustomer(@RequestParam("customerCode") String customerCode,
                                       @RequestParam("status") String status, Principal principal){

        if(status.equals("A")) {
            java.time.LocalDate date = LocalDate.now();

            CustomerDto customerDto =
                    customerMasterService.callGetByIdMasterDao(customerCode);
            customerDto.setRecordStatus("D");
            customerDto.setModifiedDate(LocalDate.of(date.getYear(), date.getMonth(),
                    date.getDayOfMonth()));
            customerDto.setModifiedBy(principal.getName());
            customerTempService.callInsertTempDao(customerDto);
        }
        else {
            CustomerDto customerDto = customerTempService.callGetByIdTempDao(customerCode);
            customerTempService.callDeleteTempDao(customerDto);
        }
        return new ModelAndView("forward:maker-index");
    }

}
