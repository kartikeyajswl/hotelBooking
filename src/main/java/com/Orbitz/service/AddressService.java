package com.Orbitz.service;

import com.Orbitz.entity.User;
import com.Orbitz.payload.AddressDto;

public interface AddressService {
    AddressDto addAddress(AddressDto dto, User user);

    AddressDto updateAddress(long addressId, User user, AddressDto dto);
}
