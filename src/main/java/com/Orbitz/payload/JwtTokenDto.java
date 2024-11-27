package com.Orbitz.payload;

import lombok.Data;

@Data
public class JwtTokenDto {

    private String type;
    private String token;
}
