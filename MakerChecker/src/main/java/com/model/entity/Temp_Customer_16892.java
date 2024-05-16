package com.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@NoArgsConstructor
@ToString
@AllArgsConstructor
@Data
@Entity
@Component
@Table(name = "Temp_Customer_16892")
public class Temp_Customer_16892 implements Serializable {

    private static final long serialVersionUID = 876543223456L;

    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "Customer_Id", length = 10)
    private long customerId;

    @Id
    @Column(name = "Customer_Code", nullable = false, length = 10)
    private String customerCode;

    @Column(name = "Customer_Name", nullable = false, length = 30, columnDefinition = "varchar2" +
            "(30 char) CHECK (REGEXP_LIKE(Customer_Name,'^[A-Za-z0-9]'))")
    private String customerName;

    @Column(name = "Customer_Address1", nullable = false, length = 100)
    private String customerAddress1;

    @Column(name = "Customer_Address2", length = 100)
    private String customerAddress2;

    @Column(name = "Customer_Pin_Code", nullable = false, length = 6)
    private int customerPinCode;

    @Column(name = "Email_Address", nullable = false, length = 100, columnDefinition = "varchar2" +
            "(100 char) CHECK (REGEXP_LIKE(Email_Address,'[[:alnum:]]+@[[:alnum:]]+\\.[[:alnum:]]'))")
    private String emailAddress;

    @Column(name = "Contact_Number", length = 20)
    private long contactNumber;

    @Column(name = "Contact_Person", nullable = false, length = 100)
    private String contactPerson;

    @Column(name = "Record_Status", length = 1, columnDefinition = "varchar2(2" +
            " char) CHECK (Record_Status in ('N', 'M', 'D', 'A', 'R', 'MR', 'NR', 'DR'))")
    private String recordStatus;

    @Column(name = "Flag", nullable = false, length = 1)
    private String flag;

    @Column(name = "Create_Date", nullable = false)
    private LocalDate createDate;

    @Column(name = "Created_By", length = 30, nullable = false)
    private String createdBy;

    @Column(name = "Modified_Date")
    private LocalDate modifiedDate;

    @Column(name = "Modified_By", length = 30)
    private String modifiedBy;

    @Column(name = "Authorize_Date")
    private LocalDate authorizeDate;

    @Column(name = "Authorized_By", length = 30)
    private String authorizedBy;

}
