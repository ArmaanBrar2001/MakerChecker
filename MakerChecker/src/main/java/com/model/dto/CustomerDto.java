package com.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Component;

import javax.validation.constraints.*;
import java.io.Serializable;
import java.time.LocalDate;

@NoArgsConstructor
@ToString
@AllArgsConstructor
@Data
@Component
public class CustomerDto implements Serializable {

    private static final long serialVersionUID = 63845652936L;

    private long customerId;

    @NotNull(message = "required")
    @Size(max = 10, message = "code length exceeded")
    private String customerCode;

    @NotNull(message = "required")
    @Size(max = 30, message = "name length cannot be more than 30 char")
    private String customerName;

    @NotNull(message = "required")
    @Size(max = 100, message = "address length cannot be more than 30 char")
    private String customerAddress1;

    @Size(max = 100, message = "address length cannot be more than 30 char")
    private String customerAddress2;

    @NotNull(message = "required")
    @Min(value = 100000, message = "invalid pin code")
    @Max(value = 999999, message = "invalid pin code")
    private int customerPinCode;

    @Pattern(regexp = ".+@.+\\..+", message = "invalid email")
    @Size(max = 100, message = "max length exceeded")
    @NotNull(message = "required")
    private String emailAddress;

    @Max(value = 999999999999999999L, message = "max length exceeded")
    private long contactNumber;

    @NotNull(message = "required")
    @Size(max = 100, message = "max length exceeded")
    private String contactPerson;

    private String recordStatus;

    @NotNull(message = "required")
    @Size(max = 1, message = "flag value can only be either A or I")
    private String flag;

    private LocalDate createDate;

    private String createdBy;

    private LocalDate modifiedDate;

    private String modifiedBy;

    private LocalDate authorizeDate;

    private String authorizedBy;



}
