package com.ftgo.orderservice.aggregrates;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import javax.persistence.*;

@JsonInclude(JsonInclude.Include.ALWAYS)
@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
@Table(name = "products")
@Data
public class Product {
    @Id
    private Long productId;
    private String productName;
    private String productDescription;

    @JoinTable
    @OneToMany
    private Price productPrice;
}
