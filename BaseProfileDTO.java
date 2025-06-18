package com.aryajohary.collegedirectory.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class BaseProfileDTO {
    private String username;
    private String password;
    private String name;
    private String email;
    private String phone;
}
