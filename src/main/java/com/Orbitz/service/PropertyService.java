package com.Orbitz.service;

import com.Orbitz.entity.User;
import com.Orbitz.payload.PropertyDto;

import java.util.List;

public interface PropertyService {

    PropertyDto registerProperty(long addressId, User user, PropertyDto dto);

    List<PropertyDto> searchProperties(String name, String city, String state, String country);

    PropertyDto updateProperty(long propertyId, long addressId, User user, PropertyDto dto);

    PropertyDto getPropertyById(long propertyId,User user);

    List<PropertyDto> getAllProperties(User user, int pageNo, int pageSize, String sortBy, String sortDir);

    void deleteRegisteredProperty(User user, long propertyId);
}
