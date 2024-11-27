package com.Orbitz.payload;

import com.Orbitz.entity.Property;
import com.Orbitz.entity.User;
import lombok.Data;

@Data
public class FavouriteDto {

    private Long id;
    private Boolean status;
    private User user;
    private Property property;
}
