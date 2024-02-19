package com.example.springbootrabbitmqtutorial.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.UUID;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User {

    UUID id;
    String name;
    String lastname;
}
