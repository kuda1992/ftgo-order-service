package com.ftgo.orderservice.aggregrates;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.joda.money.Money;

import javax.persistence.*;
import java.util.List;

@JsonInclude(JsonInclude.Include.ALWAYS)
@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
@Table(name = "prices")
@Data
public class Price {

    @Id
    @GeneratedValue
    private Long priceId;
    private Money originalPrice;
    private List<Money> previousPrices;
    private Money offerPrice;
    @JoinTable
    @OneToMany
    private Product product;
}
