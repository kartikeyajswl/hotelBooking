package com.Orbitz.payload;

import com.Orbitz.entity.Property;
import com.Orbitz.entity.Room;
import com.Orbitz.entity.User;
import lombok.Data;

@Data
public class ImageDto {

    private Long id;
    private String imageUrl;
    private Property property;
    private User user;
    private Room room;
}
