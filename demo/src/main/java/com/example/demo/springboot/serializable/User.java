package com.example.demo.springboot.serializable;

import lombok.Data;

import java.io.Serializable;
@Data
public class User implements Serializable {
    private static final long serializableUID = 1L;

    private int age;
    private String name;

}
