package com.Orbitz.payload;

import com.Orbitz.entity.Property;
import com.Orbitz.entity.User;
import lombok.Data;

@Data
public class ReviewDto {

    private Long id;
    private Integer ratings;
    private String description;
    private User user;
    private Property property;
}
