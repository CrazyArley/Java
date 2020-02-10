package com.arley.model;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
public class Person implements Serializable {
    private String name;
    private Integer age;
}
