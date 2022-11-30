package com.pault.code;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Customer {
    private Integer id;
    private String name;
    private String email;
    private Integer age;
}
