package com.ftgo.orderservice.aggregrates;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@JsonInclude(JsonInclude.Include.ALWAYS)
@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
@Table(name = "customers")
@Data
public class Customer {

    @Id
    @NotNull
    private long customerId;
    private String companyName;
    private String contactName;
    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    private String contactTitle;
    private String address;
    private String address1;
    private String address2;
    private String City;
    private String region;
    @NotNull
    private String postalCode;
    @NotNull
    private String country;
    private String phone;
    private String fax;
    @JoinTable
    @OneToMany
    private List<Order> orders;
}
