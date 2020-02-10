package com.arley.model;


import lombok.*;

import java.io.Serializable;

@Getter
@Setter
public class Apple extends Fruit implements Serializable {
    private String desc;
}
