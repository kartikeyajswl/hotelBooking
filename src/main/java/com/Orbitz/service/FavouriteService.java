package com.Orbitz.service;

import com.Orbitz.entity.User;
import com.Orbitz.payload.FavouriteDto;

import java.util.List;

public interface FavouriteService {
    FavouriteDto addFavourite(long propertyId, User user, FavouriteDto favouriteDto);

    FavouriteDto updateFavourite(long favouriteId, long propertyId, User user, FavouriteDto dto);

    List<FavouriteDto> getFavouriteByUser(User user);
}
