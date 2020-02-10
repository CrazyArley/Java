package com.arley.model;

import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
public class Fruit implements Serializable {
    private BigDecimal price;
}
