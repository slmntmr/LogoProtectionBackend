package com.karataspartners.logoprotection.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TrademarkApplicationRequest {
    private String firstName;
    private String lastName;
    private String email;
    private String logoName;
    private String applicationDetails;
}
